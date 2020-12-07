/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rybas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import rybas.math.Rectangle;
import rybas.math.Vector2;
import rybas.model.system.SolarSystem;
import rybas.timers.AbstractWorldTimer;

import javax.swing.JPanel;
import javax.swing.Timer;

import rybas.model.planet.Planet;
import rybas.model.World;
import rybas.timers.UpdateWorldTimer;
import rybas.utils2d.ScreenConverter;
import rybas.utils2d.ScreenPoint;

/**
 * @author Alexey
 */
public class DrawPanel extends JPanel implements ActionListener,
        MouseListener, MouseMotionListener, MouseWheelListener {
    private ScreenConverter sc;
    private World world;
    private AbstractWorldTimer worldTimer;
    private Timer drawTimer;

    public DrawPanel() {
        super();
        SolarSystem solarSystem = new SolarSystem(
                new Rectangle(0, 0, 800, 600));
        world = new World(new Planet(1, 0.3, new Vector2(0, 0),
                100, f);
        sc = new ScreenConverter(f.getRectangle(), 450, 450);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);

        (worldTimer = new UpdateWorldTimer(world, 10)).start();
        drawTimer = new Timer(40, this);
        drawTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        world.draw((Graphics2D) bi.getGraphics(), sc);
        g.drawImage(bi, 0, 0, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int direction = 0;
        if (e.getButton() == MouseEvent.BUTTON1)
            direction = 1;
        else if (e.getButton() == MouseEvent.BUTTON3)
            direction = -1;
        world.getExternalForce().setValue(10 * direction);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        world.getExternalForce().setValue(0);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        world.getExternalForce().setLocation(sc.s2r(new ScreenPoint(e.getX(), e.getY())));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        world.getExternalForce().setLocation(sc.s2r(new ScreenPoint(e.getX(), e.getY())));
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double oldMu = world.getSolarSystem().getMu();
        oldMu = Math.round(oldMu * 100 + e.getWheelRotation()) * 0.01;

        if (oldMu < -1)
            oldMu = -1;
        else if (oldMu > 1)
            oldMu = 1;
        else if (Math.abs(oldMu) < 0.005)
            oldMu = 0;
        world.getSolarSystem().setMu(oldMu);
    }

}
