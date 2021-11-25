package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Project2 extends Frame implements ActionListener, ItemListener, TextListener {
    //Set Variables
    ArrayList<String> vehicles = new ArrayList<String>();
    private int radioState;
    Button taxButton = new Button("Compute Sales Tax");
    Button clearButton = new Button("Clear Fields");
    Button displayReportButton = new Button("Display Report");
    Label make = new Label("Make");
    Label model = new Label("Model");
    Label salesPrice = new Label("Sales Price");
    Label milesPerGallon = new Label("Miles per Gallon");
    Label weightInPounds = new Label("Weight in Pounds");
    TextField t1 = new TextField ("", 30);
    TextField t2 = new TextField ("", 30);
    TextField t3 = new TextField ("", 30);
    TextField t4 = new TextField ("", 20);
    TextField t5 = new TextField ("", 20);
    TextArea ta1 = new TextArea("", 1, 20);
    CheckboxGroup vehicleTypeSelected = new CheckboxGroup();
    Checkbox hybrid = new Checkbox("Hybrid", false, vehicleTypeSelected);
    Checkbox electric = new Checkbox("Electric", false, vehicleTypeSelected);
    Checkbox other = new Checkbox("Other", true, vehicleTypeSelected);


    public Project2() {
        super("Automobile Sales Tax Calculator");
        setLayout(new FlowLayout());
        add(taxButton);
        taxButton.addActionListener(this);
        clearButton.addActionListener(this);
        displayReportButton.addActionListener(this);
        hybrid.addItemListener(this);
        electric.addItemListener(this);
        other.addItemListener(this);
        add(clearButton);
        add(displayReportButton);
        add(make);
        add(model);
        add(salesPrice);
        add(milesPerGallon);
        add(weightInPounds);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(ta1);
        add(hybrid);
        add(electric);
        add(other);
    }

    public static void main(String[] args) {
        Project2 p2 = new Project2();
        p2.setSize(400, 400);
        p2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == taxButton) {
            if (radioState == 1) {
                Hybrid hybrid = new Hybrid(t1.getText(), t2.getText(), (Integer.parseInt(t3.getText())),
                        Integer.parseInt(t4.getText()));
                ta1.setText(String.valueOf(hybrid.salesTax(Integer.parseInt(t3.getText()))));
                vehicles.add(hybrid.toString());
            }
            else if (radioState == 2) {
                Electric electric = new Electric(t1.getText(), t2.getText(), (Integer.parseInt(t3.getText())),
                        Integer.parseInt(t5.getText()));
                ta1.setText(String.valueOf(electric.salesTax(Integer.parseInt(t3.getText()))));
                vehicles.add(electric.toString());
            }
            else {
                Automobile automobile = new Automobile(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()));
                ta1.setText(String.valueOf(automobile.salesTax(Integer.parseInt(t3.getText()))));
                vehicles.add(automobile.toString());
            }
        }

        if (e.getSource() == clearButton) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            ta1.setText("");
        }

        if (e.getSource() == displayReportButton) {
            Frame frame = new Frame();
            frame.setSize(500, 300);
            frame.setLayout(new FlowLayout());
            TextArea ta2 = new TextArea(5, 50);
            frame.add(ta2);
            frame.setVisible(true);
            ta2.setText("" + vehicles);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (hybrid.getState()) {
            this.radioState = 1;
        }
        if (electric.getState()) {
            this.radioState = 2;
        }
        if (other.getState()) {
            this.radioState = 3;
        }
    }

    @Override
    public void textValueChanged(TextEvent e) {

    }
}
