package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for Settings-menu.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class SettingsControl extends Control implements ActionListener {

    public SettingsControl(GameModel model, GameFrame view, Controller controller){
        super(model, view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Slow")){
            controller.setTimer(controller.getSpeedSlow());
        } else if (s.equals("Medium")){
            controller.setTimer(controller.getSpeedMedium());
        } else if (s.equals("Fast")){
            controller.setTimer(controller.getSpeedFast());
        } else if (s.equals("Customization")) {
            view.getCardPanel().showCustomizationPanel();
        } else if (s.equals("Back")){
            view.getCardPanel().showMainCard();
            model.updateTrack();
            view.resetGamePanel();
        }

    }
}
