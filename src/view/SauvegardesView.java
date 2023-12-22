package view;

import javax.swing.*;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.Sauvegarde;
import modele.Tamagotchi;

@SuppressWarnings("serial")
public class SauvegardesView extends JPanel {
    private Sauvegarde sauvegarde;
    
    private Controller controller ;

    public SauvegardesView(View frame) {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
    }
    
    public void showSavedGames() {
    	for (Tamagotchi tamagotchi : controller.getTamagoSauvegardes()) {
            String buttonText = tamagotchi.getNom() + ":" + tamagotchi.getEspece();
            JButton button = new JButton(buttonText);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: Action à effectuer lorsqu'un bouton est cliqué
                    
                }
            });
            add(button);
        }
    }
    
    public void setSauvegarde(Sauvegarde sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
    
    public void setController(Controller controller) {
		this.controller = controller;
	}
}
