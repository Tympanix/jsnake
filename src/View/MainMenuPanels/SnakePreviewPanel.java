package View.MainMenuPanels;

import Model.Direction;
import Model.Field;
import Model.GameModel;
import View.GameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Class painting a preview of the Snake in the customization panel.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class SnakePreviewPanel extends JPanel {


	private static final long serialVersionUID = 5514399128403927099L;
	
	private GameFrame view;
    private int previewSize;

    //Body parts for preview
    private Field head;
    private Field body;
    private Field tail;

    public SnakePreviewPanel(GameModel model, GameFrame view){

        this.view = view;
        this.previewSize = 60;

        // Create the three snake parts for rendering
        head = new Field(0, 0, Direction.LEFT);
        body = new Field(1, 0, Direction.LEFT);
        tail = new Field(2, 0, Direction.LEFT);

        this.setPreferredSize(new Dimension(this.previewSize * 3, this.previewSize));
        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw each snake part in the panel
        view.drawHead(g2d, head, previewSize);
        view.drawBody(g2d, body, previewSize, head.getDir());
        view.drawTail(g2d, tail, previewSize, body.getDir());

    }

}
