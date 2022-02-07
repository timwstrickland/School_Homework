package com.company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShapesUI extends JFrame {
    private static String getStringAttribute(String parameterName) {
        JTextField parameterInputTextField = new JTextField();
        JOptionPane.showMessageDialog(null, parameterInputTextField, "What is the " + parameterName + "?",
                JOptionPane.QUESTION_MESSAGE);
        return parameterInputTextField.getText();
    }

    private static Double getDoubleAttribute(String attributeName) {
        Double value = Double.parseDouble(getStringAttribute(attributeName));
        while (!(value >= 1)) {
            JOptionPane.showMessageDialog(null, "Bad input, please input a number greater than 0");
            value = Double.parseDouble(getStringAttribute(attributeName));
        }
        return value;
    }

    private abstract static class MenuEntry {
        private final String label;

        public MenuEntry(String label) {
            this.label = label;
        }

        public String toString() {
            return label;
        }

        abstract public Shape get();
    }

    private final static MenuEntry circleEntry = new MenuEntry("Circle") {

        @Override
        public Shape get() {
            return new Circle(getDoubleAttribute("radius"));
        }
    };

    private final static MenuEntry rectangleEntry = new MenuEntry("Rectangle") {

        @Override
        public Shape get() {
            return new Rectangle(getDoubleAttribute("width"), getDoubleAttribute("length"));
        }
    };

    private final static MenuEntry squareEntry = new MenuEntry("Square") {

        @Override
        public Shape get() {
            return new Square(getDoubleAttribute("side"));
        }
    };

    private final static MenuEntry triangleEntry = new MenuEntry("Triangle") {

        @Override
        public Shape get() {
            return new Triangle(getDoubleAttribute("height"), getDoubleAttribute("base"));
        }
    };

    private final static MenuEntry coneEntry = new MenuEntry("Cone") {

        @Override
        public Shape get() {
            return new Cone(getDoubleAttribute("radius"), getDoubleAttribute("height"));
        }
    };

    private final static MenuEntry cubeEntry = new MenuEntry("Cube") {

        @Override
        public Shape get() {
            return new Cube(getDoubleAttribute("edge"));
        }
    };

    private final static MenuEntry cylinderEntry = new MenuEntry("Cylinder") {

        @Override
        public Shape get() {
            return new Cylinder(getDoubleAttribute("radius"), getDoubleAttribute("height"));
        }
    };

    private final static MenuEntry sphereEntry = new MenuEntry("Sphere") {

        @Override
        public Shape get() {
            return new Sphere(getDoubleAttribute("radius"));
        }
    };

    private final static MenuEntry torusEntry = new MenuEntry("Torus") {

        @Override
        public Shape get() {
            return new Torus(getDoubleAttribute("majorRadius"), getDoubleAttribute("minorRadius"));
        }
    };

    private final ShapeDisplayPanel shapeDisplayPanel = new ShapeDisplayPanel();

    public ShapesUI() {
        super("Shape Builder and Visualizer");
        Map<String, MenuEntry> shapesMenu = new TreeMap<>();
        shapesMenu.put(circleEntry.toString(), circleEntry);
        shapesMenu.put(rectangleEntry.toString(), rectangleEntry);
        shapesMenu.put(squareEntry.toString(), squareEntry);
        shapesMenu.put(triangleEntry.toString(), triangleEntry);
        shapesMenu.put(coneEntry.toString(), coneEntry);
        shapesMenu.put(cubeEntry.toString(), cubeEntry);
        shapesMenu.put(cylinderEntry.toString(), cylinderEntry);
        shapesMenu.put(sphereEntry.toString(), sphereEntry);
        shapesMenu.put(torusEntry.toString(), torusEntry);
        JComboBox<String> shapeChoices = new JComboBox<>(shapesMenu.keySet().toArray(new String[0]));
        JButton createButton = new JButton("Create Shape");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = shapeChoices.getSelectedItem().toString();
                createShape(key, shapesMenu.get(key));
            }
        });
        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(shapeChoices);
        controlPanel.add(createButton);
        add(controlPanel, BorderLayout.NORTH);
        add(shapeDisplayPanel, BorderLayout.CENTER);
        setSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createShape(String shapeName, MenuEntry menuEntry) {
        try {
            shapeDisplayPanel.setShape(menuEntry.get());
        } catch (Exception inputError)
        {
            JOptionPane.showMessageDialog(null, "Invalid shape: " + shapeName, null, JOptionPane.ERROR_MESSAGE);
        }
    }
}
