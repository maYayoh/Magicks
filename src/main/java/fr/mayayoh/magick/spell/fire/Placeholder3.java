package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder3 extends SpellClass {
    public Placeholder3() {
        super(MagickTypeEnum.FIRE, 2,
                ItemBuilder.getCustomHead("bb508c779f312daff337d137f34dd365a3f9c132bd92eb0c5ffab7c5b4a55c5",
                        1, ChatColor.RED + "Burning Snip", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire3");
    }
}
