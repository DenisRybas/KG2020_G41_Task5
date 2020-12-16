/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rybas.model.planet;

import rybas.math.Vector2;

import java.util.List;

public class Planet extends SpaceObject {
    private List<Moon> moonList;

    public Planet(NameOfObject name, Vector2 position,
                  double mass, double radius,
                  Vector2 velocity, List<Moon> moonList) {
        super(name, mass, radius, position ,velocity);
        this.moonList = moonList;
    }

    public void setMoonList(List<Moon> moonList) {
        this.moonList = moonList;
    }

    public List<Moon> getMoonList() {
        return moonList;
    }
}
