package fr.mayayoh.magick;

import fr.mayayoh.magick.command.EditSpellCommand;
import fr.mayayoh.magick.command.MagickCommand;
import fr.mayayoh.magick.command.PlayerInfoCommand;
import fr.mayayoh.magick.event.GatherEvent;
import fr.mayayoh.magick.event.GeneralEvent;
import fr.mayayoh.magick.event.InventoryEvent;
import fr.mayayoh.magick.event.SpellEvent;
import fr.mayayoh.magick.util.AutoSave;
import fr.mayayoh.magick.util.GatherLoop;
import fr.mayayoh.magick.util.MagickRegistry;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


/**
 * MagickPlugin class used as the main class.
 *
 * @author maYayoh
 * @version 1.0
 */
public final class MagickPlugin extends JavaPlugin implements Listener {

    @Getter private static MagickPlugin instance;
    @Getter private FileConfiguration data;

    @Override
    public void onEnable() {
        MagickPlugin.instance = this;

        Objects.requireNonNull(this.getCommand("magick")).setExecutor(new MagickCommand());
        Objects.requireNonNull(this.getCommand("playerinfo")).setExecutor(new PlayerInfoCommand());
        Objects.requireNonNull(this.getCommand("editspells")).setExecutor(new EditSpellCommand());

        Bukkit.getServer().getPluginManager().registerEvents(new GeneralEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SpellEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GatherEvent(), this);

        new GatherLoop().runTaskTimer(this, 10, 5);


        // Create plugin folder

        // Check if the folder already exists
        if (!getDataFolder().exists())
            // If not, create it
            if(!getDataFolder().mkdir())
                // If fail to create, disable the plugin
                this.getPluginLoader().disablePlugin(this);

        // Create data file
        final File dataFile = new File(getDataFolder(), "magickData.yml");

        // Check if the file already exists
        if (!dataFile.exists()) {
            // If not, create it
            saveResource("magickData.yml", true);
        }

        // Load the data from the file in a variable
        data = new YamlConfiguration();
        try {
            data.load(dataFile);
        } catch (final IOException | InvalidConfigurationException ex) {
            ex.printStackTrace();
            // If fail to load the data, disable the plugin
            this.getPluginLoader().disablePlugin(this);
        }

        new AutoSave().runTaskTimer(this, 10, 5*60*20); // Save every 5 minutes
    }

    @SneakyThrows
    @Override
    public void onDisable() {

        Bukkit.getServer().getOnlinePlayers().forEach(player -> {

            if (MagickRegistry.getInstance().isPlayerInMagick(player))
                MagickRegistry.getInstance().loadInventory(player);

        });

        this.saveData();
    }

    public void saveData() throws IOException {
        data.save(getDataFolder() + "/magickData.yml");
    }
}
