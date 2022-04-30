package fr.mayayoh.magick.gui;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class GUIClass {
    protected Inventory inv;
    @Getter protected final Player viewer;

    public GUIClass(final Player v) { this.viewer = v; }

    public void openInventory() {
        this.viewer.openInventory(inv);
    }

    public abstract void onClick(final InventoryClickEvent e);
    protected abstract void createInventory();
}
