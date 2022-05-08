package fr.mayayoh.magick.spell;

import fr.mayayoh.magick.event.SpellEvent;
import fr.mayayoh.magick.util.MagickTypeEnum;
import fr.mayayoh.magick.util.lib.MagickLib;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class SpellClass {
    protected final int cost;
    @Getter protected final int spellId;
    @Getter protected final ItemStack spellIcon;

    public SpellClass(final MagickTypeEnum magickType, final int spellId, final ItemStack spellIcon) {
        this.cost = 0;
        this.spellId = spellId;
        this.spellIcon = spellIcon;
    }

    public SpellClass(final int cost, final int spellId, final ItemStack spellIcon) {
        this.cost = cost;
        this.spellId = spellId;
        this.spellIcon = spellIcon;
    }

    protected abstract void spellEffect(final Player player);
    public void castSpell(final Player player, final MagickTypeEnum type) {
        final boolean isPlayerFirstType = type == MagickLib.getMagickType(player, true);
        player.sendMessage(type+" | "+MagickLib.getMagickType(player, true)+" : "+isPlayerFirstType);


        final int essenceCount = Integer.parseInt(MagickLib.getMagickData((isPlayerFirstType ? "first" : "second") + ".essences", player));
        if (essenceCount > 0) {
            MagickLib.setMagickData(player, (isPlayerFirstType ? "first" : "second") + ".essences", String.valueOf(essenceCount-1));
            SpellEvent.showEssenceCount(player);

            if (player.getFoodLevel() > cost)
                player.setFoodLevel(player.getFoodLevel() - cost);
            else if (player.getFoodLevel() < cost) {
                final int healthCost = cost - player.getFoodLevel();
                player.setFoodLevel(0);
                player.damage(healthCost);
            } else player.setFoodLevel(0);
            if (!player.isDead())
                spellEffect(player);
        }
    }
}
