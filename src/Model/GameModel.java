package Model;

/**
 * Class that collect all parts of the model into one, toplevel model.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GameModel {

    private int width, height;
    private Snake snake;
    private Track track;
    private Field apple;
    private boolean isGameOver;
    private boolean isAIOn;
    private boolean isGameStarted;
    private boolean newAppleEaten;
    private boolean isGameWon;
    private AI aI;
    private HighScore highScore;
    
    // Constructor for a game model
    public GameModel(){
    	isAIOn = false;
    	aI = new AI(this);
        this.isGameOver = false;
        this.width = 20;
        this.height = 20;
        this.track = new Track(this.width, this.height);
        this.apple = new Field();
        this.snake = new Snake(this);
        track.clear();
        newGame();
        this.highScore = new HighScore();
        this.highScore.readHighScoresList();
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
    	this.width = width;
    }

    public Field getApple(){
        return apple;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int m){
    	this.height = m;
    }

    public Snake getSnake(){
        return snake;
    }

    public Track getTrack(){
        return track;
    }

    public boolean getGameOver(){
        return this.isGameOver;
    }

    public void setGameOver(boolean gameOver){
        this.isGameOver = gameOver;
    }

    public void setIsGameStarted(boolean started){
        this.isGameStarted = started;
    }

    public boolean getIsGameStarted(){
        return isGameStarted;
    }

    public int[] getHighScore() { return this.highScore.getHighScores(); }

    public void setNewAppleEaten(boolean appleEaten){ this.newAppleEaten = appleEaten; }

    public boolean isNewAppleEaten(){ return newAppleEaten; }

    public boolean isGameWon(){ return this.isGameWon; }

    // Creates a new game with a new snake.
    public void newGame(){
        track.clear();
        snake.newSnake();
        isGameOver = false;
        isGameStarted = false;
        isGameWon = false;
        newAppleEaten = false;
        newApple();
    }

    // Moves the snake one step ahead and checks for highscore
    public void move() {
        this.snake.move();
        if ((this.isGameOver || this.isGameWon) && this.highScore.isHighScore(this.snake.getScore())) {
            this.highScore.placeHighScore(this.snake.getScore());
            this.highScore.writeHighScores();
        }
    }

    // Places a new apple in the game on an empty location
    public void newApple(){

    	// Calculates number of empty spaces on track
    	int emptySpaces = height*width-snake.getSize();

        // Return of there a not spaces left
    	if(emptySpaces == 0){
            this.isGameWon = true;
    		return;
    	}

        // Calculates a random position for the apple to appear
    	int applePlace = (int) ((Math.random() * emptySpaces) + 1);

        // Loop and counter placing the apple at the randomly generated
        // free location (jump over non-placeable locations)
        int currentNumber = 0;
    	for(int i = 0;i < height; i++){
    		for(int j = 0; j < width; j++){
    			if(track.getMark(j, i) == Mark.EMPTY){
    				currentNumber++;

    				if(currentNumber == applePlace){
    					apple.set(j, i);
                        track.put(apple, Mark.APPLE);
    					return ;
    				}
    			}
    		}
    	}
    }
    
      
    
    // This method is for updating the track, when a different size is chosen
    // in the settings menu.
    public void updateTrack(){
    	track.adjustTrackSize(this.width, this.height);
    }

    public boolean getIsAIOn(){
    	return isAIOn;
    }
    public Direction getAIDirection(){
    	return aI.getDirection();
    }
    public Direction getSnakeDirection(){
    	return snake.getDir();
    }
    public int getSnakeHeadX(){
    	return snake.getHead().getX();
    }
    public int getSnakeHeadY(){
    	return snake.getHead().getY();
    }
    public int getAppleX(){
    	return apple.getX();
    }
    public int getAppleY(){
    	return apple.getY();
    }
    public Mark getTrackMark(int x, int y){
    	return track.getMark(x, y);
    }

    // Enables or disables the AI
    public void setAI(){
    	if(this.isAIOn){
    		this.isAIOn = false;
    	}else if(!isAIOn){
    		this.isAIOn = true;
    	}

    }
}
