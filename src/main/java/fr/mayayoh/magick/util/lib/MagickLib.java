package fr.mayayoh.magick.util.lib;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * MagickLib class used to get data related to the Magick Plugin.
 *
 * @author maYayoh
 * @version 1.0
 */
public final class MagickLib {

    public static String getMagickData(final String path, final Player p) {
        String data = MagickPlugin.getInstance().getData().getString("players." + p.getUniqueId() + ".magic." + path);
        return (data != null ? data : "0");
    }
    public static void setMagickData(final Player p, final String path, final String val) {
        MagickPlugin.getInstance().getData().set("players." + p.getUniqueId() + ".magic." + path, val);
    }

    public static ItemStack[] getSpellList(final Player p, final String t) {
        final MagickTypeEnum magickType = MagickTypeEnum.getById(Integer.parseInt(getMagickData(t + ".type", p)));
        return magickType == null ? null : magickType.getSpellList();
    }

    @NotNull
    public static ItemStack[] getSpellConfig(final Player p) {
        final ItemStack air = new ItemStack(Material.AIR);
        ItemStack[] spells = new ItemStack[]{air, air, air, air, air, air, air, air, air};
        final ItemStack[] p1spells = getSpellList(p, "first");
        final ItemStack[] p2spells = getSpellList(p, "second");
        if (p1spells == null || p2spells == null) return spells;

        for (int i=1; i<10; i++) {
            String slot = getMagickData("first.spells." + i + ".slot", p);
            if(!slot.equals("-1"))
                spells[Integer.parseInt(slot)] = p1spells[i-1];

            slot = getMagickData("second.spells." + i + ".slot", p);
            if(!slot.equals("-1"))
                spells[Integer.parseInt(slot)] = p2spells[i-1];
        }

        return spells;
    }
}
