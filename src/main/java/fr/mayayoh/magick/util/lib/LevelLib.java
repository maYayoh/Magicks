package fr.mayayoh.magick.util.lib;

import org.bukkit.entity.Player;

import java.util.UUID;

public final class LevelLib {

    private static void checkLevelUp(final Player p, final boolean isFirstType) { checkLevelUp(p.getUniqueId(), isFirstType); }
    private static void checkLevelUp(final UUID u, final boolean isFirstType) {
        final int level = Integer.parseInt(MagickLib.getMagickData((isFirstType ? "first" : "second")+".level", u));
        final int xp = Integer.parseInt(MagickLib.getMagickData((isFirstType ? "first" : "second")+".xp", u));

        final int xpNeeded;
        switch (level) {
            case 0 -> xpNeeded = 10;
            case 1 -> xpNeeded = 100;
            case 20 -> xpNeeded = 5000;
            case 21 -> xpNeeded = -1;
            default -> xpNeeded = (level-1)*250;
        }
        if (xp >= xpNeeded && xpNeeded > 0) {
            MagickLib.setMagickData(u, (isFirstType ? "first" : "second")+".level", String.valueOf(level+1));
            checkLevelUp(u, isFirstType);
        }
    }

}
