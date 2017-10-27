package Controller;

import Model.GameModel;
import View.GameFrame;
import View.GameOverDialog;
import View.MainMenuPanels.MainPanel;
import View.MainMenuPanels.SettingsPanel;
import View.NewGameDialog;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.*;

/**
 * This class collects all the controllers to the overall Controller.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class Controller {

    private GameModel model;
    private GameFrame view;

    private int speedSlow;
    private int speedMedium;
    private int speedFast;

    private Timer gameTimer;

    public Controller(GameModel model, GameFrame view){
        this.model = model;
        this.view = view;

        this.speedSlow = 250;
        this.speedMedium = 150;
        this.speedFast = 50;

        // Key Listener
        KeyListener gameControl = new GameControl(model, view, this);
        view.getCardPanel().getGamePanel().addKeyListener(gameControl);

        // Game over dialog listener
        ActionListener gameOverControl= new GameOverControl(model, view, this);
        GameOverDialog gameOverDialog = view.getGameOverDialog();
        gameOverDialog.getMainmenuButton().addActionListener(gameOverControl);
        gameOverDialog.getNewgameButton().addActionListener(gameOverControl);

        // Main menu listener
        ActionListener mainMenuControl = new MainMenuControl(model, view, this);
        MainPanel mainPanel = view.getCardPanel().getMainPanel();
        mainPanel.getNewgameButton().addActionListener(mainMenuControl);
        mainPanel.getExitButton().addActionListener(mainMenuControl);
        mainPanel.getSettingButton().addActionListener(mainMenuControl);
        mainPanel.getResumeButton().addActionListener(mainMenuControl);
        mainPanel.getHighScoresButton().addActionListener(mainMenuControl);

        // Settings listener
        ActionListener settingsControl = new SettingsControl(model, view, this);
        SettingsPanel settingsPanel =  view.getCardPanel().getSettingsPanel();
        settingsPanel.getBackButton().addActionListener(settingsControl);
        settingsPanel.getSlowButton().addActionListener(settingsControl);
        settingsPanel.getMediumButton().addActionListener(settingsControl);
        settingsPanel.getFastButton().addActionListener(settingsControl);
        settingsPanel.getCustomizationButton().addActionListener(settingsControl);

        // High Scores listener
        ActionListener highScoresPanelControl = new HighScoresControl(model, view, this);
        view.getCardPanel().getHighScoresPanel().getBackButton().addActionListener(highScoresPanelControl);
        
        // Slider listeners in settings
        ChangeListener sliderSettingsControl = new SliderListenerControl(model,view,this);
        settingsPanel.getWidthSlide().addChangeListener(sliderSettingsControl);
        settingsPanel.getHeightSlide().addChangeListener(sliderSettingsControl);
        
        //AI listener
        ItemListener aIControl = new AIListenerControl(model,view,this);
        settingsPanel.getAIControl().addItemListener(aIControl);
        
        // Newgame dialog listener
        ActionListener newgameControl = new NewGameDialogControl(model, view, this);
        NewGameDialog newGameDialog = view.getNewGameDialog();
        newGameDialog.getOkButton().addActionListener(newgameControl);
        newGameDialog.getCancelButton().addActionListener(newgameControl);

        // Customization listener
        ActionListener customizationPanelControl = new CustomizationPanelControl(model, view, this);
        view.getCardPanel().getCustomizationPanel().getBackButton().addActionListener(customizationPanelControl);
        JRadioButton[] buttonList = view.getCardPanel().getCustomizationPanel().getSkinRadioButtons();
        for (JRadioButton button : buttonList){
            button.addActionListener(customizationPanelControl);
        }

        // Timer making the snake move automatically
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                runGame();
            }
        };
        gameTimer = new Timer(this.speedMedium, taskPerformer);
    }

    public void runGame() {
        model.move();

        view.update();

        if (model.isNewAppleEaten()){
            view.playAppleSound();
        }

        if (model.isGameWon()){
            pauseGame();
            view.showWinnerDialog(true);
        }

        if (model.getGameOver()) {
            pauseGame();
            view.showGameOverDialog(true);
            
        }

    }

    public void pauseGame(){
        gameTimer.stop();
    }

    public void startGame(){
        model.setIsGameStarted(true);
        gameTimer.restart();
    }

    public void setTimer(int interval){
        gameTimer.setDelay(interval);
    }

    public int getSpeedSlow() {
        return speedSlow;
    }

    public int getSpeedMedium() {
        return speedMedium;
    }

    public int getSpeedFast() {
        return speedFast;
    }

}
