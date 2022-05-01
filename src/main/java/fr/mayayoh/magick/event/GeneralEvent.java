package fr.mayayoh.magick.event;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.util.MagickRegistry;
import fr.mayayoh.magick.util.lib.RandomLib;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class GeneralEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {

        if (MagickPlugin.getInstance().getData().getString("players." + e.getPlayer().getUniqueId()) == null) {
            e.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "+" + ChatColor.GOLD + "] " + e.getPlayer().getName());

            final int newPlayerFirstMagic = RandomLib.randomInteger(1, 6);
            int newPlayerSecondMagic;
            do {
                newPlayerSecondMagic = RandomLib.randomInteger(1, 6);
            } while (newPlayerFirstMagic == newPlayerSecondMagic);

            final String key = "players." + e.getPlayer().getUniqueId() + ".magic.";

            MagickPlugin.getInstance().getData().set(key + "first.type", newPlayerFirstMagic);
            MagickPlugin.getInstance().getData().set(key + "first.level", 0);
            MagickPlugin.getInstance().getData().set(key + "first.xp", 9);
            MagickPlugin.getInstance().getData().set(key + "first.essences", 0);
            MagickPlugin.getInstance().getData().set(key + "first.spells.master", false);

            MagickPlugin.getInstance().getData().set(key + "second.type", newPlayerSecondMagic);
            MagickPlugin.getInstance().getData().set(key + "second.level", 0);
            MagickPlugin.getInstance().getData().set(key + "second.xp", 0);
            MagickPlugin.getInstance().getData().set(key + "second.essences", 0);
            MagickPlugin.getInstance().getData().set(key + "second.spells.master", false);

            for (int i=1; i<10; i++) {
                MagickPlugin.getInstance().getData().set(key + "first.spells." + i + ".slot", -1);
                MagickPlugin.getInstance().getData().set(key + "second.spells." + i + ".slot", -1);
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
        e.setQuitMessage("[" + ChatColor.RED + "-" + ChatColor.RESET + "] " + e.getPlayer().getName());
        if (MagickRegistry.getInstance().isPlayerInMagick(e.getPlayer())) {
            MagickRegistry.getInstance().loadInventory(e.getPlayer());
            MagickRegistry.getInstance().setMode(e.getPlayer(), false);
        }

        try {
            MagickPlugin.getInstance().saveData();
        } catch (final IOException ex) {
            ex.printStackTrace();
            MagickPlugin.getInstance().getPluginLoader().disablePlugin(MagickPlugin.getInstance());
        }
    }
}
