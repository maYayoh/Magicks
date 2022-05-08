package fr.mayayoh.magick.event;

import fr.mayayoh.magick.util.MagickRegistry;
import fr.mayayoh.magick.util.MagickTypeEnum;
import fr.mayayoh.magick.util.lib.MagickLib;
import org.bukkit.FluidCollisionMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class GatherEvent implements Listener {

    @EventHandler
    public void onPlayerSneak(final PlayerToggleSneakEvent e) {
        if (!e.isSneaking())
            MagickRegistry.getInstance().removeGatherInfo(e.getPlayer());
    }

    @EventHandler
    public void onPlayerDestroyBlock(final BlockBreakEvent e) {
        if (MagickRegistry.getInstance().getGatherInfo(e.getPlayer()) != null)
            e.setCancelled(true);
    }


    public static void startGathering(final Player player) {
        final MagickRegistry registry = MagickRegistry.getInstance();
        final Block block = player.getTargetBlockExact(4, FluidCollisionMode.ALWAYS);
        if (block != null) {
            final MagickTypeEnum blockType = MagickTypeEnum.getTypeFromBlock(block);

            if (blockType == MagickLib.getMagickType(player, true) || blockType == MagickLib.getMagickType(player, false))
                if (playerHaveEnergy(player))
                    registry.setGatherInfo(player, player.getTargetBlockExact(4, FluidCollisionMode.ALWAYS), 5 * 20);
        }
    }

    public static boolean playerHaveEnergy(final Player player) {
        if (player.getSaturation() >= 5)
            player.setSaturation(player.getSaturation() - 5f);
        else {
            player.setSaturation(0);
            if (player.getFoodLevel() > 2)
                player.setFoodLevel(player.getFoodLevel() - 2);
            else if (player.getFoodLevel() < 2) {
                final int healthCost = 2 - player.getFoodLevel();
                player.setFoodLevel(0);
                if (player.getHealth() - healthCost > 0d)
                    player.damage(healthCost);
                else
                    return false;
            } else player.setFoodLevel(0);
        }
        return true;
    }
}
