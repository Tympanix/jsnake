package Model;

import Model.AIStrategy.*;
import Model.AIStrategy.AIStrategy;

/**
 * Class defining the AI's strategy to use.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class AI {
    private AIStrategy strategy;

    public AI(GameModel model) {
        this.strategy = new AIAdvancedAppleStrategy(model);
    }


    public Direction getDirection() {
        return strategy.strategy();
    }
}
