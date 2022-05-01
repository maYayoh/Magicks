package fr.mayayoh.magick.gui.playerinfo;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.gui.GUIClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import fr.mayayoh.magick.util.lib.MagickLib;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.IOException;

public class LevelEditorMenu extends GUIClass {

    private final Player player;
    final MagickTypeEnum firstType;
    final MagickTypeEnum secondType;

    public LevelEditorMenu(final Player v, final Player p) {
        super(v);
        this.player = p;
        this.firstType = MagickLib.getMagickType(player, true);
        this.secondType = MagickLib.getMagickType(player, false);
        createInventory();
    }

    @Override
    public void onClick(final InventoryClickEvent e) {
        final Player p = Bukkit.getPlayer(player.getName());
        if (e.getCurrentItem() != null) {
            try {
                switch (e.getRawSlot()) {
                    case 13 -> {
                        assert p != null;
                        final PlayerInfoMenu playerInfoMenu = new PlayerInfoMenu(viewer, player);
                        playerInfoMenu.openInventory();
                    }
                    case 2, 6 -> {
                        assert p != null;
                        if (e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)) {
                            final String path = e.getRawSlot() == 2 ? "first.level" : "second.level";
                            MagickLib.setMagickData(p, path, String.valueOf(Integer.parseInt(MagickLib.getMagickData(path, p)) + 1));
                            MagickPlugin.getInstance().saveData();

                            updateLevelItems();
                        }
                    }
                    case 20, 24 -> {
                        assert p != null;
                        if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)) {
                            final String path = e.getRawSlot() == 20 ? "first.level" : "second.level";
                            MagickLib.setMagickData(p, path, String.valueOf(Integer.parseInt(MagickLib.getMagickData(path, p)) - 1));
                            MagickPlugin.getInstance().saveData();

                            updateLevelItems();
                        }
                    }
                    default -> { }
                }
            } catch (final AssertionError | IOException ex) {
                viewer.sendMessage(ChatColor.GOLD + "/!\\ " + ChatColor.RESET + ChatColor.BOLD + player.getName() + ChatColor.RESET + ChatColor.RED + " isn't online anymore.");
            }
        }
    }

    @Override
    protected void createInventory() {
        inv = Bukkit.createInventory(null, 27, "Modify " + player.getName() + "'s Levels");

        final ItemStack separator = ItemBuilder.createItem(Material.WHITE_STAINED_GLASS_PANE);
        final int[] sepPos = {0, 8, 9, 17, 18, 26};

        for(int pos : sepPos) inv.setItem(pos, separator);

        updateLevelItems();
    }


    private void updateLevelItems() {
        final int p1Lvl = Integer.parseInt(MagickLib.getMagickData("first.level", player));
        final int p2Lvl = Integer.parseInt(MagickLib.getMagickData("second.level", player));

        final ItemStack playerIcon = ItemBuilder.createItem(Material.PLAYER_HEAD, 1, false,
                ChatColor.RESET.toString() + ChatColor.GRAY + ChatColor.BOLD + player.getName() + ChatColor.RESET + "'s Magick Profile" ,
                ChatColor.RESET.toString() + firstType + ChatColor.RESET + " Lv." + (p1Lvl == 21 ? "Master" : p1Lvl),
                ChatColor.RESET.toString() + secondType + ChatColor.RESET + " Lv." + p2Lvl,
                "", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Click to see profile");

        final SkullMeta iconMeta = (SkullMeta) playerIcon.getItemMeta();
        Validate.notNull(iconMeta, "The ItemStack doesn't have any ItemMeta.");
        iconMeta.setOwningPlayer(player);
        playerIcon.setItemMeta(iconMeta);
        inv.setItem(13, playerIcon);

        inv.setItem(2, ItemBuilder.createItem(p1Lvl != 21 ? Material.LIME_STAINED_GLASS_PANE : Material.LIME_STAINED_GLASS, 1, false, ChatColor.RESET + (p1Lvl != 21 ? ChatColor.GREEN + "+1" : ChatColor.DARK_GREEN + "LEVEL MAX")));
        inv.setItem(6, ItemBuilder.createItem(p2Lvl != 20 ? Material.LIME_STAINED_GLASS_PANE : Material.LIME_STAINED_GLASS, 1, false, ChatColor.RESET + (p2Lvl != 20 ? ChatColor.GREEN + "+1" : ChatColor.DARK_GREEN + "LEVEL MAX")));

        inv.setItem(20, ItemBuilder.createItem(p1Lvl != 0 ? Material.RED_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS, 1, false, ChatColor.RESET + (p1Lvl != 0 ? ChatColor.RED + "-1" : ChatColor.DARK_RED + "LEVEL MIN")));
        inv.setItem(24, ItemBuilder.createItem(p2Lvl != 0 ? Material.RED_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS, 1, false, ChatColor.RESET + (p2Lvl != 0 ? ChatColor.RED + "-1" : ChatColor.DARK_RED + "LEVEL MIN")));

        inv.setItem(11, firstType.getIcon(ChatColor.RESET + "Current " + firstType +
                ChatColor.RESET + " Level: " + (p1Lvl == 21 ? "Master" : p1Lvl)));

        inv.setItem(15, secondType.getIcon(ChatColor.RESET + "Current " + secondType + ChatColor.RESET + " Level: " + p2Lvl));

    }
}
