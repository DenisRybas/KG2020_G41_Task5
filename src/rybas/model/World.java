package rybas.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import rybas.math.Vector2;
import rybas.model.force.ForceSource;
import rybas.model.planet.Planet;
import rybas.model.planet.SpaceObject;
import rybas.model.system.SolarSystem;
import rybas.utils2d.ScreenConverter;
import rybas.utils2d.ScreenPoint;

public class World {
    private SolarSystem solarSystem;

    public World(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    /**
     * Метод обновления состояния мира за указанное время
     *
     * @param dt Промежуток времени, за который требуется обновить мир.
     */
    public void update(double dt) {
        for (SpaceObject planet : solarSystem.getSpaceObjects()) {
            Vector2 np = planet.getPosition()
                    .add(planet.getVelocity().multiplyOnNumber(dt))
                    .add(planet.getAcceleration().multiplyOnNumber(dt * dt * 0.5));
            Vector2 nv = planet.getVelocity()
                    .add(planet.getAcceleration().multiplyOnNumber(dt));
            double vx = nv.getX(), vy = nv.getY();
            boolean reset = false;
            if (np.getX() - planet.getRadius() < solarSystem.getSystem()
                    .getLeft()
                    || np.getX() + planet.getRadius() > solarSystem.getSystem()
                    .getRight()) {
                vx = -vx;
                reset = true;
            }
            if (np.getY() - planet.getRadius() < solarSystem.getSystem()
                    .getBottom()
                    || np.getY() + planet.getRadius() > solarSystem
                    .getSystem().getTop()) {
                vy = -vy;
                reset = true;
            }
            nv = new Vector2(vx, vy);
            if (nv.length() < 1e-10)
                nv = new Vector2(0, 0);
            if (reset)
                np = planet.getPosition();
            Vector2 Ftr = planet.getPosition();
            List<SpaceObject> otherObjects = new LinkedList<>();
            for (SpaceObject otherObject : solarSystem.getSpaceObjects()) {
                if (!otherObject.equals(planet)) {
                    otherObjects.add(otherObject);
                }
            }
            Ftr.add(planet.calculateResultantForce(otherObjects));
            planet.setAcceleration(Ftr.multiplyOnNumber(1 / planet.getMass()));
            planet.setVelocity(nv);
            planet.setPosition(np);
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
        ScreenPoint tl = sc.r2s(solarSystem.getSystem().getTopLeft());
        int w = sc.r2sDistanceH(solarSystem.getSystem().getWidth());
        int h = sc.r2sDistanceV(solarSystem.getSystem().getHeight());
        g.setColor(Color.WHITE);
        g.fillRect(tl.getI(), tl.getJ(), w, h);
        g.setColor(Color.RED);
        g.drawRect(tl.getI(), tl.getJ(), w, h);
        for (SpaceObject spaceObject : solarSystem.getSpaceObjects()) {
            ScreenPoint pc = sc.r2s(spaceObject.getPosition());
            int rh = sc.r2sDistanceH(spaceObject.getRadius());
            int rv = sc.r2sDistanceV(spaceObject.getRadius());
            g.setColor(Color.BLACK);
            g.fillOval(pc.getI() - rh, pc.getJ() - rv, rh + rh, rv + rv);
        }
    }

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

}
