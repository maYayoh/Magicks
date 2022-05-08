package fr.mayayoh.magick.spell.death;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder2 extends SpellClass {
    public Placeholder2() {
        super(MagickTypeEnum.DEATH, 1,
                ItemBuilder.getCustomHead("3e708a925e10f29f2232a91e411835376a1db15c8fd396dbcb95b3df9db055b1",
                        1, ChatColor.DARK_PURPLE + "Skelly Buddy", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("death2");
    }
}
