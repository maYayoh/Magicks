package fr.mayayoh.magick.spell.plant;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder2 extends SpellClass {
    public Placeholder2() {
        super(MagickTypeEnum.PLANT, 1,
                ItemBuilder.getCustomHead("ca8d3d3b2e6babece55264136057a26821c3704132966ee9ecca93acc9887a0",
                        1, ChatColor.GREEN + "Fireball", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("plant2");
    }
}
