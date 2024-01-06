package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class StartScreenView extends JPanel {
	
	private GradientButton playButton ;
	private GradientButton rulesButton ;
	private Image backgroundImage;
	
	public StartScreenView(View frame) {
		try {
            backgroundImage = ImageIO.read(getClass().getResource("/media/maison.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur de chargement de l'image de fond : " + e.getMessage());
        }
		setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour le positionnement
        GridBagConstraints gbc = new GridBagConstraints();

        playButton = new GradientButton("JOUER");
        rulesButton = new GradientButton("RÈGLES");

        // Configurer les boutons pour avoir la même taille
        Dimension buttonSize = new Dimension(200, 50);
        playButton.setPreferredSize(buttonSize);
        rulesButton.setPreferredSize(buttonSize);
        
        //-----------------------------------------------------------------------------------------------
        // Configuration des contraintes pour les boutons
        gbc.gridx = 0; // Position X dans la grille
      
        gbc.insets = new Insets(5, 0, 5, 0); // Réduire l'espacement entre les boutons si nécessaire

        // Réglage du poids pour centrer les boutons dans l'espace vertical
        gbc.weightx = 1;
        gbc.weighty = 0.5; // Réduire ce poids rapproche les boutons verticalement

        // Ajouter le bouton "JOUER" avec les contraintes
        gbc.gridy = 0; // Position Y dans la grille pour "JOUER"
        gbc.anchor = GridBagConstraints.SOUTH; // Aligner au bas de l'espace
        add(playButton, gbc);

        // Ajouter le bouton "RÈGLES" avec les contraintes
        gbc.gridy = 1; // Position Y dans la grille pour "RÈGLES"
        gbc.anchor = GridBagConstraints.NORTH; // Aligner au haut de l'espace
        add(rulesButton, gbc);
		
        //----------------------------------------------------------------------------------------------
		//Action declenchee lorsque l'on appuie sur le bouton play
		playButton.addActionListener(e->frame.showMenu());
		
		//Action declenchee lorsque l'on appuie sur le bouton des regles
		rulesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ouverture d'une fenetre avec affichage des regles du jeu
				String regles = "Voici les règles du jeu :\n"
						+ "Le but du jeu est d'assurer la survie du Tamagotchi\n"
						+ "Il est aussi possibe de le nourrir et de faire toute sorte d'activités avec lui.";
						;				//le message qui sera affiché quand on clique sur le bouton des regles
				
				JOptionPane.showMessageDialog(StartScreenView.this, regles);
			}
		});
		
		
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
	
}
