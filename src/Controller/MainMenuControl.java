package Controller;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for main menu.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class MainMenuControl extends Control implements ActionListener {


    public MainMenuControl(GameModel model, GameFrame view, Controller controller){
        super(model, view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // NEW GAME!
        if (s.equals("New Game")) {
            model.newGame();
            view.update();
            view.getCardPanel().showGameCard();
            controller.startGame();
            // SETTINGS!
        } else if (s.equals("Settings")) {
            if (model.getIsGameStarted()) {
                view.showNewGameDialog(true);
            } else {
                view.getCardPanel().showSettingsCard();
            }
            // EXIT!
        } else if (s.equals("Exit")) {
            System.exit(0);
            // RESUME!
        } else if (s.equals("Resume")) {
            view.getCardPanel().showGameCard();
            controller.startGame();
            // HIGH SCORE!
        } else if (s.equals("High Scores")) {
            view.getCardPanel().getHighScoresPanel().update();
            view.getCardPanel().showHighScoresPanel();
        }

    }
}
