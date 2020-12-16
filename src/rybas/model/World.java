package rybas.model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import rybas.math.Vector2;
import rybas.model.force.ForceSource;
import rybas.model.planet.NameOfObject;
import rybas.model.planet.SpaceObject;
import rybas.model.system.SolarSystem;
import rybas.utils2d.ScreenConverter;
import rybas.utils2d.ScreenPoint;

import javax.imageio.ImageIO;

public class World {
    private SolarSystem solarSystem;
    private Map<NameOfObject, String> spaceObjImages = new LinkedHashMap<>() {
        {
            put(NameOfObject.JUPITER, "Jupiter.png");
            put(NameOfObject.MARS, "Mars.png");
            put(NameOfObject.MERCURY, "Mercury.png");
            put(NameOfObject.NEPTUNE, "Neptune.png");
            put(NameOfObject.EARTH, "Earth.png");
            put(NameOfObject.SATURN, "Saturn.png");
            put(NameOfObject.SUN, "Sun.png");
            put(NameOfObject.URANUS, "Uranus.png");
            put(NameOfObject.VENUS, "Venus.png");
            put(NameOfObject.PLUTO, "Pluto.png");
        }
    };

    public World(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    /**
     * Метод обновления состояния мира за указанное время
     *
     * @param dt Промежуток времени, за который требуется обновить мир.
     */
    public void update(double dt) {
        for (SpaceObject spaceObj : solarSystem.getSpaceObjects()) {
            if (spaceObj.getName().equals(NameOfObject.SUN)) continue;
            Vector2 np = spaceObj.getPosition()
                    .add(spaceObj.getVelocity().multiplyOnNumber(dt))
                    .add(spaceObj.getAcceleration().multiplyOnNumber(dt * dt * 0.5));
            Vector2 nv = spaceObj.getVelocity()
                    .add(spaceObj.getAcceleration().multiplyOnNumber(dt));

//            List<SpaceObject> otherObjects = new LinkedList<>();
//            for (SpaceObject otherObject : solarSystem.getSpaceObjects()) {
//                if (!otherObject.equals(spaceObj)) {
//                    otherObjects.add(otherObject);
//                }
//            }
//            double Ftr = spaceObj.calculateResultantForce(otherObjects);
//
//            spaceObj.setAcceleration(Ftr.multiplyOnNumber(1 / spaceObj.getMass()));
//            spaceObj.setVelocity(nv);
//            spaceObj.setPosition(np);
//            spaceObj.setResultantForce(Ftr);


            Vector2 resultantForce = new Vector2(0, 0);
            for (SpaceObject body : solarSystem.getSpaceObjects()) {
                if (spaceObj.equals(body)) continue;
                ForceSource force = new ForceSource(body.getPosition(),
                        body.calculateGravitationalForce(spaceObj));
                Vector2 forceAtPoint = force.getForceAt(np);
                resultantForce = resultantForce.add(forceAtPoint);
            }
            spaceObj.setAcceleration(resultantForce.multiplyOnNumber(1 / spaceObj.getMass()));
            spaceObj.setVelocity(nv);
            spaceObj.setPosition(np);
            spaceObj.addPointToOrbit(spaceObj.getPosition());
        }
    }

    /**
     * Метод рисует ткущее состояние мира.
     * На самом деле всю логику рисования стоит вынести из этого класса
     * куда-нибудь в WroldDrawer, унаследованный от IDrawer
     *
     * @param g  Графикс, на котором надо нарисовать текущее состояние.
     * @param sc Актуальный конвертер координат.
     */
    public void draw(Graphics2D g, ScreenConverter sc) {
        for (SpaceObject spaceObject : solarSystem.getSpaceObjects()) {
            ScreenPoint pc = sc.r2s(spaceObject.getPosition());

            double radius = spaceObject.getRadius();
            g.setColor(Color.WHITE);
            switch (spaceObject.getName()) {
                case SUN -> {
                    radius /= 10;
                }
                case MERCURY, PLUTO -> {
                    radius *= 10;
                }
                case VENUS, EARTH -> {
                    radius *= 3;
                }
                case MARS -> {
                    radius *= 5;
                }
                case JUPITER, SATURN -> {
                    radius /= 2;
                }
                case URANUS, NEPTUNE -> {
                    radius /= 1.6;
                }
            }
            int rh = sc.r2sDistanceH(radius);
            int rv = sc.r2sDistanceV(radius);
            try {
                g.drawImage(ImageIO.read(
                        new File(spaceObjImages.get(spaceObject.getName()))), pc.getI() - rh, pc.getJ() - rv,
                        rh + rh, rv + rv, null);
            } catch (IOException e) {
                e.getStackTrace();
            }
            drawOrbit(g, spaceObject);
        }
    }

    public void drawOrbit(Graphics2D g, SpaceObject spaceObject) {
        g.setColor(Color.WHITE);
        int[] xPoints = new int[spaceObject.getOrbit().size()];
        int[] yPoints = new int[spaceObject.getOrbit().size()];
        for (int i = 0; i < spaceObject.getOrbit().size(); i++) {
            xPoints[i] = (int) spaceObject.getOrbit().get(i).getX();
            yPoints[i] = (int) spaceObject.getOrbit().get(i).getY();
        }
        g.drawPolyline(xPoints, yPoints, spaceObject.getOrbit().size());
    }

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

}
