package Model.AIStrategy;

import Model.Direction;
import Model.GameModel;

/**
 * Class that includes methods for an AI strategy.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class AIGoForAppleStrategy extends AIStrategy{

	public AIGoForAppleStrategy(GameModel model){
		super(model);
	}
	
	public Direction strategy() {
		int appleX = model.getAppleX();
		int appleY = model.getAppleY();
		int headX = model.getSnakeHeadX();
		int headY = model.getSnakeHeadY();
		Direction dir = model.getSnakeDirection();
		
		if(!(headX == appleX)){
			if ((headX > appleX) && !(dir == Direction.RIGHT)){
				return Direction.LEFT;
			}else if (!(dir == Direction.LEFT)){				//headX < appleX implied
				return Direction.RIGHT;
			}else{
				return Direction.UP;	
			}
		}else{				// !(headY == appleY) implied
			if ((headY > appleY) && !(dir == Direction.DOWN)){
				return Direction.UP;
			}else if (!(dir == Direction.UP)){				
				return Direction.DOWN;
			}else{
				return Direction.LEFT;	
			}
		}
	}

}
