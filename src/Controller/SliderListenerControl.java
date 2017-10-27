package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

	import javax.swing.JSlider;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.*;


/**
 * ChangeListener for Sliders in Settingsmenu.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */
	
public class SliderListenerControl extends Control implements ChangeListener{

    public SliderListenerControl(GameModel model, GameFrame view, Controller controller) {
        super(model, view, controller);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {

            String name = source.getName();
            if (name.equals("width")) {
                model.setWidth(source.getValue());
                System.out.println("N = " + model.getWidth());

            } else if (name.equals("height")) {
                model.setHeight(source.getValue());
                System.out.println("M = " + model.getHeight());

            }
        }
    }
}
