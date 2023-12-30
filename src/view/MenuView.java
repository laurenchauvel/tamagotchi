package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
		newGame = new GradientButton("Nouvelle partie");
		newGame.setForeground(Color.WHITE);
		oldGame = new GradientButton("Mes parties sauvegardées");
		oldGame.setForeground(Color.WHITE);
		retour = new JButton("Retour");
		retour.setForeground(Color.WHITE);
		retour.setBackground(new Color(216, 20, 20));
	
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
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}


