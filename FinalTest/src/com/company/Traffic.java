package com.company;

import javax.swing.*;
import java.awt.*;

public class Traffic {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Road");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new TrafficCanvas());
        frame.setVisible(true);
    }
}

class TrafficCanvas extends JComponent {

    private int lastX = 0;

    public TrafficCanvas() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });
        animationThread.start();
    }

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        // get the width and height of the GUI.
        int w = getWidth();
        int h = getHeight();
        // get the width and height of the vehicle, along with its speed.
        int carW = 20;
        int carH = 20;
        int carSpeed = 3;
        int x = lastX + carSpeed;
        if (x > w + carW) {
            x = -carW;
        }
        gg.setColor(Color.BLACK);
        gg.fillRect(x, h/2 + carH, carW, carH);
        lastX = x;
    }
}
