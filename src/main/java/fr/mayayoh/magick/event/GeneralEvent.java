package fr.mayayoh.magick.event;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.util.MagickRegistry;
import fr.mayayoh.magick.util.lib.RandomLib;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class GeneralEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();

        if (MagickPlugin.getInstance().getData().getString("players." + player.getUniqueId()) == null) {
            e.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "+" + ChatColor.GOLD + "] " + player.getName());

            final int newPlayerFirstMagic = RandomLib.randomInteger(1, 6);
            int newPlayerSecondMagic;
            do {
                newPlayerSecondMagic = RandomLib.randomInteger(1, 6);
            } while (newPlayerFirstMagic == newPlayerSecondMagic);

            final FileConfiguration data = MagickPlugin.getInstance().getData();
            final String key = "players." + player.getUniqueId() + ".magic.";

            data.set(key + "first.type", String.valueOf(newPlayerFirstMagic));
            data.set(key + "first.level", 0);
            data.set(key + "first.xp", 9);
            data.set(key + "first.essences", 0);
            data.set(key + "first.spells.master", false);

            data.set(key + "second.type", String.valueOf(newPlayerSecondMagic));
            data.set(key + "second.level", 0);
            data.set(key + "second.xp", 0);
            data.set(key + "second.essences", 0);
            data.set(key + "second.spells.master", false);

            for (int i=1; i<10; i++) {
                data.set(key + "first.spells." + i + ".slot", -1);
                data.set(key + "second.spells." + i + ".slot", -1);
            }

            try {
                MagickPlugin.getInstance().saveData();
            } catch (final IOException ex) {
                ex.printStackTrace();
                MagickPlugin.getInstance().getPluginLoader().disablePlugin(MagickPlugin.getInstance());
            }

        } else {
            e.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + e.getPlayer().getName());
        }
    }

    @EventHandler
    public void onPlayerLeave(final PlayerQuitEvent e) {
        final Player player = e.getPlayer();

        e.setQuitMessage("[" + ChatColor.RED + "-" + ChatColor.RESET + "] " + e.getPlayer().getName());
        if (MagickRegistry.getInstance().isPlayerInMagick(player)) {
            MagickRegistry.getInstance().loadInventory(player);
            MagickRegistry.getInstance().setMode(player, false);
        }

        MagickRegistry.getInstance().removeCurrentMenu(player);
        MagickRegistry.getInstance().removeGatherInfo(player);

        try {
            MagickPlugin.getInstance().saveData();
        } catch (final IOException ex) {
            ex.printStackTrace();
            MagickPlugin.getInstance().getPluginLoader().disablePlugin(MagickPlugin.getInstance());
        }
    }

    @EventHandler
    public void onPlayerDeath(final PlayerDeathEvent e) {
        final Player player = e.getEntity();
        final MagickRegistry registry = MagickRegistry.getInstance();

        if (registry.isPlayerInMagick(player)) {
            e.getDrops().clear();
            e.getDrops().addAll(Arrays.asList(Objects.requireNonNull(registry.getBackup(player))));

            registry.removeBackup(player);
            registry.setMode(player, false);
        }
    }

}
