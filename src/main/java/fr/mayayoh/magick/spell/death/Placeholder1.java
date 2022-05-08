package fr.mayayoh.magick.spell.death;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder1 extends SpellClass {
    public Placeholder1() {
        super(MagickTypeEnum.DEATH, 0,
                ItemBuilder.getCustomHead("06aea6aca1a81b23bd8c5e508fe76648fc2e41faa1c8fc26cfa8bdce4163",
                        1, ChatColor.DARK_PURPLE + "Zombie Buddy", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("death1");
    }
}
