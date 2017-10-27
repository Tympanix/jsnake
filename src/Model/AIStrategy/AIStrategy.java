package Model.AIStrategy;

import Model.Direction;
import Model.GameModel;

/**
 * Super class for different AI strategies.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public abstract class AIStrategy {
	protected GameModel model;
	public AIStrategy(GameModel model){
		this.model = model;
	}
	public abstract Direction strategy();
		
}
