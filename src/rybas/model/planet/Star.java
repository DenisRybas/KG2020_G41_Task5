package rybas.model.planet;

import rybas.math.Vector2;

public class Star extends SpaceObject {
    public Star(NameOfObject name, Vector2 position,
                double mass, double radius) {
        super(name, mass, radius, position, new Vector2(0, 0));
    }
}
