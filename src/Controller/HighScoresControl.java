package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionsListener for HighScore.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class HighScoresControl extends Control implements ActionListener {

    public HighScoresControl(GameModel model, GameFrame view, Controller controller){
        super(model, view, controller);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Back")) {
            view.getCardPanel().showMainCard();
        }
    }

}
