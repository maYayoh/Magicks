package fr.mayayoh.magick.gui.playerinfo;

import fr.mayayoh.magick.gui.GUIClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import fr.mayayoh.magick.util.lib.MagickLib;
import fr.mayayoh.magick.util.lib.RandomLib;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerInfoMenu extends GUIClass {

    private final Player player;

    public PlayerInfoMenu(final Player viewer, final Player player) {
        super(viewer);
        this.player = player;
        createInventory();
    }

    @Override
    public void onClick(final InventoryClickEvent e) {
        final Player p = Bukkit.getPlayer(player.getName());
        try {
            switch (e.getRawSlot()) {
                case 4 -> {
                    assert p != null;
                    final LevelEditorMenu levelEditorMenu = new LevelEditorMenu(viewer, p);
                    levelEditorMenu.openInventory();
                }
                case 11, 15 -> {
                    assert p != null;
                    final ChangeMagickMenu changeMagickMenu = new ChangeMagickMenu(viewer, p, e.getRawSlot() == 11);
                    changeMagickMenu.openInventory();
                }
                default -> { }
            }
        } catch (final AssertionError ex) {
            viewer.closeInventory();
            viewer.sendMessage(ChatColor.GOLD + "/!\\ " + ChatColor.RESET + ChatColor.BOLD + player.getName() + ChatColor.RESET + ChatColor.RED + " isn't online anymore.");
        }
    }

    @Override
    protected void createInventory() {
        inv = Bukkit.createInventory(null, 36, ChatColor.BLACK.toString() + ChatColor.BOLD + player.getName() + ChatColor.RESET + "'s Magick Info");

        final MagickTypeEnum firstType = MagickLib.getMagickType(player, true);
        final MagickTypeEnum secondType = MagickLib.getMagickType(player, false);

        final Material[] sgp = new Material[]{Material.ORANGE_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE};
        final ItemStack defaultSeparator = ItemBuilder.createItem(Material.WHITE_STAINED_GLASS_PANE);
        final ItemStack randomSeparator = ItemBuilder.createItem(sgp[RandomLib.randomInteger(sgp.length - 1)]);
        final int[] defaultSepPos = new int[]{0, 2, 6, 8, 18, 20, 24, 26};
        final int[] randomSepPos = new int[]{1, 3, 5, 7, 9, 17, 19, 25};

        for(int pos : defaultSepPos) inv.setItem(pos, defaultSeparator);
        for(int pos : randomSepPos) inv.setItem(pos, randomSeparator);

        final ItemStack playerIcon = ItemBuilder.createItem(Material.PLAYER_HEAD, 1, false,
                ChatColor.RESET.toString() + ChatColor.GRAY + ChatColor.BOLD + player.getName() + ChatColor.RESET + "'s Magick Profile" ,
                ChatColor.RESET.toString() + firstType + ChatColor.RESET + " Lv." + MagickLib.getMagickData("first.level", player),
                ChatColor.RESET.toString() + secondType + ChatColor.RESET + " Lv." + MagickLib.getMagickData("second.level", player),
                "", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Click to change levels");

        final SkullMeta iconMeta = (SkullMeta) playerIcon.getItemMeta();
        Validate.notNull(iconMeta, "The ItemStack doesn't have any ItemMeta.");
        iconMeta.setOwningPlayer(player);
        playerIcon.setItemMeta(iconMeta);
        inv.setItem(4, playerIcon);

        int essCount = Integer.parseInt(MagickLib.getMagickData("first.essences", player));
        inv.setItem(11, firstType.getRelativeIcon(essCount,
                ChatColor.RESET.toString() + ChatColor.BOLD + essCount + " " + firstType + " Essences",
                ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Click to change first Magick Type"));

        essCount = Integer.parseInt(MagickLib.getMagickData("second.essences", player));
        inv.setItem(15, secondType.getRelativeIcon(essCount,
                ChatColor.RESET.toString() + ChatColor.BOLD + essCount + " " + secondType + " Essences",
                ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Click to change second Magick Type"));

        final ItemStack[] spellConfig = MagickLib.getSpellConfig(player);
        for(int i=27; i<36; i++)
            inv.setItem(i, spellConfig[i%9] != null ? spellConfig[i%9] : ItemBuilder.createItem(Material.BARRIER));
    }
}
