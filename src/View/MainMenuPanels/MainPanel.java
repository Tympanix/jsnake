package View.MainMenuPanels;

import Model.GameModel;
import View.GameFrame;


import javax.swing.*;
import java.awt.*;

/**
 * Class to display the main-menu.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class MainPanel extends JPanel {
	private static final long serialVersionUID = -1292012707303263013L;

    private GameModel model;

    private JButton newgameButton;
    private JButton settingButton;
    private JButton exitButton;
    private JButton resumeButton;
    private JButton highScoresButton;

    private Dimension buttonSize;
    
    private static ImageIcon titleImg;

    public MainPanel(GameModel model, GameFrame view){

    	titleImg = new ImageIcon(view.loadImage("Images/Title.png"));
        this.setVisible(true);
        this.model = model;
        this.setLayout(new BorderLayout());
        this.buttonSize = new Dimension(200, 50);
        content();
    }

    public void content(){

        //Title panel
    	JPanel titlePanel= new JPanel();
    	titlePanel.setLayout(new GridBagLayout());
    	this.add(titlePanel,"North");
    	
    	//Title
        JLabel title = new JLabel();
        title.setIcon(titleImg);
        titlePanel.add(title);
    	
    	// Center panel
    	JPanel centerPanel = new JPanel();
    	centerPanel.setLayout(new GridBagLayout());
    	this.add(centerPanel, "Center");
    	
    	// Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 5, 5));
        centerPanel.add(buttonPanel);
        
        // New game button
        newgameButton = new JButton("New Game");
        newgameButton.setPreferredSize(this.buttonSize);
        buttonPanel.add(newgameButton);

        // Resume button
        resumeButton = new JButton("Resume");
        resumeButton.setPreferredSize(this.buttonSize);
        buttonPanel.add(resumeButton);

        // High Scores button
        highScoresButton = new JButton("High Scores");
        highScoresButton.setPreferredSize(this.buttonSize);
        buttonPanel.add(highScoresButton);

        // Setting button
        settingButton = new JButton("Settings");
        settingButton.setPreferredSize(this.buttonSize);
        buttonPanel.add(settingButton);

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(this.buttonSize);
        buttonPanel.add(exitButton);

    }

    public JButton getNewgameButton(){
        return newgameButton;
    }

    public JButton getSettingButton(){
        return settingButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getResumeButton(){ return resumeButton; }

    public JButton getHighScoresButton() { return highScoresButton; }

    public void update(){
        resumeButton.setEnabled(model.getIsGameStarted());
    }
    
    
}
