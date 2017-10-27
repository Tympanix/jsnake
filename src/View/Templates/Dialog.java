package View.Templates;

import Model.GameModel;
import javax.swing.*;
import java.awt.*;

/**
 * Template-class for dialogs.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public abstract class Dialog extends JDialog {

	private static final long serialVersionUID = -3774047974165496464L;
	protected GameModel model;
    protected JPanel buttons;

    public Dialog(JFrame parent, GameModel model, String titlename){
        super(parent, titlename, true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 150);
        this.setLocationRelativeTo(parent);
        this.setUndecorated(true);
        this.getRootPane().setBorder( BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.buttons = new JPanel();

        JPanel header = new JPanel();
        getContentPane().add(buttons, "South");
        getContentPane().add(header, "North");

        // LABEL: Title
        JLabel title = new JLabel(titlename, ´SwingConstants.CENTER);

        header.add(title);

        this.setVisible(false);
        this.model = model;
    }


}
