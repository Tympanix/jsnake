package View.MainMenuPanels;

import Model.GameModel;
import View.GameFrame;
import View.Templates.MenuPanelLayout;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Class to show customization of the Snake's color.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class CustomizationPanel extends MenuPanelLayout {

	private static final long serialVersionUID = -4581905038303244556L;

    private ArrayList<String> skins;
    private JRadioButton[] skinRadioButtons;
    private SnakePreviewPanel snakePreviewPanel;

    public CustomizationPanel(GameModel model, GameFrame view){
        super(model, view, "Customization");

    }

    public void content() {

        // Load skins an initialize array for radio buttons
        this.skins = loadSkins("Images/Snake/");
        this.skinRadioButtons = new JRadioButton[skins.size()];

        // Create box for content
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        cWrapper.add(content);

        // Create wrapper for centering content
        JPanel cWrapper = new JPanel();
        cWrapper.setLayout(new GridBagLayout());
        content.add(cWrapper);

        // Create wrapper for snake preview
        JPanel previewWrapper = new JPanel();
        previewWrapper.setLayout(new GridBagLayout());
        content.add(previewWrapper);

        // Create GridLayout for radio button positions
        JPanel gridWrapper = new JPanel();
        int rows = (skins.size() + 3) / 3;
        gridWrapper.setLayout(new GridLayout(rows, 3, 10, 10));
        cWrapper.add(gridWrapper);

        // Create radio button group
        ButtonGroup skinGroup = new ButtonGroup();

        // Add each skin to the GUI
        int counter = 0;
        for (String s : skins) {

            //Create the radio buttons.
            JRadioButton thisSkin = new JRadioButton(s);
            gridWrapper.add(thisSkin);

            //Group the radio button.
            skinGroup.add(thisSkin);

            //Add radio button to array
            skinRadioButtons[counter] = thisSkin;

            //Increment
            counter++;
        }


        // Add a snake preview
        previewWrapper.add(Box.createRigidArea(new Dimension(0,150)));
        snakePreviewPanel = new SnakePreviewPanel(model, view);
        previewWrapper.add(snakePreviewPanel);


    }

    public ArrayList<String> loadSkins(String directoryName) {

        // Create array list
        ArrayList<String> skins = new ArrayList<String>();

        // List files
        File directory = new File(directoryName);

        // Go through all files
        File[] fList = directory.listFiles();

        for (File file : fList) {
            if (file.isDirectory() && !file.isHidden()) {
                //System.out.println("ADDED SKIN: " + file.getName());
                skins.add(file.getName());
            }
        }

        return skins;
    }

    public JRadioButton[] getSkinRadioButtons(){
        return skinRadioButtons;
    }

    public void updatePreview(){ snakePreviewPanel.repaint(); }
}
