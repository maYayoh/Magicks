package fr.mayayoh.magick.util.lib;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.util.MagickRegistry;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.apache.commons.lang.Validate;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

/**
 * MagickLib class used to get data related to the Magick Plugin.
 *
 * @author maYayoh
 * @version 1.0
 */
public final class MagickLib {

    public static String getMagickData(final String path, final Player p) { return getMagickData(path, p.getUniqueId()); }
    public static String getMagickData(final String path, final UUID u) {
        final String data = MagickPlugin.getInstance().getData().getString("players." + u + ".magic." + path);
        return (data != null ? data : "0");
    }

    public static MagickTypeEnum getMagickType(final Player p, final boolean isFirstType) { return getMagickType(p.getUniqueId(), isFirstType); }
    public static MagickTypeEnum getMagickType(final UUID u, final boolean isFirstType) {
        return MagickTypeEnum.getById(Integer.parseInt(getMagickData((isFirstType ? "first" : "second") + ".type", u)));
    }

    public static void setMagickData(final Player p, final String path, final String val) { setMagickData(p.getUniqueId(), path, val); }
    public static void setMagickData(final UUID u, final String path, final String val) {
        MagickPlugin.getInstance().getData().set("players." + u + ".magic." + path, val);
    }


    public static ItemStack[] getSpellList(final Player p, final boolean isFirstType) { return getSpellList(p.getUniqueId(), isFirstType); }
    public static ItemStack[] getSpellList(final UUID u, final boolean isFirstType) {
        return getMagickType(u, isFirstType).getSpellIconList();
    }

    @NotNull public static ItemStack[] getSpellConfig(final Player p) { return getSpellConfig(p.getUniqueId()); }
    @NotNull
    public static ItemStack[] getSpellConfig(final UUID u) {
        ItemStack[] spells = new ItemStack[9];
        final ItemStack[] p1spells = getSpellList(u, true);
        final ItemStack[] p2spells = getSpellList(u, false);

        String slot;
        for (int i=1; i<10; i++) {
            slot = getMagickData("first.spells." + i + ".slot", u);
            if(!slot.equals("-1"))
                spells[Integer.parseInt(slot)] = p1spells[i-1];

            slot = getMagickData("second.spells." + i + ".slot", u);
            if(!slot.equals("-1"))
                spells[Integer.parseInt(slot)] = p2spells[i-1];
        }

        return spells;
    }


    public static void showEssenceCount(final Player player) {
        final MagickRegistry registry = MagickRegistry.getInstance();

        final ItemStack itemHeld = player.getInventory().getItemInMainHand();
        if (itemHeld.getType().equals(Material.PLAYER_HEAD)) {
            final ItemMeta itemMeta = itemHeld.getItemMeta();
            Validate.notNull(itemMeta, "The ItemStack doesn't have any ItemMeta.");
            MagickTypeEnum magickType = MagickTypeEnum.NONE;
            for (MagickTypeEnum type : MagickTypeEnum.values()) {
                if (ChatColor.stripColor(type.toString() + " Spell").equals(ChatColor.stripColor(Objects.requireNonNull(itemMeta.getLore()).get(0)))) {
                    magickType = type;
                    break;
                }
            }

            player.getInventory().setItemInOffHand(
                    magickType.getRelativeIcon(
                            Integer.parseInt(MagickLib.getMagickData((MagickLib.getMagickType(player, true) == magickType ? "first" : "second") + ".essences", player)),
                            ChatColor.RESET + "Number of " + magickType + ChatColor.RESET+ " essences")
            );
        } else player.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
    }
}
