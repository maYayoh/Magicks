package fr.mayayoh.magick.spell.death;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder4 extends SpellClass {
    public Placeholder4() {
        super(MagickTypeEnum.DEATH, 3,
                ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                        1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("death4");
    }
}
