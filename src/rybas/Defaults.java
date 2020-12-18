package rybas;

import rybas.math.Vector2;
import rybas.model.planet.*;

public class Defaults {
    public static final double REALWIDTH = 4e6;
    public static final double REALHEIGHT = 4e6;
    public static final double WIDTH = 1920;
    public static final double HEIGHT = 1080;
    public static final double G = 6.674 * Math.pow(10, -11);
    /**
     * mass == M+ (mass of Earth)
     * radius == realRadius / 10^3
     * y depends on distance from Sun
     */
    private static double AUtoPx = HEIGHT / 2 / 39;
//    public static final SpaceObject SUN = new SpaceObject(
//            NameOfObject.SUN, 3.32 * Math.pow(10, 3), 696,
//            new Vector2(WIDTH / 2, HEIGHT / 2), new Vector2(0, 3));
//
//    public static final SpaceObject MERCURY = new SpaceObject(NameOfObject.MERCURY,
//            0.055, 2.5, new Vector2(WIDTH / 2 - AUtoPx * 0.39 - 100, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject VENUS = new SpaceObject(NameOfObject.VENUS,
//            0.815, 6, new Vector2(WIDTH / 2 - AUtoPx * 0.723 - 150, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject EARTH = new SpaceObject(NameOfObject.EARTH,
//            1, 6.37, new Vector2(WIDTH / 2 - AUtoPx - 200, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject MARS = new SpaceObject(NameOfObject.MARS,
//            0.107, 3.39, new Vector2(WIDTH / 2 - AUtoPx * 1.524 - 250, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject JUPITER = new SpaceObject(NameOfObject.JUPITER,
//            317.8, 70, new Vector2(WIDTH / 2 - AUtoPx * 5.203 - 250, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject SATURN = new SpaceObject(NameOfObject.SATURN,
//            95.16, 58, new Vector2(WIDTH / 2 - AUtoPx * 9.539 - 250, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject URANUS = new SpaceObject(NameOfObject.URANUS,
//            14.54, 25, new Vector2(WIDTH / 2 - AUtoPx * 19.18 - 250, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject NEPTUNIUM = new SpaceObject(NameOfObject.NEPTUNE,
//            17.15,24, new Vector2(WIDTH / 2 - AUtoPx * 30.06 - 250, HEIGHT / 2),
//            new Vector2(0, 3));
//
//    public static final SpaceObject PLUTO = new SpaceObject(NameOfObject.PLUTO,
//            0.0022,1.1, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
//            new Vector2(0, 3));

    public static final SpaceObject SUN = new Star(
            NameOfObject.SUN, 1.988 * Math.pow(10, 30), 696340,
            new Vector2(WIDTH / 2, HEIGHT / 2), new Vector2(0, 0));

    public static final SpaceObject MERCURY = new Planet(NameOfObject.MERCURY,
            3.285 * Math.pow(10, 23), 2439.7, new Vector2(WIDTH / 2 - AUtoPx * 0.39 - 100, HEIGHT / 2),
            new Vector2(0, 0.48));

    public static final SpaceObject VENUS = new Planet(NameOfObject.VENUS,
            4.867 * Math.pow(10, 24), 6051.8, new Vector2(WIDTH / 2 - AUtoPx * 0.723 - 150, HEIGHT / 2),
            new Vector2(0, 0.35));

    public static final SpaceObject EARTH = new Planet(NameOfObject.EARTH,
            5.972 * Math.pow(10, 24), 6400, new Vector2(WIDTH / 2 - AUtoPx - 200, HEIGHT / 2),
            new Vector2(0, 0.27));

    public static final SpaceObject MARS = new Planet(NameOfObject.MARS,
            6.39 * Math.pow(10, 23), 3389.5, new Vector2(WIDTH / 2 - AUtoPx * 1.524 - 250, HEIGHT / 2),
            new Vector2(0, 0.23));

    public static final SpaceObject JUPITER = new Planet(NameOfObject.JUPITER,
            1.898 * Math.pow(10, 27), 69911, new Vector2(WIDTH / 2 - AUtoPx * 5.203 - 250, HEIGHT / 2),
            new Vector2(0, 0.13));

    public static final SpaceObject SATURN = new Planet(NameOfObject.SATURN,
            5.683 * Math.pow(10, 26), 58232, new Vector2(WIDTH / 2 - AUtoPx * 9.539 - 250, HEIGHT / 2),
            new Vector2(0, 0.10));

    public static final SpaceObject URANUS = new Planet(NameOfObject.URANUS,
            8.681 * Math.pow(10, 25), 25362, new Vector2(WIDTH / 2 - AUtoPx * 19.18 - 250, HEIGHT / 2),
            new Vector2(0, 0.3));

    public static final SpaceObject NEPTUNIUM = new Planet(NameOfObject.NEPTUNE,
            1.024 * Math.pow(10, 26),24622, new Vector2(WIDTH / 2 - AUtoPx * 30.06 - 250, HEIGHT / 2),
            new Vector2(0, 0.3));

    public static final SpaceObject PLUTO = new Planet(NameOfObject.PLUTO,
            1.3 * Math.pow(10, 22),1188.3, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.3));

    //Satellites
    //Earth
    public static final SpaceObject MOON = new Moon(NameOfObject.MOON,
            7.3477 * Math.pow(10, 22),1737.1, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.27));

    //Jupiter
    public static final SpaceObject IO = new Moon(NameOfObject.IO,
            8.9319 * Math.pow(10, 22),1821.3, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.13));

    public static final SpaceObject EUROPA = new Moon(NameOfObject.EUROPA,
            4.8017 * Math.pow(10, 22),1560.8, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.13));

    public static final SpaceObject GANYMEDE = new Moon(NameOfObject.GANYMEDE,
            1.48 * Math.pow(10, 23),2634.1, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.13));

    public static final SpaceObject CALLISTO = new Moon(NameOfObject.CALLISTO,
            1.075 * Math.pow(10, 23),2410.3, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.13));

    //Saturn

    public static final SpaceObject TITAN = new Moon(NameOfObject.TITAN,
            1.3452 * Math.pow(10, 23),2574.7, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.10));

    public static final SpaceObject ENCELADE = new Moon(NameOfObject.ENCELADE,
            1.08 * Math.pow(10, 20),252.1, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.10));

    public static final SpaceObject IAPETUS = new Moon(NameOfObject.IAPETUS,
            1.806 * Math.pow(10, 21),734.5, new Vector2(WIDTH / 2 - AUtoPx * 39.53 - 250, HEIGHT / 2),
            new Vector2(0, 0.10));
}