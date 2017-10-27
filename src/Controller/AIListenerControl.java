package Controller;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import Controller.Templates.Control;
import Model.GameModel;
import View.GameFrame;

/**
 * This class listens to the Demo mode checkbox in the Settings-menu.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class AIListenerControl extends Control implements ItemListener{

    public AIListenerControl(GameModel model, GameFrame view, Controller controller) {
        super(model, view, controller);
    }
    public void itemStateChanged(ItemEvent e) {
        JCheckBox source = (JCheckBox) e.getSource();
            String name = source.getName();
            if(name.equals("AI")){
            	model.setAI();
            }
        }
    }

