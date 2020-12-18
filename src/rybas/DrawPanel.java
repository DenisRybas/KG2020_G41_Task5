/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rybas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import rybas.math.Rectangle;
import rybas.math.Vector2;
import rybas.model.planet.NameOfObject;
import rybas.model.system.SolarSystem;
import rybas.timers.AbstractWorldTimer;

import javax.swing.*;

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
    private Image background = new ImageIcon("stars.jpg").getImage();

    public DrawPanel() {
        super();

        setSize(1920, 1080);
        Defaults.EARTH.addMoon(Defaults.MOON);

        Defaults.JUPITER.addMoon(Defaults.IO);
        Defaults.JUPITER.addMoon(Defaults.GANYMEDE);
        Defaults.JUPITER.addMoon(Defaults.EUROPA);
        Defaults.JUPITER.addMoon(Defaults.CALLISTO);

        Defaults.SATURN.addMoon(Defaults.TITAN);
        Defaults.SATURN.addMoon(Defaults.ENCELADE);
        Defaults.SATURN.addMoon(Defaults.IAPETUS);

        SolarSystem solarSystem = new SolarSystem(
                new Rectangle(0, 1080, 1920, 1080
                        /*0, (int) Defaults.HEIGHT, (int) Defaults.WIDTH, (int) Defaults.HEIGHT*/
                ), new LinkedList<>() {{
            add(Defaults.MARS);
            add(Defaults.EARTH);
            add(Defaults.JUPITER);
            add(Defaults.MERCURY);
            add(Defaults.NEPTUNIUM);
            add(Defaults.PLUTO);
            add(Defaults.SATURN);
            add(Defaults.SUN);
            add(Defaults.URANUS);
            add(Defaults.VENUS);
        }});
        world = new World(solarSystem);
        sc = new ScreenConverter(solarSystem.getSystem(), 1920, 1080);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);

//        (worldTimer = new UpdateWorldTimer(world, 10)).start();
//        drawTimer = new Timer(40, this);
        (worldTimer = new UpdateWorldTimer(world, 23)).start();
        drawTimer = new Timer(23, this);
        drawTimer.start();
    }


    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        bi.getGraphics().drawImage(background, 0, 0, null);
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

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

}
