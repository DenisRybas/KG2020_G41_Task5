package rybas.model.planet;

import rybas.Defaults;
import rybas.math.Vector2;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class SpaceObject {
    private List<Vector2> orbit;
    private NameOfObject name;
    private double mass, radius;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Vector2 resultantForce;
    private System system;

    public SpaceObject(NameOfObject name, double mass, double radius,
                       Vector2 position, Vector2 velocity) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = new Vector2(0, 0);
        this.resultantForce = new Vector2(0, 0);
        this.orbit = new LinkedList<>();
    }

    public NameOfObject getName() {
        return name;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public List<Vector2> getOrbit() {
        return orbit;
    }

    public void setOrbit(List<Vector2> orbit) {
        this.orbit = orbit;
    }

    public void addPointToOrbit(Vector2 point) {
        if (orbit.size() > 100) orbit.remove(0);
        this.orbit.add(point);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public double calculateDistance(SpaceObject spaceObject) {
        return getPosition().minus(spaceObject.getPosition()).length();
    }

    public double calculateGravitationalForce(SpaceObject object) {
        return getMass() * 5.972 * object.getMass()
                / Math.pow(calculateDistance(object), 2);
    }

    public void setResultantForce(Vector2 resultantForce) {
        this.resultantForce = resultantForce;
    }
}
