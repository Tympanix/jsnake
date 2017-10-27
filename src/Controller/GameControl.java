package Controller;

import Controller.Templates.Control;
import Model.Direction;
import Model.GameModel;
import View.GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener for snake-movement.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GameControl extends Control implements KeyListener {

	public GameControl(GameModel model, GameFrame view, Controller controller) {
		super(model, view, controller);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: // left arrow
                model.getSnake().setDir(Direction.LEFT);
                break;
            case KeyEvent.VK_UP: // up arrow
                model.getSnake().setDir(Direction.UP);
                break;
            case KeyEvent.VK_RIGHT: // right arrow
                model.getSnake().setDir(Direction.RIGHT);
                break;
            case KeyEvent.VK_DOWN: // down arrow
                model.getSnake().setDir(Direction.DOWN);
                break;
            case KeyEvent.VK_ESCAPE: // Escape key
                controller.pauseGame();
                view.getCardPanel().showMainCard();

        }
        

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
