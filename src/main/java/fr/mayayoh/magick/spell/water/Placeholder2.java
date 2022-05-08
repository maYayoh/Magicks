package fr.mayayoh.magick.spell.water;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder2 extends SpellClass {
    public Placeholder2() {
        super(MagickTypeEnum.WATER, 1,
                ItemBuilder.getCustomHead("b2d6d935f3714662c1e3b2826f663bb623ce09b1dfd9004b8cda46550f426580",
                        1, ChatColor.BLUE + "Ice Path", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("water2");
    }
}
