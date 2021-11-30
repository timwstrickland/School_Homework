package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

public class Project2 extends JFrame implements ActionListener, ItemListener, TextListener {
    // Set Variables
    // Create 3 panels for the GUI
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel bottomPanel;
    // Data Structure to store our vehicles
    ArrayList<String> vehicles = new ArrayList<String>();
    // Create buttons
    private int radioState;
    private JButton computeSalesTaxButton;
    private JButton clearFieldsButton;
    private JButton displayReportButton;
    // Create labels
    private JLabel makeModel;
    private JLabel salesPrice;
    private JLabel milesPerGallon;
    private JLabel weightInPounds;
    // Create Text Fields
    private JTextField jtfMakeModel;
    private JTextField jtfSalesTax;
    private JFormattedTextField jtfSalesPrice;
    private JFormattedTextField jtfMilesPerGallon;
    private JFormattedTextField jtfWeightInPounds;
    // Create the radio buttons
    private JRadioButton hybrid;
    private JRadioButton electric;
    private JRadioButton other;
    // Group the radio buttons
    ButtonGroup vehicleType = new ButtonGroup();

    public Project2() {
        // create the frame
        super("Automobile Sales Tax Calculator");
        GridBagLayout gbl= new GridBagLayout();
        setLayout(gbl);
        // Create the first panel with layout
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        //Place border here
        // Create Grid Bag fields, add constraints and add the JPanel in the cells for the top panel.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(topPanel, gbc);
        makeModel = new JLabel("Make and Model");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(makeModel, gbc);
        salesPrice = new JLabel("Sales Price");
        gbc.gridy = 1;
        topPanel.add(salesPrice, gbc);
        jtfMakeModel = new JTextField(10);
        gbc.gridx = 2;
        gbc.gridy = 0;
        topPanel.add(jtfMakeModel, gbc);
        //Create a number formatter to only allow integers in the fields and remove commas.
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setGroupingUsed(false);
        NumberFormatter nft = new NumberFormatter(nf);
        nft.setAllowsInvalid(false);
        jtfSalesPrice = new JFormattedTextField(nft);
        jtfSalesPrice.setColumns(10);
        gbc.gridy = 1;
        topPanel.add(jtfSalesPrice, gbc);
        final JPanel spacerTop = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15,15,15,15);
        topPanel.add(spacerTop, gbc);
        // Create Grid Bag fields, add constraints and add the JPanel in the cells for the mid panel.
        midPanel = new JPanel();
        midPanel.setLayout(new GridBagLayout());
        midPanel.setPreferredSize((new Dimension(370, 122)));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(midPanel, gbc);
        // Create mid panel layer
        midPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Automobile Type",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        hybrid = new JRadioButton();
        hybrid.setText("Hybrid");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        midPanel.add(hybrid, gbc);
        final JPanel spacerMid1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        midPanel.add(spacerMid1, gbc);
        electric = new JRadioButton("Electric");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        midPanel.add(electric, gbc);
        other = new JRadioButton("Other");
        gbc.gridy = 2;
        midPanel.add(other, gbc);
        milesPerGallon = new JLabel("Miles Per Gallon");
        gbc.gridx = 2;
        gbc.gridy = 0;
        midPanel.add(milesPerGallon, gbc);
        weightInPounds = new JLabel("Weight in Pounds");
        gbc.gridy = 1;
        midPanel.add(weightInPounds, gbc);
        final JPanel spacerMid2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        midPanel.add(spacerMid2, gbc);
        jtfMilesPerGallon = new JFormattedTextField(nft);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        jtfMilesPerGallon.setColumns(10);
        midPanel.add(jtfMilesPerGallon, gbc);
        jtfWeightInPounds = new JFormattedTextField(nft);
        gbc.gridy = 1;
        jtfWeightInPounds.setColumns(10);
        midPanel.add(jtfWeightInPounds, gbc);
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(bottomPanel, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        computeSalesTaxButton = new JButton("Compute Sales Tax");
        computeSalesTaxButton.setPreferredSize(new Dimension(150, 25));
        bottomPanel.add(computeSalesTaxButton, gbc);
        gbc.gridy = 2;
        clearFieldsButton = new JButton("Clear Fields");
        clearFieldsButton.setPreferredSize(new Dimension(150, 25));
        bottomPanel.add(clearFieldsButton, gbc);
        final JPanel bottomSpacer = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        bottomPanel.add(bottomSpacer, gbc);
        jtfSalesTax = new JFormattedTextField();
        jtfSalesTax.setColumns(13);
        jtfSalesTax.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        bottomPanel.add(jtfSalesTax, gbc);
        displayReportButton = new JButton("Display Report");
        displayReportButton.setPreferredSize(new Dimension(150, 25));
        gbc.gridy = 2;
        // Add buttons to buttongroup
        vehicleType.add(hybrid);
        vehicleType.add(electric);
        vehicleType.add(other);
        // Add event listeners
        bottomPanel.add(displayReportButton, gbc);
        computeSalesTaxButton.addActionListener(this);
        clearFieldsButton.addActionListener(this);
        displayReportButton.addActionListener(this);
        hybrid.addItemListener(this);
        electric.addItemListener(this);
        other.addItemListener(this);
        jtfSalesPrice.setValue(0);
        jtfWeightInPounds.setValue(0);
        jtfMilesPerGallon.setValue(0);
        other.setSelected(true);
        jtfSalesPrice.setToolTipText("This field is formatted for numbers only. Letters and Special Characters will not work\n" +
                "When erasing the number, please highlight it and type the new number, or press the button Clear Fields");
    }

