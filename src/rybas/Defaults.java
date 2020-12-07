package rybas;

import rybas.math.Vector2;
import rybas.model.planet.SpaceObject;

public class Defaults {
    public static final float WIDTH = 800;
    public static final float HEIGHT = 600;
    public static final double G = 6.674 * Math.pow(10, -11);
    /**
     * mass == M+ (mass of Earth)
     * radius == realRadius / 10^3
     * y depends on distance from Sun
     */
    public static final SpaceObject SUN = new SpaceObject(
            1.99 * Math.pow(10, 6), 696,
            new Vector2(WIDTH / 2, HEIGHT / 2));

    public static final SpaceObject MERCURY = new SpaceObject(0.055,
            2.5, new Vector2(WIDTH / 2, HEIGHT / 4));

    public static final SpaceObject VENUS = new SpaceObject(0.815,
            6, new Vector2( WIDTH / 2, HEIGHT / 8));

    public static final SpaceObject EARTH = new SpaceObject(1,
            6.37, new Vector2( WIDTH / 2, HEIGHT / 16));

    public static final SpaceObject MARS = new SpaceObject(0.107,
            3.389, new Vector2( WIDTH / 2, 63.7));

    public static final SpaceObject JUPITER = new SpaceObject(317.8,
            70, new Vector2( WIDTH / 2, 63.7));

    public static final SpaceObject SATURN = new SpaceObject(95.16,
            58, new Vector2( WIDTH / 2, 63.7));

    public static final SpaceObject URANUS = new SpaceObject(14.54,
            25, new Vector2( WIDTH / 2, 63.7));

    public static final SpaceObject NEPTUNIUM = new SpaceObject(17.15,
            24, new Vector2( WIDTH / 2, 63.7));

    public static final SpaceObject PLUTO = new SpaceObject(0.0022,
            1.1, new Vector2( WIDTH / 2, 63.7));
}
