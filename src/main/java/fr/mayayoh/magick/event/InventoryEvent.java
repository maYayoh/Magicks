package fr.mayayoh.magick.event;

import fr.mayayoh.magick.gui.GUIClass;
import fr.mayayoh.magick.util.MagickRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryEvent implements Listener {

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        final Player v = (Player) e.getWhoClicked();

        if (MagickRegistry.getInstance().isPlayerInMagick(v)) {
            e.setCancelled(true);
        } else {
            final GUIClass menu = MagickRegistry.getInstance().getCurrentMenu(v);
            if (menu != null) {
                e.setCancelled(true);
                menu.onClick(e);
            }
        }
    }


    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent e) {
        final Player v = (Player) e.getPlayer();

        if (MagickRegistry.getInstance().isPlayerInPreview(v)) {
            MagickRegistry.getInstance().setPreview(v, false);
        } else {
            final GUIClass menu = MagickRegistry.getInstance().getCurrentMenu(v);
            if (menu != null)
                MagickRegistry.getInstance().removeCurrentMenu(v);
        }
    }

}