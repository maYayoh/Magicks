package fr.mayayoh.magick.spell;

import fr.mayayoh.magick.util.MagickTypeEnum;
import fr.mayayoh.magick.util.lib.LevelLib;
import fr.mayayoh.magick.util.lib.MagickLib;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class SpellClass {
    protected final int cost;
    protected final int xpGain;
    @Getter protected final int spellId;
    @Getter protected final ItemStack spellIcon;

    public SpellClass(final MagickTypeEnum magickType, final int spellId, final ItemStack spellIcon) {
        this.cost = 0;
        this.xpGain = 0;
        this.spellId = spellId;
        this.spellIcon = spellIcon;
    }

    public SpellClass(final int cost, final int spellId, final ItemStack spellIcon) {
        this.cost = cost;
        this.xpGain = 5;
        this.spellId = spellId;
        this.spellIcon = spellIcon;
    }

    public SpellClass(final int cost, final int xpGain, final int spellId, final ItemStack spellIcon) {
        this.cost = cost;
        this.xpGain = xpGain;
        this.spellId = spellId;
        this.spellIcon = spellIcon;
    }

    protected abstract void spellEffect(final Player player);
    public void castSpell(final Player player, final MagickTypeEnum type) {
        final boolean isPlayerFirstType = type == MagickLib.getMagickType(player, true);

        final int essenceCount = Integer.parseInt(MagickLib.getMagickData((isPlayerFirstType ? "first" : "second") + ".essences", player));
        if (essenceCount > 0) {
            MagickLib.setMagickData(player, (isPlayerFirstType ? "first" : "second") + ".essences", String.valueOf(essenceCount-1));
            MagickLib.showEssenceCount(player);

            if (player.getFoodLevel() > cost)
                player.setFoodLevel(player.getFoodLevel() - cost);
            else if (player.getFoodLevel() < cost) {
                final int healthCost = cost - player.getFoodLevel();
                player.setFoodLevel(0);
                player.damage(healthCost);
            } else player.setFoodLevel(0);
            if (!player.isDead()) {
                LevelLib.addXp(player, isPlayerFirstType, xpGain);
                spellEffect(player);
            }
        }
    }
}
