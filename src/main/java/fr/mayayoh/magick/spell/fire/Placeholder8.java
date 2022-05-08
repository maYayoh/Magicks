package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder8 extends SpellClass {
    public Placeholder8() {
        super(MagickTypeEnum.FIRE, 7,
                ItemBuilder.getCustomHead("602a1169309f05ef2f061b1fa0fe225f29d73a24f8f07ccc2a705deeaca069d1",
                        1, ChatColor.RED + "Self Destruct", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire8");
    }
}
