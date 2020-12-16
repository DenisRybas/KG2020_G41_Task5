package rybas;

import rybas.math.Vector2;
import rybas.model.planet.NameOfObject;
import rybas.model.planet.SpaceObject;

public class Defaults {
    public static final float WIDTH = 1920;
    public static final float HEIGHT = 1080;
    public static final double G = 6.674 * Math.pow(10, -11);
    /**
     * mass == M+ (mass of Earth)
     * radius == realRadius / 10^3
     * y depends on distance from Sun
     */
    private static float AUtoPx = HEIGHT / 2 / 39;
    public static final SpaceObject SUN = new SpaceObject(
            NameOfObject.SUN, 3.32 * Math.pow(10, 3), 696,
            new Vector2(WIDTH / 2, HEIGHT / 2), new Vector2(0, 3));

    public static final SpaceObject MERCURY = new SpaceObject(NameOfObject.MERCURY,
            0.055, 2.5, new Vector2(WIDTH / 2 - AUtoPx * 0.39 - 100, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject VENUS = new SpaceObject(NameOfObject.VENUS,
            0.815, 6, new Vector2(WIDTH / 2 - AUtoPx * 0.723 - 150, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject EARTH = new SpaceObject(NameOfObject.EARTH,
            1, 6.37, new Vector2(WIDTH / 2 - AUtoPx - 200, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject MARS = new SpaceObject(NameOfObject.MARS,
            0.107, 3.39, new Vector2(WIDTH / 2 - AUtoPx * 1.524 - 250, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject JUPITER = new SpaceObject(NameOfObject.JUPITER,
            317.8, 70, new Vector2(WIDTH / 2 - AUtoPx * 5.203 - 250, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject SATURN = new SpaceObject(NameOfObject.SATURN,
            95.16, 58, new Vector2(WIDTH / 2 - AUtoPx * 9.539 - 250, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject URANUS = new SpaceObject(NameOfObject.URANUS,
            14.54, 25, new Vector2(WIDTH / 2 - AUtoPx * 19.18 - 250, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject NEPTUNIUM = new SpaceObject(NameOfObject.NEPTUNE,
            17.15,24, new Vector2(WIDTH / 2 - AUtoPx * 30.06 - 250, HEIGHT / 2),
            new Vector2(0, 3));

    public static final SpaceObject PLUTO = new SpaceObject(NameOfObject.PLUTO,
            0.0022,1.1, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 3));
}