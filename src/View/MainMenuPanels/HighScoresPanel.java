package View.MainMenuPanels;

import Model.GameModel;
import View.GameFrame;
import View.Templates.MenuPanelLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Class to display Highscores.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class HighScoresPanel extends MenuPanelLayout {

	private static final long serialVersionUID = 1476073459532457790L;
	
	private JLabel[] scoreLabels;

    public HighScoresPanel(GameModel model, GameFrame view) {
        super(model, view, "High Scores");
    }

    public void content(){

        // Initialize array of JLabels
        this.scoreLabels = new JLabel[model.getHighScore().length];

        //Create wrapper for high scores in center.
        JPanel gridWrapper = new JPanel();
        gridWrapper.setLayout(new GridLayout(10, 2, 30, 20));
        cWrapper.add(gridWrapper);

        //For loop creating labels.
        int placement = 1;
        for (int i = model.getHighScore().length - 1; i >= 0 ; i--) {
            JLabel placementLabel = new JLabel(getNumberWithSuffix(placement));
            gridWrapper.add(placementLabel);
            JLabel score = new JLabel("" + model.getHighScore()[i]);
            scoreLabels[i] = score;
            gridWrapper.add(score);
            placement++;
        }


    }

    //Adds suffix for the placement number.
    public String getNumberWithSuffix(int number) {
        switch (number % 10) {
            case 1: return number + "st";
            case 2: return number + "nd";
            case 3: return number + "rd";
            default: return number + "th";
        }
    }

    public void update() {
        for (int i = model.getHighScore().length - 1; i >= 0 ; i--) {
            scoreLabels[i].setText("" + model.getHighScore()[i]);
        }
    }
}