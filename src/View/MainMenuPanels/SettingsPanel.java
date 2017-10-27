package View.MainMenuPanels;

import Model.GameModel;
import View.GameFrame;
import View.Templates.MenuPanelLayout;

import javax.swing.*;

import java.awt.*;

/**
 * Class representing the Settings-panel.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class SettingsPanel extends MenuPanelLayout {
	private static final long serialVersionUID = -2615723141672258848L;

    private JRadioButton slowButton;
    private JRadioButton mediumButton;
    private JRadioButton fastButton;
    private JCheckBox aIButton;
    private JButton customizationButton;
    
    private JSlider width;
    private JSlider height;
    
    public SettingsPanel(GameModel model, GameFrame view){
        super(model, view, "Settings");
    }

    public void content(){
        // Wrapper for horizontal layout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper,BoxLayout.Y_AXIS));
        cWrapper.add(wrapper);

        // Label: choose width
        JLabel widthLabel = new JLabel("Choose width");
        widthLabel.setAlignmentX(CENTER_ALIGNMENT);
        wrapper.add(widthLabel);

        // JSlider width, sets ticks labels and borders for it, then adds it to wrapper.
        this.width = new JSlider(JSlider.HORIZONTAL, 5, 100, 20);
        width.setName("width");
        width.setMajorTickSpacing(10);
        width.setMinorTickSpacing(1);
        width.setPaintTicks(true);
        width.setPaintLabels(true);
        wrapper.add(this.width);

        // Add space to next element
        wrapper.add(Box.createRigidArea(new Dimension(0,20)));

        // Label: Choose height
        JLabel hightLabel = new JLabel("Choose height");
        hightLabel.setAlignmentX(CENTER_ALIGNMENT);
        wrapper.add(hightLabel);
        
        // JSlider height, sets ticks labels and borders for it, then adds it to wrapper.
        this.height = new JSlider(JSlider.HORIZONTAL, 5, 100, 20);
        height.setName("height");
        height.setMajorTickSpacing(10);
        height.setMinorTickSpacing(1);
        height.setPaintTicks(true);
        height.setPaintLabels(true);
        wrapper.add(this.height);

        // Space to next element
        wrapper.add(Box.createRigidArea(new Dimension(0,50)));
        
        // Label: Choose difficulty
        JLabel level = new JLabel("Choose difficulty");
        level.setAlignmentX(CENTER_ALIGNMENT);
        wrapper.add(level);

        // Space between label and radio buttons
        wrapper.add(Box.createRigidArea(new Dimension(0,5)));

        // Horizontal wrapper for radio buttons
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new BoxLayout(radioButtons,BoxLayout.LINE_AXIS));
        wrapper.add(radioButtons);

        // Create the radio buttons.
        ButtonGroup diffGroup = new ButtonGroup();
        slowButton = new JRadioButton("Slow");
        radioButtons.add(slowButton);
        diffGroup.add(slowButton);
        mediumButton = new JRadioButton("Medium");
        radioButtons.add(mediumButton);
        diffGroup.add(mediumButton);
        fastButton = new JRadioButton("Fast");
        radioButtons.add(fastButton);
        diffGroup.add(fastButton);

        // Set medium radio button
        mediumButton.setSelected(true);

        // Space to next element
        wrapper.add(Box.createRigidArea(new Dimension(0,20)));

        // Create wrapper for AI
        JPanel aI = new JPanel();
        aI.setLayout(new BoxLayout(aI,BoxLayout.LINE_AXIS));
        wrapper.add(aI);

        // Label: Demo mode
        JLabel aILabel = new JLabel("Demo mode");
        aI.add(aILabel);

        // Add space between label and checkbox
        aI.add(Box.createRigidArea(new Dimension(5,0)));

        // AI checkbox
        aIButton = new JCheckBox();
        aIButton.setName("AI");
        aI.add(aIButton);

        // Space to next element
        wrapper.add(Box.createRigidArea(new Dimension(0,20)));

        // Customization button
        customizationButton = new JButton("Customization");
        customizationButton.setAlignmentX(CENTER_ALIGNMENT);
        wrapper.add(customizationButton);

    }

    // Get button methods for controller
    public JRadioButton getSlowButton(){ return slowButton; }
    public JRadioButton getMediumButton(){ return mediumButton; }
    public JRadioButton getFastButton(){ return fastButton; }
    public JButton getCustomizationButton(){ return customizationButton; }
    public JSlider getHeightSlide(){
    	return height;
    }
    public JSlider getWidthSlide(){
    	return width;
    }
    public JCheckBox getAIControl(){
    	return aIButton;
    }

}
