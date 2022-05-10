package fr.mayayoh.magick.util;

import fr.mayayoh.magick.MagickPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;

public class AutoSave extends BukkitRunnable {
    @Override
    public void run() {
        try {
            MagickPlugin.getInstance().saveData();
        } catch (final IOException ex) {
            ex.printStackTrace();
            MagickPlugin.getInstance().getPluginLoader().disablePlugin(MagickPlugin.getInstance());
        }
    }
}
