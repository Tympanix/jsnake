package View;

import Model.Direction;
import Model.Field;
import Model.GameModel;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * This class displays the overall game in a window.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GameFrame extends JFrame {

	private static final long serialVersionUID = -7923005360849849891L;


    private GameOverDialog gameOverDialog;
    private NewGameDialog newGameDialog;
    private WinnerDialog winnerDialog;

    private int noAppleSound;
    private GameSound[] appleSounds;


    private CardPanel cardPanel;
    	
    public GameFrame(GameModel model){
        super("Snake");
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(500, 500));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.cardPanel = new CardPanel(model, this);
        this.getContentPane().add(cardPanel, BorderLayout.CENTER);

        this.gameOverDialog = new GameOverDialog(this, model);
        this.newGameDialog = new NewGameDialog(this, model);
        this.winnerDialog = new WinnerDialog(this, model);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Create and load apple sounds
        this.noAppleSound = 0;
        this.appleSounds = new GameSound[4];
        this.appleSounds[0] = new GameSound("Sounds/eat_apple.wav");
        this.appleSounds[1] = new GameSound("Sounds/eat_apple_2.wav");
        this.appleSounds[2] = new GameSound("Sounds/eat_apple_3.wav");
        this.appleSounds[3] = new GameSound("Sounds/eat_apple_4.wav");

    }

    public void update(){
        cardPanel.getGamePanel().update();
    }

    public void showGameOverDialog(boolean show){
    	gameOverDialog.updateScore();
        gameOverDialog.setLocationRelativeTo(this);
        gameOverDialog.setVisible(show);
    }

    public void showNewGameDialog(boolean show){
        newGameDialog.setLocationRelativeTo(this);
        newGameDialog.setVisible(show);
    }

    public void showWinnerDialog(boolean show){
        winnerDialog.setLocationRelativeTo(this);
        winnerDialog.setVisible(show);
    }

    public GameOverDialog getGameOverDialog(){ return gameOverDialog; }

    public NewGameDialog getNewGameDialog(){ return newGameDialog; }

    public CardPanel getCardPanel(){ return cardPanel; }
    
    public void resetGamePanel(){
    	cardPanel.getGamePanel().setPanelSize();
    }

    public void drawHead(Graphics2D g2d, Field f, int CELL){ cardPanel.getGamePanel().drawHead(g2d, f, CELL); }

    public void drawBody(Graphics2D g2d, Field f, int CELL, Direction nextDir){ cardPanel.getGamePanel().drawBody(g2d, f, CELL, nextDir); }

    public void drawTail(Graphics2D g2d, Field f, int CELL, Direction nextDir){ cardPanel.getGamePanel().drawTail(g2d, f, CELL, nextDir); }

    public void updatePreview(){ this.cardPanel.getCustomizationPanel().updatePreview(); }
    
    public BufferedImage loadImage(String img){
    	BufferedImage buffImg;
    	 try {
 			buffImg = ImageIO.read(new File(img));
 			return buffImg;
 		} catch (IOException e) {
 			e.printStackTrace();
 			return null;
 		}
   }

    public BufferedImage rotateImg(BufferedImage img, double deg) {    
        int x = img.getWidth();    
        int y = img.getHeight();   
        
        BufferedImage rotImg = new BufferedImage(x, y, img.getType());
        Graphics2D g = rotImg.createGraphics();
        
        g.rotate(Math.toRadians(deg), x/2, y/2);
        g.drawImage(img, null, 0, 0);
        g.dispose(); // Release system resources
        return rotImg;   
    }

    public BufferedImage horizontalFlip(BufferedImage img) {
        int x = img.getWidth();
        int y = img.getHeight();

        BufferedImage hImg = new BufferedImage(x, y, img.getType());
        Graphics2D g = hImg.createGraphics();
        g.drawImage(img, 0, 0, x, y, x, 0, 0, y, null);
        g.dispose(); // Release system resources
        return hImg;
    }


    public void playAppleSound(){
        if (noAppleSound >= appleSounds.length) {
            noAppleSound = 0;
        }

        appleSounds[noAppleSound].play();
        noAppleSound++;



    }
}

