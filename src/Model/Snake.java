package Model;

import java.util.LinkedList;

/**
 * Class represents the Snake in the game.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class Snake {

    private GameModel model;
    private LinkedList<Field> body;
    private int applesEaten;
    private MoveQueue dir;
    private int dWidth = 0;
    private int dHeight = 0;
    
    public Snake(GameModel model){
        body = new LinkedList<Field>();
        this.dir = new MoveQueue();
        this.model = model;
        newSnake();
    }

    // Creates a new snake at center of track facing down with length 2.
    public void newSnake(){
        body.clear();
        this.applesEaten = 0;
        dir.setInitialDir(Direction.DOWN);
        body.add(new Field(model.getWidth()/2, model.getHeight()/2, Direction.DOWN)); //Add tail of snake
        body.add(new Field(model.getWidth()/2, model.getHeight()/2+1, Direction.DOWN)); // Add head of snake
        model.getTrack().put(this.getTail(), Mark.TAIL);
        model.getTrack().put(this.getHead(), Mark.HEAD);
    }

    // Puts a new direction in queue (will execute on game tick)
    public void setDir(Direction dir){
        this.dir.setNextDir(dir);
    }

    // Returns the direction from the given snake part
    public Direction getDirAtId(int id){
        if (id < body.size()){
            return body.get(id).getDir();
        } else {
            return dir.getDir();
        }
    }

    // Sneak peaks the current direction (does not touch the queue)
    public Direction getDir(){
    	return this.dir.getDir();
    }

    // Move the snake one step ahead. Should be executed each game tick
    public void move(){
    	Direction curDir;

        // Determines if AI is on or off
        if (model.getIsAIOn()) {
            curDir = model.getAIDirection();
            dir.setDirection(curDir);
        } else {
            curDir = this.dir.useDir();
        }

        // Reset delta values for movement
        dHeight = 0;
        dWidth = 0;

        // Set delta values for movement
        if (curDir == Direction.UP){
            dHeight = -1;
        } else if (curDir == Direction.DOWN){
            dHeight = 1;
        } else if (curDir == Direction.LEFT){
            dWidth = -1;
        } else if (curDir == Direction.RIGHT){
            dWidth = 1;
        }

        // Retrieves the last position of the snake
        int lastX = body.getLast().getX();
        int lastY = body.getLast().getY();

        // Calculates the new position of the snake from delta values
        int newX = lastX + dWidth;
        int newY = lastY + dHeight;

        // Recalculation of coordinates enabling the snake to travel through edge of track
        if (newX > (model.getWidth() - 1)){ newX -= model.getWidth(); }
        if (newX < 0) { newX += model.getWidth(); }

        if (newY > (model.getHeight() - 1)){ newY -= model.getHeight(); }
        if (newY < 0) { newY += model.getHeight(); }

        // Creates a new Field with coordinates and current direction
        Field nextField = new Field(newX, newY, curDir);

        //If statement so the snake is able to chase its own tail and can't move through its own body.
        if (model.getTrack().isSolid(newX, newY) && !nextField.equals(getTail())){
            model.setGameOver(true);
            return;
        }

        // Method passed all return statements, move is eligible from this point

        // Update first part of the collision map array (before the snake moves)
        model.getTrack().put(getHead(), Mark.BODY);

        // Add current step to the snake
        body.add(nextField);

        // Update last part of collision map array (after the snake moves)
        model.getTrack().put(getHead(), Mark.HEAD);

        // Create a new apple and do not remove the tail if snake eats an apple
        if (nextField.equals(model.getApple())){
            model.newApple();
            model.setNewAppleEaten(true);
            applesEaten++;
        } else {
            model.setNewAppleEaten(false);
            // Remove old tail from collision map
            model.getTrack().put(getTail(), Mark.EMPTY);
            body.removeFirst();
            // Add new tail to collision map
            model.getTrack().put(getTail(), Mark.TAIL);
        }


    }

    // Returns the LinkedList containing all the body pats of the snake
    public LinkedList<Field> getList(){
        return body;
    }

    //Method that prints the coordinates of the snake for debugging.
    public void print(){
        System.out.println("-----------------");
        for (Field f : body){
            System.out.println("X: " + f.getX() + "; Y: " + f.getY());
            System.out.println("Score = " + applesEaten);
        }
    }

    public int getSize(){
    	return body.size();
    }

    public int getScore(){
    	return applesEaten;
    }
          
    public Field getTail(){
    	return body.getFirst();
    }
    
    public Field getHead(){
    	return body.getLast();
    }
    
}
