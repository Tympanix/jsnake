package View;

import Model.GameModel;
import View.MainMenuPanels.CustomizationPanel;
import View.MainMenuPanels.HighScoresPanel;
import View.MainMenuPanels.MainPanel;
import View.MainMenuPanels.SettingsPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Class that manages which panel to show.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class CardPanel extends JPanel {
	private static final long serialVersionUID = 1341016562815129785L;

	private GameModel model;

    private CardLayout layout;
    
    private GamePanel game;
    private MainPanel main;
    private SettingsPanel settings;
    private CustomizationPanel customizationPanel;
    private HighScoresPanel highScoresPanel;

    public CardPanel(GameModel model, GameFrame view){
        super();
        this.model = model;

        this.layout = new CardLayout();
        this.setLayout(this.layout);

        JPanel gameWrapper = new JPanel();
        gameWrapper.setLayout(new GridBagLayout());
        this.game = new GamePanel(this.model, view);
        gameWrapper.add(game, new GridBagConstraints());
        this.add(gameWrapper, "1");

        this.main = new MainPanel(model, view);
        this.add(main, "2");

        this.settings = new SettingsPanel(model, view);
        this.add(settings, "3");

        this.customizationPanel = new CustomizationPanel(model, view);
        this.add(customizationPanel, "4");

        this.highScoresPanel = new HighScoresPanel(model, view);
        this.add(highScoresPanel, "5");

        showMainCard();
    }

    public void showGameCard(){
        game.setPanelSize();
        layout.show(this, "1");
        game.requestFocusInWindow();
    }

    public void showSettingsCard(){ layout.show(this, "3"); }

    public void showMainCard(){
        main.update();
        layout.show(this, "2");
    }

    public void showCustomizationPanel(){ layout.show(this, "4"); }

    public void showHighScoresPanel() { layout.show(this, "5"); }

    public GamePanel getGamePanel(){
        return game;
    }

    public MainPanel getMainPanel(){
        return main;
    }

    public SettingsPanel getSettingsPanel(){
        return settings;
    }

    public CustomizationPanel getCustomizationPanel() { return customizationPanel; }

    public HighScoresPanel getHighScoresPanel() { return highScoresPanel; }
}
