package de.joshi1999.colorpicker.window.helper;

import de.joshi1999.colorpicker.window.components.Window;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderHandler implements ChangeListener {
    private Window window;


    public SliderHandler(Window w) {
        window = w;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        window.renderPanel();
        window.changeName();
    }
}
