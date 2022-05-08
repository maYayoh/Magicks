package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder1 extends SpellClass {
    public Placeholder1() {
        super(MagickTypeEnum.FIRE, 0,
                ItemBuilder.getCustomHead("64b1b9ce2e9a6ce8a985d39776e2908077b82e6a333d2a81a441438eab39f8e1",
                        1, ChatColor.RED + "Fire Wave", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
                );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire1");
    }
}
