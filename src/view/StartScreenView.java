package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartScreenView extends JPanel {
	
	private JButton playButton ;
	private JButton rulesButton ;
	
	public StartScreenView(View frame) {
		
		playButton = new JButton("PLAY");		//bouton pour jouer
		rulesButton = new JButton("RULES");		//bouton pour afficher les regles
		
		
		this.add(playButton);
		this.add(rulesButton);
		
		//Action declenchee lorsque l'on appuie sur le bouton play
		playButton.addActionListener(e -> frame.getLayout().show(frame.getPanel() ,frame.getMenu()));
		
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
		
		//Changer la taille des boutons
		playButton.setPreferredSize(new Dimension(200,100));
		
		//Changer la couleur des boutons 
		playButton.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
		playButton.setBackground(new Color(153, 72, 143)); // Couleur dégradée
		playButton.setForeground(Color.BLUE); // Couleur du texte

		rulesButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		rulesButton.setBackground(new Color(144, 238, 144));
		rulesButton.setForeground(Color.GRAY);
	}
	
}
