package view;

import javax.swing.*;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import modele.Action ;
import modele.Maison.Piece;

@SuppressWarnings("serial")
public class InterfaceJeuView extends JPanel {
	//Image de fond
    private Image backgroundImage;
    
    //Bouton des pieces
    private JButton salon;
    private JButton salle_de_bain;
    private JButton chambre;
    private JButton cuisine;
    private JButton jardin;
    private JPanel boutonsPieces;
    
    //Bouton des actions
    private JButton manger_recharge ;
    private JButton dormir_veille ;
    private JButton jouer ;
    private JButton regarderTV ;
    private JButton sport ;
    private JButton jardiner ;
    private JButton seLaver ;
    private JButton brosserDents ;
    private JButton toilettes ;
    private JButton actionSpeciale ;		//sauter, vaChercher, voler
    private JPanel boutonsActions;

    public InterfaceJeuView(View frame) {
    	
        // Configuration du layout du panneau principal
        setLayout(new BorderLayout());

        // Charger l'image d'arrière-plan
        changeBackgroundImage("/media/salon.png");

        // Initialisation des boutons de Pieces
        salon = new JButton("Salon");
        salle_de_bain = new JButton("Salle de bain");
        chambre = new JButton("Chambre");
        cuisine = new JButton("Cuisine");
        jardin = new JButton("Jardin");
        
        
        // Initialisation du panel des pieces
        boutonsPieces = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boutonsPieces.add(salon);
        boutonsPieces.add(salle_de_bain);
        boutonsPieces.add(chambre);
        boutonsPieces.add(cuisine);
        boutonsPieces.add(jardin);
        
        
        //Initialisation des boutons d'actions
        manger_recharge = new JButton(Action.Manger_SeRecharger.getActionName());
        dormir_veille = new JButton(Action.Dormir_EnVeille.getActionName());
        jouer = new JButton(Action.Jouer.getActionName());
        regarderTV = new JButton(Action.RegarderTV.getActionName());
        sport = new JButton(Action.Sport.getActionName());
        jardiner = new JButton(Action.Jardiner.getActionName());
        seLaver = new JButton(Action.SeLaver.getActionName());
        brosserDents = new JButton(Action.BrosserDents.getActionName());
        toilettes = new JButton(Action.Toilettes.getActionName());
        //actionSpeciale = new JButton("Manger");
        
        //Initialisation du panel des actions
        boutonsActions = new JPanel();
        //boutonsActions.setLayout(new GridLayout(9,1));
        boutonsActions.setLayout(new BoxLayout(boutonsActions, BoxLayout.Y_AXIS));
        boutonsActions.add(manger_recharge);
        boutonsActions.add(dormir_veille);
        boutonsActions.add(jouer);
        boutonsActions.add(regarderTV);
        boutonsActions.add(sport);
        boutonsActions.add(jardiner);
        boutonsActions.add(seLaver);
        boutonsActions.add(brosserDents);
        boutonsActions.add(toilettes);
        boutonsActions.setBackground(new Color(255, 255, 255, 0));
        boutonsActions.setPreferredSize(new Dimension(200, 500));
        
        afficherBoutonsAction(Piece.Salon);	//TODO: a enlever et gerer avec le controller
        
        chambre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/chambre.png");
                afficherBoutonsAction(Piece.Chambre);
            }
        });
        
        salon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/salon.png");
                afficherBoutonsAction(Piece.Salon);
            }
        });
        
        salle_de_bain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/salle de bain.png");
                afficherBoutonsAction(Piece.SDB);
            }
        });
        
        cuisine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/cuisine.png");
                afficherBoutonsAction(Piece.Cuisine);
            }
        });
        
        jardin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundImage("/media/Jardin.png");
                afficherBoutonsAction(Piece.Jardin);
            }
        });
        
        // Ajouter le pannel des pieces en bas de la fenêtre
        add(boutonsPieces, BorderLayout.SOUTH);
        
     // Ajouter le pannel des actions à droite de la fenêtre
        add(boutonsActions, BorderLayout.EAST);
        
        
    }
    private void changeBackgroundImage(String imagePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(imagePath));
            repaint(); // Redessiner le panel pour afficher la nouvelle image
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner l'image en arrière-plan
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    
    public void afficherBoutonsAction(Piece p) {
    	switch(p.getName()) {
    		case "Salon" :
    			jouer.setVisible(true);
    			regarderTV.setVisible(true);
    			manger_recharge.setVisible(false);
    			dormir_veille.setVisible(false);
    			sport.setVisible(false);
    			jardiner.setVisible(false);
    			seLaver.setVisible(false);
    			brosserDents.setVisible(false);
    			toilettes.setVisible(false);
    			break;
    		case "Cuisine" :
    			jouer.setVisible(false);
    			regarderTV.setVisible(false);
    			manger_recharge.setVisible(true);
    			dormir_veille.setVisible(false);
    			sport.setVisible(false);
    			jardiner.setVisible(false);
    			seLaver.setVisible(false);
    			brosserDents.setVisible(false);
    			toilettes.setVisible(false);
    			break ;
    		case "Chambre" :
    			jouer.setVisible(true);
    			regarderTV.setVisible(false);
    			manger_recharge.setVisible(false);
    			dormir_veille.setVisible(true);
    			sport.setVisible(true);
    			jardiner.setVisible(false);
    			seLaver.setVisible(false);
    			brosserDents.setVisible(false);
    			toilettes.setVisible(false);
    			break;
    		case "SDB" :
    			jouer.setVisible(false);
    			regarderTV.setVisible(false);
    			manger_recharge.setVisible(false);
    			dormir_veille.setVisible(false);
    			sport.setVisible(false);
    			jardiner.setVisible(false);
    			seLaver.setVisible(true);
    			brosserDents.setVisible(true);
    			toilettes.setVisible(true);
    			break;
    		case "Jardin" :
    			jouer.setVisible(true);
    			regarderTV.setVisible(false);
    			manger_recharge.setVisible(false);
    			dormir_veille.setVisible(false);
    			sport.setVisible(true);
    			jardiner.setVisible(true);
    			seLaver.setVisible(false);
    			brosserDents.setVisible(false);
    			toilettes.setVisible(false);
    			break;
    	}
    }
}

