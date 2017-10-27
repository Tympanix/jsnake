package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for new game dialog.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class NewGameDialogControl extends Control implements ActionListener {

    public NewGameDialogControl(GameModel model, GameFrame view, Controller controller){
        super(model, view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Cancel")) {
            view.showNewGameDialog(false);
        } else if (action.equals("Continue")) {
            controller.pauseGame();
            model.newGame();
            view.update();
            view.getCardPanel().showSettingsCard();
            view.showNewGameDialog(false);
        }
    }
}
