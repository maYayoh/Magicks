package fr.mayayoh.magick.spell.death;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder5 extends SpellClass {
    public Placeholder5() {
        super(MagickTypeEnum.DEATH, 4,
                ItemBuilder.getCustomHead("7a70c5d07b79c5be43d0b21c6d4e37472db2ab3fa634a5f13cf89fb987b2e5",
                        1, ChatColor.DARK_PURPLE + "Nether Buddy", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("death5");
    }
}
