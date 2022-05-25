package fr.mayayoh.magick.util.lib;

import org.bukkit.entity.Player;

import java.util.UUID;

public final class LevelLib {

    public static void addXp(final Player p, final boolean isFirstType, final int n) { addXp(p.getUniqueId(), isFirstType, n); }
    public static void addXp(final UUID u, final boolean isFirstType, final int n) {
        final int xp = Integer.parseInt(MagickLib.getMagickData((isFirstType ? "first" : "second")+".xp", u));
        setXp(u, isFirstType, xp+n);
    }


    public static void setXp(final Player p, final boolean isFirstType, final int xp) { setXp(p.getUniqueId(), isFirstType, xp); }
    public static void setXp(final UUID u, final  boolean isFirstType, final int xp) {
        MagickLib.setMagickData(u, (isFirstType ? "first" : "second")+".xp", String.valueOf(xpNeeded(xp)));
        checkLevelUp(u, isFirstType);
    }



    public static void addLevel(final Player p, final boolean isFirstType) { addLevel(p.getUniqueId(), isFirstType, 1); }
    public static void addLevel(final UUID u, final boolean isFirstType) { addLevel(u, isFirstType, 1); }

    public static void addLevel(final Player p, final boolean isFirstType, final int n) { addLevel(p.getUniqueId(), isFirstType, n); }
    public static void addLevel(final UUID u, final boolean isFirstType, final int n) {
        final int level = Integer.parseInt(MagickLib.getMagickData((isFirstType ? "first" : "second")+".level", u));
        modifyLevel(u, isFirstType, level+n);
    }


    public static void modifyLevel(final Player p, final boolean isFirstType, final int level) { modifyLevel(p.getUniqueId(), isFirstType, level); }
    public static void modifyLevel(final UUID u, final boolean isFirstType, final int level) {
        if (level <= 20) setXp(u, isFirstType, xpNeeded(level-1));
        // TODO: else send error message
    }



    private static void checkLevelUp(final Player p, final boolean isFirstType) { checkLevelUp(p.getUniqueId(), isFirstType); }
    private static void checkLevelUp(final UUID u, final boolean isFirstType) {
        final int xp = Integer.parseInt(MagickLib.getMagickData((isFirstType ? "first" : "second")+".xp", u));

        int level, xpNeeded;
        for(int i=0; i<21; i++) {
            level = Integer.parseInt(MagickLib.getMagickData((isFirstType ? "first" : "second")+".level", u));
            xpNeeded = xpNeeded(level);
            if (xp >= xpNeeded && xpNeeded > 0) {
                MagickLib.setMagickData(u, (isFirstType ? "first" : "second")+".level", String.valueOf(level+1));
                checkLevelUp(u, isFirstType);
            } else break;
        }
    }



    private static int xpNeeded(final int level) {
        if (level >= -1 && level <= 20)
            switch (level) {
                case -1 -> { return 0; }
                case 0 -> { return 10; }
                case 1 -> { return 100; }
                case 20 -> { return 5000; }
                default -> { return (level-1)*250; }
            }
        else return -1;
    }

}
