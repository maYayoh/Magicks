package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder9 extends SpellClass {
    public Placeholder9() {
        super(MagickTypeEnum.FIRE, 8,
                ItemBuilder.getCustomHead("2c915db3fc40a79b63c2c453f0c490981e5227c5027501283272138533dea519",
                        1, ChatColor.RED + "HellScape", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire9");
    }
}