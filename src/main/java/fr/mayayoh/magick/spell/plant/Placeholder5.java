package fr.mayayoh.magick.spell.plant;

import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholder5 extends SpellClass {
    public Placeholder5() {
        super(MagickTypeEnum.PLANT, 4,
                ItemBuilder.getCustomHead("eb8418c461f63d6aad3932a639fce3fec227a3774a59b851ffbe655874eb791",
                        1, ChatColor.GREEN + "Become blok.", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        player.sendMessage("plant5");
    }
}
