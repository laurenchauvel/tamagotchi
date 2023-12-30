package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
		
		playButton = new GradientButton("PLAY");		//bouton pour jouer
		rulesButton = new GradientButton("RULES");		//bouton pour afficher les regles
		
		playButton.setForeground(Color.WHITE);
		rulesButton.setForeground(Color.WHITE);
		
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
		
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
	
}
