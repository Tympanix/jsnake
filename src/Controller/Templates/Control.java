package Controller.Templates;

import Controller.Controller;
import Model.GameModel;
import View.GameFrame;

/**
 * Superclass for listeners.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public abstract class Control {

    protected GameFrame view;
    protected GameModel model;
    protected Controller controller;

    public Control(GameModel model, GameFrame view, Controller controller){
        this.model = model;
        this.view = view;
        this.controller = controller;
    }
}
