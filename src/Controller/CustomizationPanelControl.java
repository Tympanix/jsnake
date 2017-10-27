package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * //Insert what class is for.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class CustomizationPanelControl extends Control implements ActionListener {

    public CustomizationPanelControl(GameModel model, GameFrame view, Controller controller){
        super(model, view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Back")){
            view.getCardPanel().showSettingsCard();
            return;
        }

        view.getCardPanel().getGamePanel().loadSnake(s);
        view.updatePreview();
    }
}
