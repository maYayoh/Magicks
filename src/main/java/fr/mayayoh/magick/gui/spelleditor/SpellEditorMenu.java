package fr.mayayoh.magick.gui.spelleditor;

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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.Objects;

public class SpellEditorMenu extends GUIClass {

    private boolean spellSelected;

    public SpellEditorMenu(final Player viewer) {
        super(viewer);
        spellSelected = false;
        createInventory();
    }

    @Override
    public void onClick(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null) {
            if (!spellSelected) {
                if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD) && e.getRawSlot() >= 9) {
                    Validate.notNull(e.getCurrentItem().getItemMeta(), "The ItemStack doesn't have any ItemMeta.");
                    if (e.getRawSlot() >= 45) {
                        removeSpellFromSlot(e.getRawSlot());
                        updateSpellsShown();
                    } else if (!ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Locked")) {
                        spellSelected = true;
                        final ItemStack selectedSpell = e.getCurrentItem().clone();
                        updateSpellsShown();
                        inv.setItem(e.getRawSlot(), selectedSpell);
                    }
                }
            } else if (e.getRawSlot() >= 45) {
                final int[] spellsSlots = new int[]{10, 11, 12, 14, 15, 16, 19, 20, 21, 23, 24, 25, 28, 29, 30, 32, 33, 34};
                for (int i : spellsSlots) {
                    if (Objects.requireNonNull(e.getInventory().getItem(i)).getType().equals(Material.PLAYER_HEAD)) {
                        removeSpellFromSlot(e.getRawSlot());

                        switch (i) {
                            case 10, 11, 12, 19, 20, 21, 28, 29, 30 -> MagickLib.setMagickData(viewer, "first.spells." + ((i / 9) * 3 + i % 9 - 3) + ".slot", String.valueOf(e.getRawSlot() % 9));
                            case 14, 15, 16, 23, 24, 25, 32, 33, 34 -> MagickLib.setMagickData(viewer, "second.spells." + ((i / 9) * 3 + i % 9 - 7) + ".slot", String.valueOf(e.getRawSlot() % 9));
                            default -> { }
                        }

                        spellSelected = false;
                        updateSpellsShown();
                        break;
                    }
                }
            }
        }
    }

    @Override
    protected void createInventory() {
        inv = Bukkit.createInventory(null, 54, ChatColor.BLACK.toString() + ChatColor.BOLD + "Spells Editor");

        final ItemStack separator = ItemBuilder.createItem(Material.WHITE_STAINED_GLASS_PANE);
        final int[] sepPos = new int[]{0, 1, 3, 4, 5, 7, 8, 36, 37, 38, 39, 40, 41, 42, 43, 44};

        for(int pos : sepPos) inv.setItem(pos, separator);

        final MagickTypeEnum firstType = MagickLib.getMagickType(viewer, true);
        final MagickTypeEnum secondType = MagickLib.getMagickType(viewer, false);

        final int p1Lvl = Integer.parseInt(MagickLib.getMagickData("first.level", viewer));
        final int p2Lvl = Integer.parseInt(MagickLib.getMagickData("second.level", viewer));

        inv.setItem(2, firstType.getRelativeIcon(Integer.parseInt(MagickLib.getMagickData("first.essences", viewer)),
                ChatColor.RESET.toString() + firstType, ChatColor.RESET + "Level: " + (p1Lvl == 21 ? "Master" : p1Lvl)));

        inv.setItem(6, secondType.getRelativeIcon(Integer.parseInt(MagickLib.getMagickData("second.essences", viewer)),
                ChatColor.RESET.toString() + secondType, ChatColor.RESET + "Level: " + p2Lvl));

        updateSpellsShown();
    }


    private void updateSpellsShown() {
        if (!spellSelected) {
            displaySpells(Integer.parseInt(MagickLib.getMagickData("first.level", viewer)), 10, MagickLib.getSpellList(viewer, true));
            displaySpells(Integer.parseInt(MagickLib.getMagickData("second.level", viewer)), 14, MagickLib.getSpellList(viewer, false));
        } else {
            final ItemStack otherSpells1;
            switch (MagickLib.getMagickData("first.type", viewer)) {
                case "1" -> otherSpells1 = ItemBuilder.createItem(Material.RED_STAINED_GLASS_PANE);
                case "2" -> otherSpells1 = ItemBuilder.createItem(Material.BLUE_STAINED_GLASS_PANE);
                case "3" -> otherSpells1 = ItemBuilder.createItem(Material.LIME_STAINED_GLASS_PANE);
                case "4" -> otherSpells1 = ItemBuilder.createItem(Material.BROWN_STAINED_GLASS_PANE);
                case "5" -> otherSpells1 = ItemBuilder.createItem(Material.YELLOW_STAINED_GLASS_PANE);
                case "6" -> otherSpells1 = ItemBuilder.createItem(Material.PURPLE_STAINED_GLASS_PANE);
                default -> otherSpells1 = ItemBuilder.createItem(Material.WHITE_STAINED_GLASS_PANE);
            }
            final ItemStack otherSpells2;
            switch (MagickLib.getMagickData("second.type", viewer)) {
                case "1" -> otherSpells2 = ItemBuilder.createItem(Material.RED_STAINED_GLASS_PANE);
                case "2" -> otherSpells2 = ItemBuilder.createItem(Material.BLUE_STAINED_GLASS_PANE);
                case "3" -> otherSpells2 = ItemBuilder.createItem(Material.LIME_STAINED_GLASS_PANE);
                case "4" -> otherSpells2 = ItemBuilder.createItem(Material.BROWN_STAINED_GLASS_PANE);
                case "5" -> otherSpells2 = ItemBuilder.createItem(Material.YELLOW_STAINED_GLASS_PANE);
                case "6" -> otherSpells2 = ItemBuilder.createItem(Material.PURPLE_STAINED_GLASS_PANE);
                default -> otherSpells2 = ItemBuilder.createItem(Material.WHITE_STAINED_GLASS_PANE);
            }
            displaySpellsUnlocked(Integer.parseInt(MagickLib.getMagickData("first.level", viewer)), 10, otherSpells1);
            displaySpellsUnlocked(Integer.parseInt(MagickLib.getMagickData("second.level", viewer)), 14, otherSpells2);
        }

        final ItemStack[] spellConfig = MagickLib.getSpellConfig(viewer);
        for(int i=45; i<54; i++)
            inv.setItem(i, spellConfig[i%9] != null ? spellConfig[i%9] : ItemBuilder.createItem(Material.BARRIER));
    }


    private void displaySpells(final int lvl, final int initSlot, final ItemStack[] spellList) {
        final ItemStack lockedSpell = ItemBuilder.getCustomHead("16aa7fd7e49a22b4da36598db47e6d00dcea3681eb9c75c4ac939620fe88820d", ChatColor.RESET.toString() + ChatColor.GRAY + "Locked");
        final ItemMeta lockedMeta = lockedSpell.getItemMeta();
        Validate.notNull(lockedMeta, "The ItemStack doesn't have any ItemMeta.");

        if (lvl < 1) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 1"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot, lockedSpell);
        } else
            inv.setItem(initSlot, spellList[0]);
        if (lvl < 2) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 2"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 1, lockedSpell);
        } else
            inv.setItem(initSlot + 1, spellList[1]);
        if (lvl < 4) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 4"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 2, lockedSpell);
        } else
            inv.setItem(initSlot + 2, spellList[2]);
        if (lvl < 6) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 6"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 9, lockedSpell);
        } else
            inv.setItem(initSlot + 9, spellList[3]);
        if (lvl < 8) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 8"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 10, lockedSpell);
        } else
            inv.setItem(initSlot + 10, spellList[4]);
        if (lvl < 12) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 12"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 11, lockedSpell);
        } else
            inv.setItem(initSlot + 11, spellList[5]);
        if (lvl < 14) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 14"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 18, lockedSpell);
        } else
            inv.setItem(initSlot + 18, spellList[6]);
        if (lvl < 16) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 16"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 19, lockedSpell);
        } else
            inv.setItem(initSlot + 19, spellList[7]);
        if (lvl < 18) {
            lockedMeta.setLore(Collections.singletonList(ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "Unlock at Lvl 18"));
            lockedSpell.setItemMeta(lockedMeta);
            inv.setItem(initSlot + 20, lockedSpell);
        } else
            inv.setItem(initSlot + 20, spellList[8]);
    }

    private void displaySpellsUnlocked(int lvl, int initSlot, final ItemStack unlockedSpell) {
        final ItemStack lockedSpell = ItemBuilder.createItem(Material.BLACK_STAINED_GLASS_PANE);

        if (lvl < 1)
            inv.setItem(initSlot, lockedSpell);
        else
            inv.setItem(initSlot, unlockedSpell);
        if (lvl < 2)
            inv.setItem(initSlot + 1, lockedSpell);
        else
            inv.setItem(initSlot + 1, unlockedSpell);
        if (lvl < 4)
            inv.setItem(initSlot + 2, lockedSpell);
        else
            inv.setItem(initSlot + 2, unlockedSpell);
        if (lvl < 6)
            inv.setItem(initSlot + 9, lockedSpell);
        else
            inv.setItem(initSlot + 9, unlockedSpell);
        if (lvl < 8)
            inv.setItem(initSlot + 10, lockedSpell);
        else
            inv.setItem(initSlot + 10, unlockedSpell);
        if (lvl < 12)
            inv.setItem(initSlot + 11, lockedSpell);
        else
            inv.setItem(initSlot + 11, unlockedSpell);
        if (lvl < 14)
            inv.setItem(initSlot + 18, lockedSpell);
        else
            inv.setItem(initSlot + 18, unlockedSpell);
        if (lvl < 16)
            inv.setItem(initSlot + 19, lockedSpell);
        else
            inv.setItem(initSlot + 19, unlockedSpell);
        if (lvl < 18)
            inv.setItem(initSlot + 20, lockedSpell);
        else
            inv.setItem(initSlot + 20, unlockedSpell);
    }

    private void removeSpellFromSlot(final int slot) {
        for (int j = 1; j < 10; j++) {
            if (MagickLib.getMagickData("first.spells." + j + ".slot", viewer).equals(String.valueOf(slot % 9))) {
                MagickLib.setMagickData(viewer, "first.spells." + j + ".slot", "-1");
                break;
            } else if (MagickLib.getMagickData("second.spells." + j + ".slot", viewer).equals(String.valueOf(slot % 9))) {
                MagickLib.setMagickData(viewer, "second.spells." + j + ".slot", "-1");
                break;
            }
        }
    }
}
