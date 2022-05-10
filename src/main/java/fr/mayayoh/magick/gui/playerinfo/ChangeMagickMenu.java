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

public class ChangeMagickMenu extends GUIClass {

    private final Player player;
    private final boolean isFirstType;

    public ChangeMagickMenu(final Player viewer, final Player player, final boolean isFirstType) {
        super(viewer);
        this.player = player;
        this.isFirstType = isFirstType;
        createInventory();
    }

    @Override
    public void onClick(final InventoryClickEvent e) {
        final Player p = Bukkit.getPlayer(player.getName());

        try {
            switch (e.getRawSlot()) {
                case 15, 16, 24, 25, 33, 34 -> {
                    assert p != null;
                    MagickLib.setMagickData(p, (isFirstType ? "first" : "second") + ".type", String.valueOf(e.getRawSlot() / 9 * 2 + e.getRawSlot() % 9 / 7 - 1));
                    final PlayerInfoMenu menu = new PlayerInfoMenu(viewer, p);
                    menu.openInventory();
                }
                default -> { }
            }
        } catch (final AssertionError ex) {
            viewer.sendMessage(ChatColor.GOLD + "/!\\ " + ChatColor.RESET + ChatColor.BOLD + player.getName() + ChatColor.RESET + ChatColor.RED + " isn't online anymore.");
        }
    }

    @Override
    protected void createInventory() {
        inv = Bukkit.createInventory(null, 45, "Change " + player.getName() + "'s Magick");

        final String magicNumber = isFirstType ? "first" : "second";
        final MagickTypeEnum magicType = MagickLib.getMagickType(player, isFirstType);
        final ItemStack separator = ItemBuilder.createItem(Material.WHITE_STAINED_GLASS_PANE);
        final int[] sepPos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 31, 36, 37, 38, 39, 40, 41, 42, 43, 44};

        for(int pos : sepPos) inv.setItem(pos, separator);

        final ItemStack playerIcon = ItemBuilder.createItem(Material.PLAYER_HEAD, 1, false,
                ChatColor.RESET.toString() + ChatColor.GRAY + ChatColor.BOLD + player.getName() + ChatColor.RESET + "'s " + magicNumber + " Magick");

        final SkullMeta iconMeta = (SkullMeta) playerIcon.getItemMeta();
        Validate.notNull(iconMeta, "The ItemStack doesn't have any ItemMeta.");
        iconMeta.setOwningPlayer(player);
        playerIcon.setItemMeta(iconMeta);
        inv.setItem(19, playerIcon);

        inv.setItem(20, magicType.getIcon(ChatColor.RESET + "Current Magick: " + magicType));

        inv.setItem(22, ItemBuilder.getCustomHead("956a3618459e43b287b22b7e235ec699594546c6fcd6dc84bfca4cf30ab9311"));

        inv.setItem(15, MagickTypeEnum.FIRE.getIcon(ChatColor.RESET + "Switch to " + MagickTypeEnum.FIRE));
        inv.setItem(16, MagickTypeEnum.WATER.getIcon(ChatColor.RESET + "Switch to " + MagickTypeEnum.WATER));
        inv.setItem(24, MagickTypeEnum.PLANT.getIcon(ChatColor.RESET + "Switch to " + MagickTypeEnum.PLANT));
        inv.setItem(25, MagickTypeEnum.EARTH.getIcon(ChatColor.RESET + "Switch to " + MagickTypeEnum.EARTH));
        inv.setItem(33, MagickTypeEnum.LIGHT.getIcon(ChatColor.RESET + "Switch to " + MagickTypeEnum.LIGHT));
        inv.setItem(34, MagickTypeEnum.DEATH.getIcon(ChatColor.RESET + "Switch to " + MagickTypeEnum.DEATH));
    }
}
