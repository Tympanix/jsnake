import Controller.Controller;
import Model.GameModel;
import View.GameFrame;

/**
 * Class collects the Model, View and Controller.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class Game {

    GameModel model;
    GameFrame view;
    Controller control;

    public Game(){

        this.model = new GameModel();
        this.view = new GameFrame(model);
        this.control = new Controller(model, view);

    }

}
