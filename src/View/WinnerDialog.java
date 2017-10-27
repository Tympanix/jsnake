package View;

import Model.GameModel;
import View.Templates.Dialog;

import javax.swing.*;

/**
 * Class to display winner-dialog.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class WinnerDialog extends Dialog {
	private static final long serialVersionUID = 4523127855223380581L;

	public WinnerDialog(JFrame parent, GameModel model){
        super(parent, model, "Congratualtions!");
        content();
    }

    public void content(){

    }
}
