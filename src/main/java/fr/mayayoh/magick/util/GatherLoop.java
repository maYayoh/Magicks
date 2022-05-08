package fr.mayayoh.magick.util;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.event.GatherEvent;
import fr.mayayoh.magick.util.lib.GeometryLib;
import fr.mayayoh.magick.util.lib.MagickLib;
import fr.mayayoh.magick.util.lib.RandomLib;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class GatherLoop extends BukkitRunnable {
    @Override
    public void run() {
        final MagickRegistry registry = MagickRegistry.getInstance();
        final Iterator<Map.Entry<UUID, Map<String, Object>>> iterator = registry.getGatheringInfo().entrySet().iterator();

        iterator.forEachRemaining(entry -> {
            final Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                final Block block = (Block) entry.getValue().get("block");
                if (block.equals(player.getTargetBlockExact(4, FluidCollisionMode.SOURCE_ONLY))) {

                    final int timer = ((int) entry.getValue().get("timer")) - 5;
                    final MagickTypeEnum type = MagickTypeEnum.getTypeFromBlock(block);
                    final Location position = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 1, block.getZ() + 0.5);

                    if (timer <= 0) {
                        registry.removeGatherInfo(player);
                        if (GatherEvent.playerHaveEnergy(player)) {
                            block.setType(Material.AIR, true);

                            player.spawnParticle(Particle.EXPLOSION_LARGE, position, 1, 0, 0, 0, 0);
                            player.playSound(position, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1, ((float) RandomLib.randomInteger(50, 150)) / 100);
                            final String path = MagickLib.getMagickType(player, true) == type ? "first.essences" : "second.essences";
                            MagickLib.setMagickData(player, path, String.valueOf(Integer.parseInt(MagickLib.getMagickData(path, player)) + 1));

                            Bukkit.getScheduler().runTaskLater(MagickPlugin.getInstance(), () -> GatherEvent.startGathering(player), 5);
                        } else {
                            Objects.requireNonNull(position.getWorld()).spawnParticle(Particle.BARRIER, position, 1, 0, 0, 0, 0);
                            player.playSound(position, Sound.ENTITY_VILLAGER_NO, SoundCategory.BLOCKS, 1, ((float) RandomLib.randomInteger(50, 150)) / 100);
                        }
                    } else {
                        registry.setGatherInfo(player, block, timer);
                        player.playSound(position, Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.BLOCKS, 0.5f, ((float) RandomLib.randomInteger(50, 150)) / 100);
                        final Location[] blockOutline = GeometryLib.getCubeOutline(block.getLocation(), (20 / timer) + 5);
                        for (Location l : blockOutline) {
                            Objects.requireNonNull(l.getWorld()).spawnParticle(type.getParticle(), l, 1, 0, 0, 0, 0);
                        }
                    }
                } else GatherEvent.startGathering(player);
            }
        });
    }



}
