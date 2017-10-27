package Model;

/**
 * Class to represent coordinates.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class Field {

	private int posX;
	private int posY;
    private Direction dir;

    // Constructor for a Field with coordinates and a direction
    public Field(int posX, int posY, Direction dir){
        this.posX = posX;
        this.posY = posY;
        this.dir = dir;
    }

    // Constructor for objects without a direction (i.e. the apple)
    public Field(int posX,int posY){
        this(posX, posY, null);
    }

    // Constructor for no given coordinates will be (0, 0)
    public Field(){
        this(0, 0);
    }

    // Update a Field with new coordinates and direction
    public void set(int x, int y, Direction dir){
        this.posX = x;
        this.posY = y;
        this.dir = dir;
    }

    // Update only the coordinates of a field
    public void set(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public Direction getDir(){ return this.dir; }
	
	public int getX(){
		return posX;
	}
	public int getY(){
		return posY;
	}


    // Equals method for checking Fields with equal coordinates
    public boolean equals(Field other){
        return this.posX == other.posX && this.posY == other.posY;
    }

    // Print method for debugging
    public void print(){
    	System.out.println("Apple: posX = " + this.posX + " posY = " + this.posY);
    }
}
