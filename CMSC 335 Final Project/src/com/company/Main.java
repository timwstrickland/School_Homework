package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
    private static int playCount;
    private static int pauseCount;
    private long startTime;
    private long endTime;
    private long timeElapsed;
    private static JLabel elapsedTimer;
    private TrafficManager trafficManager;
    private TrafficDisplay trafficDisplay;
    Main() {
        super("Road");
        playCount = 0;
        pauseCount = 0;
        setLayout(new BorderLayout());
        JPanel timerPanel = new JPanel(new FlowLayout());
        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        elapsedTimer = new JLabel();
        elapsedTimer.setForeground(Color.BLUE);
        elapsedTimer.setFont(new Font("Serif", Font.BOLD, 36));
        pauseButton.setEnabled(false);
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
        add(timerPanel, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1500, 600));
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playCount %2  == 0) {
                    trafficManager = new TrafficManager(1400, 300, 1L);
                    trafficManager.add();
                    trafficDisplay = new TrafficDisplay(trafficManager);
                    add(trafficDisplay, BorderLayout.CENTER);
                    playButton.setText("Stop");
                    pauseButton.setEnabled(true);
                    startTime = System.nanoTime();
                    new Thread(trafficManager).start();
                    new Timer(40, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ignored) {
                            trafficDisplay.repaint();
                        }
                    }).start();
                }
                else {
                    playButton.setText("Play");
                    pauseButton.setText("Pause");
                    pauseCount = 0;
                    pauseButton.setEnabled(false);
                    endTime = System.nanoTime();
                    timeElapsed = (endTime - startTime)/1000000000;
                    elapsedTimer.setText("" + timeElapsed + " seconds(s)");
                    remove(trafficDisplay);
                }
                playCount++;
            }
        });
    }
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
