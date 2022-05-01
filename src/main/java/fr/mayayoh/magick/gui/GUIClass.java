package fr.mayayoh.magick.gui;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.util.MagickRegistry;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class GUIClass {
    protected Inventory inv;
    @Getter protected final Player viewer;

    public GUIClass(final Player v) {
        this.viewer = v;
        Bukkit.getScheduler().runTaskLater(MagickPlugin.getInstance(), this::registerInventory, 1);
    }

    public void openInventory() {
        this.viewer.openInventory(inv);
    }
    protected void registerInventory() { MagickRegistry.getInstance().setCurrentMenu(viewer, this); }

    public abstract void onClick(final InventoryClickEvent e);
    protected abstract void createInventory();
}
