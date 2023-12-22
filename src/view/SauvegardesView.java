package view;

import javax.swing.*;

import controller.Controller;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.Sauvegarde;
import modele.Tamagotchi;

@SuppressWarnings("serial")
public class SauvegardesView extends JPanel {
    private Sauvegarde sauvegarde;
    
    private Controller controller ;
    
    private JButton retour ;

    public SauvegardesView(View frame) {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        retour = new JButton("Retour");
        retour.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getMenu()));
        this.add(retour);
    }
    
    public void showSavedGames() {
        // Effacer les boutons précédents (si nécessaire)
        this.removeAll();

        // Ajouter à nouveau le bouton de retour
        this.add(retour);

        List<Tamagotchi> savedGames = controller.getTamagoSauvegardes();
        if (savedGames == null || savedGames.isEmpty()) {
            this.add(new JLabel("Aucun Tamagotchi sauvegardé pour l'instant."));
        } else {
            for (Tamagotchi tamagotchi : savedGames) {
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

        // Rafraîchir l'affichage du panel
        this.revalidate();
        this.repaint();
    }
    
    public void setSauvegarde(Sauvegarde sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
    
    public void setController(Controller controller) {
		this.controller = controller;
	}
}
