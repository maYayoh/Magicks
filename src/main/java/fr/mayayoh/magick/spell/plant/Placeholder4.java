package fr.mayayoh.magick.spell.plant;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder4 extends SpellClass {
    public Placeholder4() {
        super(MagickTypeEnum.PLANT, 3,
                ItemBuilder.getCustomHead("3795edeeb6b7ed41c268cefeafbe960b7c49550daeb631b56156bf5feb9847",
                        1, ChatColor.GREEN + "Razor Leaf", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("plant4");
    }
}
