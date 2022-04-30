package fr.mayayoh.magick.util.lib;

import java.util.Random;

/**
 * RandomLib class used to generate pseudorandom numbers.
 *
 * @author PandaLunatique
 * @version 1.0
 */
public final class RandomLib {

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
