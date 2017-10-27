package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for gameover-dialog.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GameOverControl extends Control implements ActionListener {

    public GameOverControl(GameModel model, GameFrame view, Controller controller){
        super(model, view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Main Menu")){
            model.newGame();
            view.getCardPanel().showMainCard();
            view.getGameOverDialog().setVisible(false);
            view.update();
        } else if (action.equals("New Game")){
            model.newGame();
            view.update();
            controller.startGame();
            view.getGameOverDialog().setVisible(false);
        }
    }
}