    public static void main(String[] args) {
        Project2 p2 = new Project2();
        p2.setSize(450, 450);
        p2.setVisible(true);
        p2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        double x = 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == computeSalesTaxButton) {
            if (radioState == 1) {
                Hybrid hybrid = new Hybrid(jtfMakeModel.getText(), (Integer.parseInt(jtfSalesPrice.getText())),
                        Integer.parseInt(jtfMilesPerGallon.getText()));
                jtfSalesTax.setText(String.valueOf(hybrid.salesTax(Integer.parseInt(jtfSalesPrice.getText()))));
                vehicles.add(hybrid.toString());
            }
            else if (radioState == 2) {
                Electric electric = new Electric(jtfMakeModel.getText(), (Integer.parseInt(jtfSalesPrice.getText())),
                        Integer.parseInt(jtfWeightInPounds.getText()));
                jtfSalesTax.setText(String.valueOf(electric.salesTax(Integer.parseInt(jtfSalesPrice.getText()))));
                vehicles.add(electric.toString());
            }
            else {
                Automobile automobile = new Automobile(jtfMakeModel.getText(), Integer.parseInt(jtfSalesPrice.getText()));
                jtfSalesTax.setText(String.valueOf(automobile.salesTax(Integer.parseInt(jtfSalesPrice.getText()))));
                vehicles.add(automobile.toString());
            }
        }

        if (e.getSource() == clearFieldsButton) {
            jtfMakeModel.setText("");
            jtfSalesPrice.setValue(0);
            jtfMilesPerGallon.setValue(0);
            jtfWeightInPounds.setValue(0);
            jtfSalesTax.setText("");
        }

        if (e.getSource() == displayReportButton) {
            JFrame frame = new JFrame();
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

        if (hybrid.isSelected()) {
            this.radioState = 1;
            jtfMilesPerGallon.setEditable(true);
            jtfWeightInPounds.setEditable(false);
        }
        if (electric.isSelected()) {
            this.radioState = 2;
            jtfWeightInPounds.setEditable(true);
            jtfMilesPerGallon.setEditable(false);
        }
        if (other.isSelected()) {
            this.radioState = 3;
            jtfMilesPerGallon.setEditable(false);
            jtfWeightInPounds.setEditable(false);
        }
    }

    @Override
    public void textValueChanged(TextEvent e) {

    }
}
