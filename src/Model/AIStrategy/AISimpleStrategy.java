package Model.AIStrategy;

import Model.Direction;
import Model.GameModel;

/**
 * Class that includes methods for an AI strategy.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class AISimpleStrategy extends AIStrategy {
	
	public AISimpleStrategy(GameModel model){
		super(model);
	}
	public Direction strategy(){
		Direction dir = this.model.getSnakeDirection();
		System.out.println("Simple Strategy");
		if (dir == Direction.UP){
			return Direction.RIGHT;
		}else if (dir == Direction.DOWN){
			return Direction.LEFT;
		}else if (dir == Direction.LEFT){
			System.out.println("LEFT");
			return Direction.UP;
		}else if (dir == Direction.RIGHT){
			return Direction.DOWN;
		}else{
			System.out.println("Return!");
			return dir;
		}
	}
}
