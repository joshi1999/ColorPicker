package de.joshi1999.colorpicker.window.helper;

import de.joshi1999.colorpicker.window.components.Window;

import java.awt.event.*;

public class WindowHandler implements ComponentListener {
    private Window window;

    public WindowHandler(Window w) {
        window = w;
    }


    @Override
    public void componentResized(ComponentEvent e) {
        window.rearrangeSliders();
        window.renderPanel();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
