package com.company;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class DiscussionWeek4 extends JFrame implements ActionListener {
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    private JButton decimal;
    private JButton negative;
    private JButton divide;
    private JButton multiply;
    private JButton subtract;
    private JButton add;
    private JFormattedTextField field;

    DiscussionWeek4() {
        super("Basic Calculator");
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        //set up panels
        JPanel firstPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel bottomMidPanel = new JPanel();
        JPanel topMidPanel = new JPanel();
        JPanel topPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstPanel, gbc);
        gbc.gridy = 1;
        add(topPanel, gbc);
        gbc.gridy = 2;
        add(topMidPanel, gbc);
        gbc.gridy = 3;
        add(bottomMidPanel, gbc);
        gbc.gridy = 4;
        add(bottomPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setGroupingUsed(false);
        NumberFormatter nft = new NumberFormatter(nf);
        nft.setAllowsInvalid(false);
        field = new JFormattedTextField(nft);
        field.setColumns(20);
        field.setEditable(false);
        firstPanel.add(field, gbc);
        zero = new JButton("0");
        zero.addActionListener(this);
        bottomPanel.add(zero);
        gbc.gridx = 1;
        negative = new JButton("-");
        negative.addActionListener(this);
        bottomPanel.add(negative);
        gbc.gridx = 2;
        decimal = new JButton("(-)");
        decimal.addActionListener(this);
        bottomPanel.add(decimal);
        gbc.gridx = 3;
        add = new JButton("+");
        add.addActionListener(this);
        bottomPanel.add(add);
        gbc.gridx = 0;
        one = new JButton("1");
        one.addActionListener(this);
        bottomMidPanel.add(one);
        gbc.gridx = 1;
        two = new JButton("2");
        two.addActionListener(this);
        bottomMidPanel.add(two);
        gbc.gridx = 2;
        three = new JButton("3");
        three.addActionListener(this);
        bottomMidPanel.add(three);
        gbc.gridx = 3;
        subtract = new JButton("-");
        subtract.addActionListener(this);
        bottomMidPanel.add(subtract);
        gbc.gridx = 0;
        four = new JButton("4");
        four.addActionListener(this);
        topMidPanel.add(four);
        gbc.gridx = 1;
        five = new JButton("5");
        five.addActionListener(this);
        topMidPanel.add(five);
        gbc.gridx = 2;
        six = new JButton("6");
        six.addActionListener(this);
        topMidPanel.add(six);
        gbc.gridx = 3;
        multiply = new JButton("x");
        multiply.addActionListener(this);
        topMidPanel.add(multiply);
        gbc.gridx = 0;
        seven = new JButton("7");
        seven.addActionListener(this);
        topPanel.add(seven);
        gbc.gridx = 1;
        eight = new JButton("8");
        eight.addActionListener(this);
        topPanel.add(eight);
        gbc.gridx = 2;
        nine = new JButton("9");
        nine.addActionListener(this);
        topPanel.add(nine);
        gbc.gridx = 3;
        divide = new JButton("/");
        divide.addActionListener(this);
        topPanel.add(divide);

    }
    public static void main(String[] args) {
        DiscussionWeek4 d4 = new DiscussionWeek4();
        d4.setSize(250, 300);
        d4.setVisible(true);
        d4.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == zero) {
            field.setText(String.valueOf(0));
        }
        if (e.getSource() == one) {
            field.setText(String.valueOf(1));
        }
        if (e.getSource() == two) {
            field.setText(String.valueOf(2));
        }
        if (e.getSource() == three) {
            field.setText(String.valueOf(3));
        }
        if (e.getSource() == four) {
            field.setText(String.valueOf(4));
        }
        if (e.getSource() == five) {
            field.setText(String.valueOf(5));
        }
        if (e.getSource() == six) {
            field.setText(String.valueOf(6));
        }
        if (e.getSource() == seven) {
            field.setText(String.valueOf(7));
        }
        if (e.getSource() == eight) {
            field.setText(String.valueOf(8));
        }
        if (e.getSource() == nine) {
            field.setText(String.valueOf(9));
        }
    }
}
