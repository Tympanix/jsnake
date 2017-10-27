package Model.AIStrategy;

import Model.Direction;
import Model.GameModel;

/**
 * Class that includes methods for an AI strategy.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class AISimpleWinStrategy extends AIStrategy{
	public AISimpleWinStrategy(GameModel model){
		super(model);
	}

	public Direction strategy() {
		Direction dir = this.model.getSnakeDirection();
		int y = model.getSnakeHeadY();
		int height = model.getHeight();
		if(dir == Direction.UP && y == 0 ){
			return Direction.RIGHT;
		}else if(dir == Direction.DOWN && y == height-1){
			return Direction.RIGHT;
		}else if(dir == Direction.RIGHT && y == 0){
			return Direction.DOWN;
		}else if(dir == Direction.RIGHT && y == height-1){
			return Direction.UP;
		}else{
			return dir;
		}
	}
}
