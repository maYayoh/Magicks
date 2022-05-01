package fr.mayayoh.magick.event;

import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickRegistry;
import fr.mayayoh.magick.util.lib.MagickLib;
import fr.mayayoh.magick.util.lib.RandomLib;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class SpellEvent implements Listener {
    @EventHandler
    public void onPlayerSwapItem(final PlayerSwapHandItemsEvent e) {
        final Player p = e.getPlayer();
        if (p.isSneaking()) {
            e.setCancelled(true);

            final MagickRegistry m = MagickRegistry.getInstance();
            if (m.isPlayerInMagick(p)) {
                m.loadInventory(p);
                m.setMode(p, false);
            } else {
                m.saveInventory(p);
                m.setMode(p, true);
                for (int i = 0; i < 9; i++) {
                    p.getInventory().setItem(i, MagickLib.getSpellConfig(p)[i]);
                }
                for (int i = 10; i < 36; i++) {
                    p.getInventory().setItem(i, null);
                }

                final Material[] sgp = new Material[]{Material.WHITE_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE};
                final ItemStack defaultSeparator = ItemBuilder.createItem(Material.BLACK_STAINED_GLASS_PANE);
                final ItemStack randomSeparator = ItemBuilder.createItem(sgp[RandomLib.randomInteger(sgp.length - 1)]);
                final int[] defaultSepPos = new int[]{9, 11, 13, 15, 17, 27, 29, 31, 33, 35};
                final int[] randomSepPos = new int[]{10, 12, 14, 16, 18, 26, 28, 30, 32, 34};

                for (int pos : defaultSepPos) p.getInventory().setItem(pos, defaultSeparator);
                for (int pos : randomSepPos) p.getInventory().setItem(pos, randomSeparator);

                p.getInventory().setItem(22, ItemBuilder.createItem(Material.PAPER, 1, true, ChatColor.RESET + "Press Shift+F to quit Magick Mode", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + "Click outside your inventory", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + "window to preview your inventory."));
            }
        }
    }
}

