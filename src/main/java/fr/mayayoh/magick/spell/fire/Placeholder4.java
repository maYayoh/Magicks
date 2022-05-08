package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder4 extends SpellClass {
    public Placeholder4() {
        super(MagickTypeEnum.FIRE, 3, ItemBuilder.getCustomHead("7717933c40fbf936aa9288513efe19bda4601efc0e4ecad2e023b0c1d28444b",
                        1, ChatColor.RED + "Turret", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire4");
    }
}
