package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.Sauvegarde;
import modele.Tamagotchi;

public class SauvegardesView extends JPanel {
    private Sauvegarde sauvegarde;

    public SauvegardesView(View frame) {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

       
        for (Tamagotchi tamagotchi : frame.getController().getTamagoSauvegardes()) {
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
    public void setSauvegarde(Sauvegarde sauveGarde) {
		this.sauvegarde = sauveGarde;
	}
}
