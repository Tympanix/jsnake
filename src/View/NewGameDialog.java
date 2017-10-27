package View;

import Model.GameModel;
import View.Templates.Dialog;

import javax.swing.*;

/**
 * Class to warn user, when entering Settings during a game.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class NewGameDialog extends Dialog {
	private static final long serialVersionUID = -1544535627928294791L;
	
	private JButton okButton;
    private JButton cancelButton;

    public NewGameDialog(JFrame parent, GameModel model){
        super(parent, model, "Warning!");
        content();
    }

    public void content(){

        JLabel text = new JLabel("Your game will be lost if you continue", SwingConstants.CENTER);
        getContentPane().add(text, "Center");

        // BUTTON: Game over!
        okButton = new JButton("Continue");
        buttons.add(okButton);

        // BUTTON: New game
        cancelButton = new JButton("Cancel");
        buttons.add(cancelButton);

    }

    public JButton getOkButton(){ return okButton; }

    public JButton getCancelButton(){ return cancelButton; }

}
