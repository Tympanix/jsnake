package Model;

/**
 * Class that represents the track in the game.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class Track {

    private Mark[][] track;

    public Track(int width,int height){
		track = new Mark[width][height];
	}

    // Returns the Mark at a given coordinate
    public Mark getMark(int x, int y){

        // Recalculating coordinates outside track
        // as if the track was continuous
        if (x >= (track.length)) {
            x = x % track.length;
        } else if (x < 0) {
            x = (track.length - 1) + x % track.length;
        }

        if (y >= track[0].length) {
            y = y % track[0].length;
        } else if (y < 0) {
            y = (track[0].length - 1) + y % track[0].length;
        }
        //System.out.println("y = " + y);
        return track[x][y];
    }

    // Returns whether or not a Field will create a collision
    public boolean isSolid(int x, int y){
    	if (track[x][y] == Mark.HEAD || track[x][y] == Mark.TAIL || track[x][y] == Mark.BODY){
    		return true;
    	} else return false;
     }

    public int getArraySizeWidth(){ return track.length; } //Change to width?????

    public int getArraySizeHeight(){ return track[0].length; } //change to height

    public void put(int x, int y, Mark m){
        track[x][y] = m;
    }

    public void put(Field f, Mark m) { track[f.getX()][f.getY()] = m; }

    // Fills the array with Mark.EMPTY
    public void clear(){
        for (int x = 0; x < getArraySizeWidth(); x++){
            for (int y = 0; y < getArraySizeHeight(); y++){
                track[x][y] = Mark.EMPTY;
            }
        }
    }
    
    public void adjustTrackSize(int width, int height){
    	this.track = new Mark[width][height];
    }
    public void printTrack(){
    	System.out.println("track: n = " + getArraySizeWidth() + ", m = " + getArraySizeHeight());
    }
}