package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder7 extends SpellClass {
    public Placeholder7() {
        super(MagickTypeEnum.FIRE, 6,
                ItemBuilder.getCustomHead("967963cab657d2549dea534be238499d64d6165a592ca361512687a96ed960",
                        1, ChatColor.RED + "Lava Splash", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire7");
    }
}