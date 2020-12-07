package rybas.model.planet;

import rybas.Defaults;
import rybas.math.Vector2;

import java.util.Collection;

public class SpaceObject {

    private double mass, radius;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Vector2 resultantForce;
    private System system;

    public SpaceObject(double mass, double radius, Vector2 position) {
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
        this.resultantForce = new Vector2(0, 0);
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
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

    public double calculateDistance(Vector2 positionOfObject) {
        return Math.sqrt(Math.pow(getPosition().getX() - positionOfObject.getX(), 2)
                + Math.pow(getPosition().getY() - positionOfObject.getY(), 2));
    }

    public Vector2 calculateResultantForce(Collection<SpaceObject>
                                                   objectsInSystem) {
        Vector2 resultantForce = getPosition();
        for (SpaceObject object : objectsInSystem) {
            Vector2 gravityForce = getPosition().add(object.getPosition())
                    .multiplyOnNumber(Defaults.G * getMass() * object.getMass()
                            / Math.pow(calculateDistance(object.getPosition()), 2));
            resultantForce.add(gravityForce);
        }
        return resultantForce;
    }
}
