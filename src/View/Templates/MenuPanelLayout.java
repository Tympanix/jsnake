package View.Templates;

import Model.GameModel;
import View.GameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Template-class for menu-panels.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public abstract class MenuPanelLayout extends JPanel {

	private static final long serialVersionUID = -8256704782700168924L;
	// Model and view
    protected GameModel model;
    protected GameFrame view;

    // Private fields
    private String title;
    private JButton backButton;

    // Containers available for subclasses
    protected JPanel nWrapper;
    protected JPanel cWrapper;
    protected JPanel sWrapper;

    // Constructor for a panel
    public MenuPanelLayout(GameModel model, GameFrame view, String title) {
        this.model = model;
        this.view = view;
        this.title = title;
        this.setLayout(new BorderLayout());
        iniLayout();
        content();
        this.setVisible(true);
    }

    // Constructor for panels without a title
    public MenuPanelLayout(GameModel model, GameFrame view){
        this(model, view, null);
    }

    // All subclasses must add some content to the frame
    public abstract void content();

    // Initial containers for the layout
    public void iniLayout(){

        //Wrapper for content title in north.
        nWrapper = new JPanel();
        nWrapper.setLayout(new GridBagLayout());
        this.add(nWrapper, "North");

        //Label for title.
        if (this.title != null){
            nWrapper.add(Box.createRigidArea(new Dimension(0,50)));
            JLabel titleLabel = new JLabel(this.title);
            nWrapper.add(titleLabel);
        }

        //Wrapper for content in center.
        cWrapper = new JPanel();
        cWrapper.setLayout(new GridBagLayout());
        this.add(cWrapper, "Center");

        //Wrapper for content in South
        sWrapper = new JPanel();
        sWrapper.setLayout(new GridBagLayout());
        this.add(sWrapper, "South");
        sWrapper.add(Box.createRigidArea(new Dimension(0,50)));

        //Back button
        backButton = new JButton("Back");
        sWrapper.add(backButton);
    }

    public JButton getBackButton(){
        return backButton;
    }
}
