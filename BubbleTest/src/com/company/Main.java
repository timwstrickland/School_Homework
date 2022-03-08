package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
    private static int playCount;
    private static int pauseCount;
    long startTime;
    long endTime;
    long timeElapsed;
    private static JLabel elapsedTimer;
    Main() {
        super("Road");
        playCount = 0;
        pauseCount = 0;
        TrafficManager trafficManager = new TrafficManager(1400, 300, 1L);
        trafficManager.add();
//        for (int index = 0; index < 10; ++index) {
//            trafficManager.add();
//        }
        TrafficDisplay trafficDisplay = new TrafficDisplay(trafficManager);
        setLayout(new BorderLayout());
        JPanel timerPanel = new JPanel(new FlowLayout());
        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        elapsedTimer = new JLabel();
        elapsedTimer.setForeground(Color.BLUE);
        elapsedTimer.setFont(new Font("Serif", Font.BOLD, 36));
        pauseButton.setEnabled(false);
        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(playCount %2  == 0) {
                    playButton.setText("Stop");
                    pauseButton.setEnabled(true);
                    startTime = System.nanoTime();
                }
                else {
                    playButton.setText("Play");
                    pauseButton.setText("Pause");
                    pauseCount = 0;
                    pauseButton.setEnabled(false);
                    endTime = System.nanoTime();
                    timeElapsed = (endTime - startTime)/1000000000;
                    elapsedTimer.setText("" + timeElapsed + " seconds(s)");
                }
                playCount++;
            }
        });

//        playButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                trafficManager.add();
//                trafficDisplay.repaint();
//
//            }
//        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pauseCount%2 == 0) {
                    pauseButton.setText("Continue");
                }
                else {
                    pauseButton.setText("Pause");
                }
                pauseCount++;
            }
        });
        controlPanel.add(playButton);
        timerPanel.add(elapsedTimer);
        controlPanel.add(pauseButton);
        add(controlPanel, BorderLayout.SOUTH);
        add(trafficDisplay, BorderLayout.CENTER);
        add(timerPanel, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1500, 600));
        new Thread(trafficManager).start();
        new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored) {
                trafficDisplay.repaint();
            }
        }).start();
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }

}
