package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder5 extends SpellClass {
    public Placeholder5() {
        super(MagickTypeEnum.FIRE, 4,
                ItemBuilder.getCustomHead("33f8a9fe3339c2f22704bf1c03394df071ee4ef3d72eebeaabaf3105cffe142",
                        1, ChatColor.RED + "Trap", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire5");
    }
}
