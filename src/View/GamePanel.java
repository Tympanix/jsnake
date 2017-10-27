package View;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import Model.Direction;
import Model.Field;
import Model.GameModel;
import java.util.*;

/**
 * This class displays the game in the window.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GamePanel extends JPanel {
	private static final long serialVersionUID = -2716147439987230406L;

    private String path;

	private int CELL;
	
	private Map<String,BufferedImage> images = new HashMap<String,BufferedImage>();
	
	private GameModel model;
    private GameFrame view;
	
	public GamePanel(GameModel model, GameFrame view) {
        this.view = view;
        this.model = model;
        
        this.path = "Images/Snake/";
        loadSnake("Red"); //Load initial snake skin

        // Apple
        images.put("apple", view.loadImage("Images/Terrain/Apple.png"));
        //appleImage = view.loadImage("Images/Terrain/Apple.png");
        
        // Apple
        images.put("grass", view.loadImage("Images/Terrain/Grass.png"));
        //grassImage = view.loadImage("Images/Terrain/Grass.png");

        setPanelSize();
        this.setFocusable(true);
		this.setBackground(Color.GRAY);
		
	}

    public void loadSnake(String folder){

        // Snake head part

    	images.put("snakeHeadUp", view.loadImage(this.path + folder + "/Head.png"));
    	images.put("snakeHeadDown",view.rotateImg(images.get("snakeHeadUp"), 180));
    	images.put("snakeHeadLeft",view.rotateImg(images.get("snakeHeadUp"), -90));
    	images.put("snakeHeadRight",view.rotateImg(images.get("snakeHeadUp"), 90));


        // Sake body part
    	images.put("snakeBodyUp", view.loadImage(this.path + folder + "/Body.png"));
        images.put("snakeBodyDown",view.rotateImg(images.get("snakeBodyUp"), 180));
        images.put("snakeBodyLeft",view.rotateImg(images.get("snakeBodyUp"), -90));
        images.put("snakeBodyRight",view.rotateImg(images.get("snakeBodyUp"), 90));

        // Snake tail part
        images.put("snakeTailUp", view.loadImage(this.path + folder + "/Tail.png"));
        images.put("snakeTailDown", view.rotateImg(images.get("snakeTailUp"), 180));
        images.put("snakeTailLeft", view.rotateImg(images.get("snakeTailUp"), -90));
        images.put("snakeTailRight", view.rotateImg(images.get("snakeTailUp"), 90));

        // Snake corner parts
        images.put("snakeCornerLeftUp", view.loadImage(this.path + folder + "/Turn.png"));
        images.put("snakeCornerUpRight", view.rotateImg(images.get("snakeCornerLeftUp"), 90));
        images.put("snakeCornerRightDown", view.rotateImg(images.get("snakeCornerLeftUp"), 180));
        images.put("snakeCornerDownLeft", view.rotateImg(images.get("snakeCornerLeftUp"), -90));

        
        images.put("snakeCornerRightUp",view.horizontalFlip(images.get("snakeCornerLeftUp")));
        images.put("snakeCornerDownRight", view.rotateImg(images.get("snakeCornerRightUp"), 90));
        images.put("snakeCornerLeftDown", view.rotateImg(images.get("snakeCornerRightUp"), 180));
        images.put("snakeCornerUpLeft", view.rotateImg(images.get("snakeCornerRightUp"), -90));
    }

    // Set size of panel
    public void setPanelSize(){
        int windowWidth = view.getContentPane().getWidth();
        int windowHeight = view.getContentPane().getHeight();
        this.CELL = Math.min(windowWidth / model.getWidth(), windowHeight / model.getHeight());
        this.setPreferredSize(new Dimension(CELL * model.getWidth(), CELL * model.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set size of panel
        setPanelSize();
        
        // Draw grass
        
        for (int x = 0; x < model.getTrack().getArraySizeWidth(); x++){
        	for (int y = 0; y < model.getTrack().getArraySizeHeight(); y++){
        		g2d.drawImage(images.get("grass"), x * CELL, y * CELL, CELL, CELL, null);
        	}
        	
        }

        // Draw apple
        g2d.drawImage(images.get("apple"), model.getApple().getX() * CELL, model.getApple().getY() * CELL, CELL, CELL, null);

        for (int i = 0; i < model.getSnake().getSize(); i++){

            // Get the current snake which has to be drawn
            Field snakePart = model.getSnake().getList().get(i);

            // Get next direction
            Direction nextDir = model.getSnake().getDirAtId(i + 1);

            // Tail
            if (i == 0){
                drawTail(g2d, snakePart, CELL, nextDir);
                continue;
            }

            // Body
            if (i < model.getSnake().getSize() - 1){
                drawBody(g2d, snakePart, CELL, nextDir);
                continue;
            }

            //Head
            if (i >= model.getSnake().getSize() - 1){
                drawHead(g2d, snakePart, CELL);
                continue;
            }
        }

    }

    public void drawHead(Graphics2D g2d, Field f, int CELL) {
        BufferedImage img = null;
        switch (f.getDir()) {

            case LEFT: // left arrow
                img = images.get("snakeHeadLeft");
                break;
            case UP: // up arrow
                img = images.get("snakeHeadUp");
                break;
            case RIGHT: // right arrow
                img = images.get("snakeHeadRight");
                break;
            case DOWN: // down arrow
                img = images.get("snakeHeadDown");
                break;
        }

        g2d.drawImage(img, f.getX() * CELL, f.getY() * CELL, CELL, CELL, null);
    }

    public void drawTail(Graphics2D g2d, Field f, int CELL, Direction nextDir) {
        BufferedImage img = null;
        switch (nextDir) {

            case LEFT: // left arrow
                img = images.get("snakeTailLeft");
                break;
            case UP: // up arrow
                img = images.get("snakeTailUp");
                break;
            case RIGHT: // right arrow
                img = images.get("snakeTailRight");
                break;
            case DOWN: // down arrow
                img = images.get("snakeTailDown");
                break;
        }

        g2d.drawImage(img, f.getX() * CELL, f.getY() * CELL, CELL, CELL, null);
    }

    public void drawBody(Graphics2D g2d, Field f, int CELL, Direction nextDir) {
        if (nextDir == null){ nextDir = f.getDir(); }

        if (f.getDir() == nextDir){
            // Draw a straight body part
            drawStraight(g2d, f, CELL);

        } else {
            // Draw a corner body part
            drawCorner(g2d, f, CELL, nextDir);

        }

    }

    public void drawStraight(Graphics2D g2d, Field f, int CELL){
        BufferedImage img = null;
        switch (f.getDir()) {

            case LEFT: // left arrow
                img = images.get("snakeBodyLeft");
                break;
            case UP: // up arrow
                img = images.get("snakeBodyUp");
                break;
            case RIGHT: // right arrow
                img = images.get("snakeBodyRight");
                break;
            case DOWN: // down arrow
                img = images.get("snakeBodyDown");
                break;
        }

        g2d.drawImage(img, f.getX() * CELL, f.getY() * CELL, CELL, CELL, null);
    }

    public void drawCorner(Graphics2D g2d, Field f, int CELL, Direction to) {
        BufferedImage img = null;

        switch (f.getDir()) {
            case LEFT:
                img = (to == Direction.UP) ? images.get("snakeCornerLeftUp") : images.get("snakeCornerLeftDown");
                break;
            case UP:
                img = (to == Direction.RIGHT) ? images.get("snakeCornerUpRight") : images.get("snakeCornerUpLeft");
                break;
            case RIGHT:
                img = (to == Direction.UP) ? images.get("snakeCornerRightUp") : images.get("snakeCornerRightDown");
                break;
            case DOWN:
                img = (to == Direction.RIGHT) ? images.get("snakeCornerDownRight") : images.get("snakeCornerDownLeft");
                break;
        }

        g2d.drawImage(img, f.getX() * CELL, f.getY() * CELL, CELL, CELL, null);
    }

    public void update(){
        this.repaint();
    }

}
