package fr.mayayoh.magick.spell.light;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder6 extends SpellClass {
    public Placeholder6() {
        super(MagickTypeEnum.LIGHT, 5,
                ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                        1, ChatColor.YELLOW + "Light Beam", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("light6");
    }
}
