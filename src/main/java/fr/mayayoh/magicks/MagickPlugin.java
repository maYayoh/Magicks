package fr.mayayoh.magicks;

import fr.mayayoh.magicks.event.GeneralEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


/**
 * MagickPlugin class used as the main class.
 *
 * @author maYayoh
 * @version 1.0
 */
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
        Bukkit.getServer().getPluginManager().registerEvents(new GeneralEvent(), this);
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
            // If not, create it
            final boolean ignored = dataFile.getParentFile().mkdirs();
            saveResource("magickData.yml", false);
        }

        System.out.println(dataFile.getAbsolutePath());

        // Load the data from the file in a variable
        data = new YamlConfiguration();
        try {
            data.load(dataFile);
        } catch (final IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            // If fail to load the data, disable the plugin
            this.getPluginLoader().disablePlugin(this);
        }

        //DEBUG: remove message
        Bukkit.broadcastMessage("[!]"+ChatColor.GREEN+" Magicks has been enabled!");
    }

    @Override
    public void onDisable() {
        //DEBUG: remove message
        Bukkit.broadcastMessage("[!]"+ChatColor.RED+" Magicks has been disabled!");
    }

    public void saveData() throws IOException {
        data.save(getDataFolder() + "/magickData.yml");
    }
}
