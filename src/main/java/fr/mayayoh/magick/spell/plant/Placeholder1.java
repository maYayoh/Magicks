package fr.mayayoh.magick.spell.plant;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder1 extends SpellClass {
    public Placeholder1() {
        super(MagickTypeEnum.PLANT, 0,
                ItemBuilder.getCustomHead("5f497786d7ba192369932966686aa9fb7147fa5884f9a6209c4a73e2d60f39f5",
                        1, ChatColor.GREEN + "Tree Grow", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("plant1");
    }
}
