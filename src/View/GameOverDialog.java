package View;

import Model.*;
import View.Templates.Dialog;

import javax.swing.*;

/**
 * This class displays game over dialog.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GameOverDialog extends Dialog {

    private static final long serialVersionUID = 2403268281146272515L;

	private JLabel score;
    private JButton mainmenu;
    private JButton newgame;

    public GameOverDialog(JFrame parent, GameModel model){
        super(parent, model, "Game Over!");
        content();
    }

    public void content(){

        score = new JLabel("", SwingConstants.CENTER);
        getContentPane().add(score, "Center");

        // BUTTON: Game over!
        mainmenu = new JButton("Main Menu");
        buttons.add(mainmenu);

        // BUTTON: New game
        newgame = new JButton("New Game");
        buttons.add(newgame);

    }

    public void updateScore(){
    	String s = "Score = " + model.getSnake().getScore();
    	score.setText(s);
    }

    public JButton getMainmenuButton(){ return mainmenu; }

    public JButton getNewgameButton(){ return newgame; }
}
