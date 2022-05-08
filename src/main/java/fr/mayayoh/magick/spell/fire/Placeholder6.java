package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder6 extends SpellClass {
    public Placeholder6() {
        super(MagickTypeEnum.FIRE, 5,
                ItemBuilder.getCustomHead("6ebb4d93feb49d904c61a8fa0eaeac41fe34442cafea7801038ebf7c381c8397",
                        1, ChatColor.RED + "Blaze Buddy", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire6");
    }
}
