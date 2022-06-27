package de.joshi1999.colorpicker.window.components;

import de.joshi1999.colorpicker.window.helper.SliderHandler;
import de.joshi1999.colorpicker.window.helper.WindowHandler;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JSlider RED;
    private JSlider GREEN;
    private JSlider BLUE;
    private JPanel panel;
    // private JSlider ALPHA = new JSlider();

    public Window() {
        create();
    }

    private void create() {
        setTitle("R: 255, G: 255, B: 255");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(230, 140);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) screen.getWidth() / 2 - getWidth() / 2, (int) screen.getHeight() / 2 - getHeight() / 2);
        setMinimumSize(new Dimension(230, 140));
        setLayout(null);
        panel = new JPanel();
        add(panel);
        configureSliders();
        addComponentListener(new WindowHandler(this));



        setVisible(true);
    }

    private void configureSliders() {
        RED = new JSlider(JSlider.VERTICAL, 0, 255, 255);
        GREEN = new JSlider(JSlider.VERTICAL, 0, 255, 255);
        BLUE = new JSlider(JSlider.VERTICAL, 0, 255, 255);
        SliderHandler handler = new SliderHandler(this);
        RED.addChangeListener(handler);
        GREEN.addChangeListener(handler);
        BLUE.addChangeListener(handler);
        add(RED);
        add(GREEN);
        add(BLUE);
        rearrangeSliders();
        renderPanel();
    }

    public void rearrangeSliders() {
        RED.setLocation(0, 0);
        GREEN.setLocation(25, 0);
        BLUE.setLocation(50, 0);
        RED.setSize(20, getHeight() - 30);
        GREEN.setSize(20, getHeight() - 30);
        BLUE.setSize(20, getHeight() - 30);
    }

    public void renderPanel() {
        float[] color = Color.RGBtoHSB(RED.getValue(), GREEN.getValue(), BLUE.getValue(), null);
        panel.setBackground(Color.getHSBColor(color[0], color[1], color[2]));
        panel.setSize(new Dimension(getWidth() - 75, getHeight()));
        panel.setLocation(75, 0);
    }

    public void changeName() {
        setTitle("R: " + RED.getValue() + ", G: " + GREEN.getValue() + ", B: " + BLUE.getValue() + "; #" + Integer.toHexString(RED.getValue()) + Integer.toHexString(GREEN.getValue()) + Integer.toHexString(BLUE.getValue()));
    }
}
