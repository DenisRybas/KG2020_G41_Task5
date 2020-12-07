package rybas.model.system;

import rybas.math.Rectangle;
import rybas.math.Vector2;
import rybas.model.planet.Planet;
import rybas.model.planet.SpaceObject;
import rybas.model.planet.Star;

import java.util.List;

public class System {
    private Rectangle system;

    private List<SpaceObject> spaceObjects;

    public System(Rectangle system, List<SpaceObject> spaceObjects) {
        this.system = system;
        this.spaceObjects = spaceObjects;
    }

    public System(Rectangle system) {
        this.system = system;
    }

    public System() {
        system = new Rectangle(new Vector2(0, 0),
                new Vector2(1920, 1080));
    }

    public Rectangle getSystem() {
        return system;
    }

    public void setSpaceObjects(List<SpaceObject> spaceObjects) {
        this.spaceObjects = spaceObjects;
    }

    public List<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void addSpaceObject(SpaceObject spaceObject) {
        spaceObjects.add(spaceObject);
    }

    public void removeSpaceObject(SpaceObject spaceObject) {
        spaceObjects.remove(spaceObject);
    }
}
