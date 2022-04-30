package fr.mayayoh.magick.util.lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GeometryLib class used to get positions from shapes.
 *
 * @author maYayoh, PandaLunatique
 * @version 1.0
 */
public final class GeometryLib {

    public static Location[] getLinePositions(final Location p1, final Location p2, final int n) {

        Location[] loc = new Location[n];

        Location pos = p1.clone();

        Vector v = new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
        double ratio = 1/(double)n;

        v.multiply(ratio);

        for(int i=0; i<n; i++) {
            loc[i] = pos.clone();
            pos.add(v);
        }

        return loc;
    }

    public static List<Location> getCubeOutline(final Location blockPos, final int n) {
        List<Location> loc = new ArrayList<>();

        final Location nwb = new Location(blockPos.getWorld(), blockPos.getBlockX(), blockPos.getBlockY(), blockPos.getBlockZ());
        final Location nwt = new Location(blockPos.getWorld(), blockPos.getBlockX(), blockPos.getBlockY()+1, blockPos.getBlockZ());
        final Location neb = new Location(blockPos.getWorld(), blockPos.getBlockX()+1, blockPos.getBlockY(), blockPos.getBlockZ());
        final Location net = new Location(blockPos.getWorld(), blockPos.getBlockX()+1, blockPos.getBlockY()+1, blockPos.getBlockZ());
        final Location swb = new Location(blockPos.getWorld(), blockPos.getBlockX(), blockPos.getBlockY(), blockPos.getBlockZ()+1);
        final Location swt = new Location(blockPos.getWorld(), blockPos.getBlockX(), blockPos.getBlockY()+1, blockPos.getBlockZ()+1);
        final Location seb = new Location(blockPos.getWorld(), blockPos.getBlockX()+1, blockPos.getBlockY(), blockPos.getBlockZ()+1);
        final Location set = new Location(blockPos.getWorld(), blockPos.getBlockX()+1, blockPos.getBlockY()+1, blockPos.getBlockZ()+1);


        loc.addAll(Arrays.asList(getLinePositions(nwb, nwt, n)));
        loc.addAll(Arrays.asList(getLinePositions(neb, net, n)));
        loc.addAll(Arrays.asList(getLinePositions(swb, swt, n)));
        loc.addAll(Arrays.asList(getLinePositions(seb, set, n)));

        loc.addAll(Arrays.asList(getLinePositions(nwb, neb, n)));
        loc.addAll(Arrays.asList(getLinePositions(nwt, net, n)));
        loc.addAll(Arrays.asList(getLinePositions(nwb, swb, n)));
        loc.addAll(Arrays.asList(getLinePositions(nwt, swt, n)));
        loc.addAll(Arrays.asList(getLinePositions(neb, seb, n)));
        loc.addAll(Arrays.asList(getLinePositions(net, set, n)));
        loc.addAll(Arrays.asList(getLinePositions(swb, seb, n)));
        loc.addAll(Arrays.asList(getLinePositions(swt, set, n)));

        return loc;
    }


    public static Location[] getCirclePositions(final Location center, final float radius, final int n) {

        float theta = 0.0f;
        final float step = (float) (2 * Math.PI) / n;
        Location[] pos = new Location[n];

        final float x = (float) center.getX();
        final float y = (float) center.getY();
        final float z = (float) center.getZ();

        float dx, dy, dz;

        for(int i = 0; i < n; i++) {

            dx = (float) (radius * Math.cos(theta));
            dz = (float) (radius * Math.sin(theta));

            theta += step;

            pos[i] = new Location(center.getWorld(), x + dx, y, z + dz);

        }

        return pos;

    }
}
