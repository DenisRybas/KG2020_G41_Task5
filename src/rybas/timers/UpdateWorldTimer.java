/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rybas.timers;

import rybas.model.World;

/**
 *
 * @author Alexey
 */
public class UpdateWorldTimer extends AbstractWorldTimer {

    private long last;
    public UpdateWorldTimer(World world, int period) {
        super(world, period);
    }
    
    @Override
    void worldAction(World w) {
        long time = System.currentTimeMillis();
        actualWorld.update((time - last) * 0.01);
        last = time;
    }

    @Override
    public void start() {
        last = System.currentTimeMillis();
        super.start();
    }
    
    
}
