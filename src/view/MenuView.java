package view;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuView extends JPanel {
	
	private JButton newGame ;
	private JButton oldGame ;
	private JButton retour ;
	
	/*
	 * Constructeur de la classe
	 */
	public MenuView (View frame) {
		
		newGame = new JButton("Nouvelle partie");
		oldGame = new JButton("Mes parties sauvegardées");
		retour = new JButton("Retour");
	
		this.add(newGame);
		this.add(oldGame);
		this.add(retour);
		
		//Action declenchee lorsque le bouton newGame est cliqué
		newGame.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getCreate()));
		
		//Action declenchee lorsque le bouton newGame est cliqué
		oldGame.addActionListener(e -> System.out.println("Bouton 'Mes parties sauvegardées' cliqué"));
		
		//Action declenchee lorsue le bouton retour est cliqué
		retour.addActionListener(e -> frame.getLayout().show(frame.getPanel(), frame.getStart()));

	}
}


