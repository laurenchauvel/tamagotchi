package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MenuView extends JFrame {
	
	private JPanel panel ;
	private CardLayout layout ;
	
	/*
	 * Constructeur de la classe
	 */
	public MenuView () {
		super();
		layout = new CardLayout();
		panel = new JPanel(layout);
		
		//Reglage des parametres de la fenetre
		this.setTitle("Dark Tamagotchi");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800,700);
		this.setLocationRelativeTo(null); 	//mets la fenetre au milieu de l'ecran
	
		
		this.InitStartScreen();
		
		 setContentPane(panel);
		 panel.add(InitStartScreen(), "StartScreen");
		 panel.add(InitMenu(),"Menu");
		 panel.add(CreateTamagotchi(),"CreateTamagotchi");
	     layout.show(panel, "StartScreen"); // Montre l'écran de démarrage en premier
			
	}
	
	//---------------------------------------------------------------
	
	/*
	 * Initialisation de l'ecran de demarrage
	 */
	public JPanel InitStartScreen() {
		JPanel startScreen = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		
		JButton playButton = new JButton("PLAY");		//bouton pour jouer
		playButton.setPreferredSize(new Dimension(200,100));;
		
		JButton rulesButton = new JButton("RULES");		//bouton pour afficher les regles
		buttonPanel.add(playButton);
		buttonPanel.add(rulesButton);
		
		buttonPanel.setLayout(new GridLayout(2,1));
		buttonPanel.setPreferredSize(new Dimension(400,200));
		String regles = "Voici les règles du jeu :\n"
				+ "Le but du jeu est d'assurer la survie du Tamagotchi\n"
				+ "Il est aussi possibe de le nourrir et de faire toute sorte d'activités avec lui.";
				;				//le message qui sera affiché quand on clique sur le bouton des regles
		
		
	
		// Alignement au centre verticalement
        startScreen.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		//Action declenchee lorsque l'on appuie sur le bouton play
		playButton.addActionListener(e -> layout.show(panel, "Menu"));
		
		//Action declenchee lorsque l'on appuie sur le bouton des regles
		rulesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ouverture d'une fenetre avec affichage des regles du jeu
				JOptionPane.showMessageDialog(MenuView.this, regles);
			}
		});
		
		playButton.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
		playButton.setBackground(new Color(153, 72, 143)); // Couleur dégradée
		playButton.setForeground(Color.BLUE); // Couleur du texte

		rulesButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		rulesButton.setBackground(new Color(144, 238, 144));
		rulesButton.setForeground(Color.GRAY);
		
		startScreen.add(buttonPanel);
		
		return startScreen;
	}
	
	
	//---------------------------------------------------------------
	/*
	 * Menu de choix de partie
	 */
	public JPanel InitMenu() {
		JPanel menu = new JPanel();
		
		JButton newGame = new JButton("Nouvelle partie");
		JButton oldGame = new JButton("Mes parties sauvegardées");
		JButton retour = new JButton("Retour");
		
		menu.add(newGame);
		menu.add(oldGame);
		menu.add(retour);
		
		newGame.addActionListener(e -> layout.show(panel, "CreateTamagotchi"));
		retour.addActionListener(e -> layout.show(panel, "StartScreen"));
		
		return menu;
	}
	
	//---------------------------------------------------------------
	
	
	public static void main (String args []) {
		
		MenuView myMenu = new MenuView();
		
	}
	
}


