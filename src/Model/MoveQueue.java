package Model;

import java.util.LinkedList;

/**
 * Class that contains expanded methods and functionality for move method in GameModel.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class MoveQueue {

    private LinkedList<Direction> queue;
    private Direction currentDir;

    public MoveQueue(){
        queue = new LinkedList<Direction>();
    }

    // Takes a sneak peak at the current direction, without changing the queue
    public Direction getDir(){
        return currentDir;
    }

    // Returns the next direction in the queue if any
    public Direction useDir(){
        if (queue.size() > 0){
            // Polls queued direction (remove from queue)
            currentDir = queue.pollLast();
        }
        return currentDir;
    }

    // Sets a direction and clears the queue
    public void setInitialDir(Direction dir){
        queue.clear();
        currentDir = dir;
    }

    // Gets the most recent direction put in the queue
    public Direction getTop(){
        if (queue.peekFirst() != null){
            return queue.peekFirst();
        } else {
            return currentDir;
        }
    }

    // Put a new direction in the queue
    public void setNextDir(Direction dir){
        // Queue cannot be larger than 2 steps ahead
        if (queue.size() >= 2){
            queue.clear();
        }

        // Cannot queue two of the same directions
        if (dir == getTop()){
            return;
        }

        // Cannot queue opposite directions
        if (dir == getOppositeDir(getTop())){
            return;
        }

        // Add direction to queue
        queue.addFirst(dir);
    }

    // Returns the opposite direction
    public Direction getOppositeDir(Direction dir){
        switch (dir) {
            case UP: // up arrow
                return Direction.DOWN;
            case DOWN: // down arrow
                return Direction.UP;
            case RIGHT: // right arrow
                return Direction.LEFT;
            case LEFT: // left arrow
                return Direction.RIGHT;
            default:
                return dir;
        }
    }


    // To string method for showing current direction and the queue
    public String toString(){
        String s = "";

        Direction next;
        Direction nextnext;

        if (queue.size() > 0){ next = queue.getLast(); } else { next = null; }
        if (queue.size() > 1){ nextnext = queue.getFirst(); } else { nextnext = null; }

        s += "Current: " + currentDir + "\n";
        s += "1st in queue: " + next + "\n";
        s += "2nd in queue: " + nextnext + "\n";
        s += "Queue: " + queue.size() + "\n";
        s += "----------------------" + "\n";

        return s;
    }

    // Force set the current direction (not recommended)
    public void setDirection(Direction dir){
    	this.currentDir = dir;
    }

}
