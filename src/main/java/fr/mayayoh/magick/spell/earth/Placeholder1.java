package fr.mayayoh.magick.spell.earth;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder1 extends SpellClass {
    public Placeholder1() {
        super(MagickTypeEnum.EARTH, 0,
                ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                        1, ChatColor.GOLD + "Rock Throw", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("earth1");
    }
}
