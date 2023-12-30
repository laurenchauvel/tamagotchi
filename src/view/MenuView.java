package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MenuView extends JPanel {
	
	private GradientButton newGame ;
	private GradientButton oldGame ;
	private JButton retour ;
	private Image backgroundImage;
	/*
	 * Constructeur de la classe
	 */
	public MenuView (View frame) {
		try {
            backgroundImage = ImageIO.read(getClass().getResource("/media/maison.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur de chargement de l'image de fond : " + e.getMessage());
        }
		setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour le positionnement
        GridBagConstraints gbc = new GridBagConstraints();
        
		newGame = new GradientButton("Nouvelle partie");
		newGame.setForeground(Color.WHITE);
		oldGame = new GradientButton("Charger partie");
		oldGame.setForeground(Color.WHITE);
		retour = new JButton("Retour");
		retour.setForeground(Color.WHITE);
		retour.setBackground(new Color(216, 20, 20));
		JPanel retourPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		retourPanel.setOpaque(false);
		retourPanel.add(retour);
		
		// Configurez les contraintes pour retourPanel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 1;
		gbc.weighty = 0;  // Peu de poids vertical pour rester en haut
		add(retourPanel, gbc);
		
		// Configurer les boutons pour avoir la même taille
		Dimension buttonSize = new Dimension(300, 50);
		newGame.setPreferredSize(buttonSize);
		oldGame.setPreferredSize(buttonSize);
		
		//-----------------------------------------------------------------------------------------------
        // Configuration des contraintes pour les boutons
        gbc.gridx = 0; // Position X dans la grille
      
        gbc.insets = new Insets(5, 0, 5, 0); // Réduire l'espacement entre les boutons si nécessaire

        // Réglage du poids pour centrer les boutons dans l'espace vertical
        gbc.weightx = 1;
        gbc.weighty = 0.5; // Réduire ce poids rapproche les boutons verticalement

        
        gbc.gridy = 0; // Position Y dans la grille 
        gbc.anchor = GridBagConstraints.SOUTH; // Aligner au bas de l'espace
        add(newGame, gbc);

        
        gbc.gridy = 1; // Position Y dans la grille 
        gbc.anchor = GridBagConstraints.NORTH; // Aligner au haut de l'espace
        add(oldGame, gbc);
		
        //----------------------------------------------------------------------------------------------
		
		
		//Action declenchee lorsque le bouton newGame est cliqué
		newGame.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getCreate()));
		
		//Action declenchee lorsque le bouton newGame est cliqué
		oldGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.getLayout().show(frame.getPanel(), frame.getSauvegardeName());
				frame.getSauvegardesView().setController(frame.getController());
				frame.getSauvegardesView().showSavedGames();
			}
		
		});
		
		//Action declenchee lorsue le bouton retour est cliqué
		retour.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getStart()));
		

	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}


