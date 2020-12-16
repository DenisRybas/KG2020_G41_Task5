/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rybas;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Alexey
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
