package Model.AIStrategy;

import Model.Direction;
import Model.GameModel;
import Model.Mark;

/**
 * Class that includes methods for an AI strategy.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class AIAdvancedAppleStrategy extends AIStrategy{

		private boolean possibleLeft;
		private boolean possibleRight;
		private boolean possibleUp;
		private boolean possibleDown;
		public AIAdvancedAppleStrategy(GameModel model){
			super(model);
		}
		
		public Direction strategy() {
			int appleX = model.getAppleX();
			int appleY = model.getAppleY();
			int headX = model.getSnakeHeadX();
			int headY = model.getSnakeHeadY();
			Direction dir = model.getSnakeDirection();
			possibleDirection(dir,headX,headY);
			if(!(headX == appleX)){
				if ((headX > appleX) && possibleLeft){
					return Direction.LEFT;
				}else if (possibleRight){				//headX < appleX implied
					return Direction.RIGHT;
				}
			}else{				// !(headY == appleY) implied
				if ((headY > appleY) && possibleUp){
					return Direction.UP;
				}else if (possibleDown){				
					return Direction.DOWN;
				}
			}
			return makeMove(headX,headY);
		}
		private void possibleDirection(Direction dir, int headX, int headY){
			//System.out.println("possibleDirectionRUN");
			if(!(dir == Direction.UP) && (model.getTrackMark(headX, headY + 1) == Mark.EMPTY || model.getTrackMark(headX, headY + 1) == Mark.APPLE)){
					possibleDown = true;
			}else{
				possibleDown = false;
			}
			if(!(dir == Direction.DOWN) && (model.getTrackMark(headX, headY - 1) == Mark.EMPTY || model.getTrackMark(headX, headY - 1) == Mark.APPLE)){
				possibleUp = true;
			}else{
				possibleUp = false;
			}
			if(!(dir == Direction.LEFT) && (model.getTrackMark(headX + 1, headY) == Mark.EMPTY || model.getTrackMark(headX + 1, headY) == Mark.APPLE)){
				possibleRight = true;
			}else{
				possibleRight = false;
			}
			if(!(dir == Direction.RIGHT) && (model.getTrackMark(headX - 1, headY) == Mark.EMPTY || model.getTrackMark(headX - 1, headY) == Mark.APPLE)){
				possibleLeft = true;
			}else{
				possibleLeft = false;
			}
	}
		private Direction makeMove(int headX,int headY){
			int left = checkLeft(headX,headY);
			int right = checkRight(headX,headY);
			int up = checkUp(headX,headY);
			int down = checkDown(headX,headY);
			if(left >= right && left >= up && left >= down){
				return Direction.LEFT;
			}else if(right >= left && right >= up && right >= down){
				return Direction.RIGHT;
			}else if(up >= right && up >= left && up >= down){
				return Direction.UP;
			}else if(down >= right && down >= up && down >= left){
				return Direction.DOWN;
			}else{
				System.out.println("You are not supposed to be here!");
				return Direction.LEFT;
			}

			
			
		}
		//Check methods calculate the distance to a Snake part in a given direction
		private int checkLeft(int headX,int headY){
			int i = 1;
			//System.out.println("Check left Called!");
			while(true){
				if(!(model.getTrackMark(headX - i, headY) == Mark.EMPTY || model.getTrackMark(headX - i, headY) == Mark.APPLE||model.getTrackMark(headX - i, headY) == Mark.TAIL)){
					//System.out.println("left = " + i);
					return i;
				}else{
					i++;
				}
			}
		}
		
		private int checkRight(int headX,int headY){
			int i = 1;
			while(true){
				if(!(model.getTrackMark(headX + i, headY) == Mark.EMPTY || model.getTrackMark(headX + i, headY) == Mark.APPLE||model.getTrackMark(headX + i, headY) == Mark.TAIL)){
					return i;
				}else{
					i++;
				}
			}
		}
		
		private int checkUp(int headX,int headY){
			int i = 1;
			while(true){
				if(!((model.getTrackMark(headX, headY - i) == Mark.EMPTY || model.getTrackMark(headX, headY - i) == Mark.APPLE||model.getTrackMark(headX, headY - i) == Mark.TAIL))){
					return i;
				}else{
					//System.out.println("up = " + i);
					//System.out.println("X = " + headX);
					//System.out.println("Y = " + (headY - i));
					//System.out.println(model.getTrackMark(headX, headY - i));
					i++;
				}
			}
		}
		
		private int checkDown(int headX,int headY){
			int i = 1;
			while(true){
				if(!(model.getTrackMark(headX, headY + i) == Mark.EMPTY || model.getTrackMark(headX, headY + i) == Mark.APPLE ||  model.getTrackMark(headX, headY + i) == Mark.TAIL)){
					return i;
				}else{
					i++;
				}
			}
		}
}
