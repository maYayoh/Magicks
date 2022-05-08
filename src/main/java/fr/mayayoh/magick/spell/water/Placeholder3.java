package fr.mayayoh.magick.spell.water;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder3 extends SpellClass {
    public Placeholder3() {
        super(MagickTypeEnum.WATER, 2,
                ItemBuilder.getCustomHead("df0d96336ffcc7f12a8a8f5e3bd258ec2d8037ba24a435917c3d531b216de6d7",
                        1, ChatColor.BLUE + "Rainy Cloud", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("water3");
    }
}
