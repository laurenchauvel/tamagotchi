package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}


