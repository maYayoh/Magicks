package fr.mayayoh.magick.spell.fire;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder2 extends SpellClass {
    public Placeholder2() {
        super(MagickTypeEnum.FIRE, 1,
                ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                        1, ChatColor.RED + "Fireball", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("fire2");
    }
}
