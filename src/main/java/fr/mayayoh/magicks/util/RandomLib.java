package fr.mayayoh.magicks.util;

import java.util.Random;

public class RandomLib {

    public static boolean chanceOutOf(final int percentage) { return chanceOutOf(percentage, 100); }

    public static boolean chanceOutOf(final int chance, final int outOf) {

        final Random r = new Random();
        return r.nextInt(outOf + 1) < chance;

    }

    public static int randomInteger(final int max) { return randomInteger(0, max); }


    public static int randomInteger(final int min, final int max) {

        final Random r = new Random();
        return r.nextInt(max - min) + min;

    }

}
