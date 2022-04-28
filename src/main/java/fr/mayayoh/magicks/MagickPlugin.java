package fr.mayayoh.magicks;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MagickPlugin extends JavaPlugin implements Listener {

    @Getter private static MagickPlugin instance;
    @Getter private FileConfiguration data;

    @Override
    public void onEnable() {
        MagickPlugin.instance = this;

//        this.getCommand("magick").setExecutor(new CommandMagick());
//        this.getCommand("playerinfo").setExecutor(new CommandPlayerInfo());
//        this.getCommand("editspells").setExecutor(new CommandEditSpells());
//
//        Bukkit.getServer().getPluginManager().registerEvents(new GeneralEvents(), this);
//        Bukkit.getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
//        Bukkit.getServer().getPluginManager().registerEvents(new SpellsEvents(), this);


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
            if(dataFile.getParentFile().mkdirs())
                // If not, create it
                saveResource("magickData.yml", false);
            else
                // If fail to get the parent folder (for some reason), disable the plugin
                this.getPluginLoader().disablePlugin(this);
        }

        // Load the data from the file in a variable
        data = new YamlConfiguration();
        try {
            data.load(dataFile);
        } catch (final IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            // If fail to load the data, disable the plugin
            this.getPluginLoader().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {}

    public void saveData() throws IOException {
        data.save(getDataFolder() + "/data.yml");
    }
}
