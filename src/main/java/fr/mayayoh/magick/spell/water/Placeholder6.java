package fr.mayayoh.magick.spell.water;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder6 extends SpellClass {
    public Placeholder6() {
        super(MagickTypeEnum.WATER, 5,
                ItemBuilder.getCustomHead("26e429c60932ebc366e791a42e186af888de08e5d8eb8ac6f5b6f4d440db486c",
                        1, ChatColor.BLUE + "Ice Spear", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("water6");
    }
}
