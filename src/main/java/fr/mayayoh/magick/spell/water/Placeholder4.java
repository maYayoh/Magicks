package fr.mayayoh.magick.spell.water;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder4 extends SpellClass {
    public Placeholder4() {
        super(MagickTypeEnum.WATER, 3,
                ItemBuilder.getCustomHead("ddba642efffa13ec3730eafc5914ab68115c1f998803f74452e2e0cd26af0b8",
                        1, ChatColor.BLUE + "Ice Throw", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("water4");
    }
}
