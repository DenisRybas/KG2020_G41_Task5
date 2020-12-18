/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rybas.model.planet;

import rybas.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Planet extends SpaceObject {

    public Planet(NameOfObject name, double mass, double radius, Vector2 position, Vector2 velocity) {
        super(name, mass, radius, position, velocity);
    }

}
