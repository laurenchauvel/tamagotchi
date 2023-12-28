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
	
	private View view ;
	private Controller controller ;
	
	//Image de fond
    private Image backgroundImage;
    
    
    //Label des attributs
    private JLabel name ;
    private JLabel vie ;
    private JLabel energie ;
    private JLabel moral ;
    private JLabel hygiene ;
    private JPanel attributs ;				//panel des attributs
    
    //Boutons des pieces
    private JButton salon;
    private JButton salle_de_bain;
    private JButton chambre;
    private JButton cuisine;
    private JButton jardin;
    private JPanel boutonsPieces;			//panel des pieces
    
    //Boutons des actions
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
    private JPanel boutonsActions;			//panel des actions
    
    private JButton quitter ;

    /*
     * Cobstructeur de l'interface de jeu  
     */
    public InterfaceJeuView(View frame) {
    	this.view = frame ;
    	
    	setController(view.getController());
        // Configuration du layout du panneau principal
        setLayout(new BorderLayout());

        // Charger l'image d'arrière-plan
        changeBackgroundImage("/media/salon.png");
        
        //Affichage des actions
        initialisationBoutonsActions();
        
        //Affichage des pieces
        affichageBoutonsPieces();
        
        //Affichage des attirbuts
		affichageLabelsAttributs();
    }
    
    /*
     * Initialisation et affichage sur le panel (this) des boutons des actions
     */
    public void initialisationBoutonsActions() {
    	//Initialisation des boutons d'actions
        switch(controller.getEspece()){
        	case "Robot":
        		Action.Manger_SeRecharger.setActionName("Se recharger");
        		Action.Dormir_EnVeille.setActionName("En veille");
        		break ;
        	case "Chien":
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Va chercher");
        		break ;
        	case "Oiseau":
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Voler");
        		break ;
        	case "Lion":
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Sauter");
        		break ;
        }
    	manger_recharge = new JButton(Action.Manger_SeRecharger.getActionName());
        dormir_veille = new JButton(Action.Dormir_EnVeille.getActionName());
        jouer = new JButton(Action.Jouer.getActionName());
        regarderTV = new JButton(Action.RegarderTV.getActionName());
        sport = new JButton(Action.Sport.getActionName());
        jardiner = new JButton(Action.Jardiner.getActionName());
        seLaver = new JButton(Action.SeLaver.getActionName());
        brosserDents = new JButton(Action.BrosserDents.getActionName());
        toilettes = new JButton(Action.Toilettes.getActionName());
        actionSpeciale = new JButton(Action.ActionSpeciale.getActionName());
        
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
        boutonsActions.add(actionSpeciale);
        boutonsActions.setBackground(new Color(255, 255, 255, 0));
        boutonsActions.setPreferredSize(new Dimension(200, 500));
        
        
        addListenersToActions();
        
        // Ajouter le pannel des actions à droite de la fenêtre
        add(boutonsActions, BorderLayout.EAST);
        
        afficherBoutonsAction(Piece.Salon);	//TODO: a enlever et gerer avec le controller
    }
    
    /*
     * Initialisation et affichage sur le panel (this) des boutons des pieces
     */
    public void affichageBoutonsPieces() {
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
        
        addListenersToPieces();
        
     // Ajouter le pannel des pieces en bas de la fenêtre
        add(boutonsPieces, BorderLayout.SOUTH);
        
      //Initialisation et ajout du bouton de retour au panel principal
        quitter = new JButton("Quitter");
        quitter.addActionListener(e -> view.getLayout().show(view.getPanel(), view.getStart()));
        boutonsPieces.add(quitter);
    }
    
    /*
     * Initialisation et affichage sur le panel (this) des attributs du Tamagotchi courant
     */
    public void affichageLabelsAttributs() {
    	name = new JLabel(controller.getTamagotchi().getNom()) ;
        vie = new JLabel("Vie : " + controller.getTamagotchi().getVie()) ;
        energie = new JLabel("Energie : " + controller.getTamagotchi().getEnergie()) ;
        moral = new JLabel("Moral : " + controller.getTamagotchi().getMoral()) ;
        hygiene = new JLabel("Hygiene : " + controller.getTamagotchi().getHygiene()) ;
        
        //Changement de la couleur du texte des Label
        name.setForeground(Color.WHITE);
        vie.setForeground(Color.WHITE);
        energie.setForeground(Color.WHITE);
        moral.setForeground(Color.WHITE);
        hygiene.setForeground(Color.WHITE);
        
        attributs = new JPanel();
        attributs.setLayout(new BoxLayout(attributs, BoxLayout.Y_AXIS));
        attributs.add(name);
        attributs.add(vie);
        attributs.add(energie);
        attributs.add(moral);
        attributs.add(hygiene);
        attributs.setBackground(new Color(255, 255, 255, 0));
        
        this.add(attributs, BorderLayout.WEST);
        
    }
    
    /*
     * Ajout de listeners aux boutons des pieces 
     */
    private void addListenersToPieces() {
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
    }
    
    
    private void addListenersToActions() {
    	manger_recharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.manger_recharger();
			}
		});
    	
        dormir_veille.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.dormir_veille();
			}
		});
        
        jouer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.jouer();
				
			}
		});
        
        regarderTV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.regarderTV();
				
			}
		});
        
        sport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sport();
				
			}
		});
        
        jardiner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.jardiner();
				
			}
		});
        
        seLaver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.seLaver();
				
			}
		});
        
        brosserDents.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.brosserDents();
				
			}
		});
        
        
        toilettes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.toilettes();
				
			}
		});
        
        actionSpeciale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.actionSpeciale();
				
			}
		});
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
    
    /*
     * Methode qui permet de rendre visible ou invisible les boutons d'action
     * en fonction de la piece ou l'on se trouve 
     */
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
    			actionSpeciale.setVisible(false);
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
    			actionSpeciale.setVisible(false);
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
    			actionSpeciale.setVisible(false);
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
    			actionSpeciale.setVisible(false);
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
    			if(controller.getEspece().equals("Robot")){
    				actionSpeciale.setVisible(false);
    			}else {
    				actionSpeciale.setVisible(true);
    			}
    			break;
    	}
    }
    
    public void setController(Controller c) {
    	this.controller = c;
    }
}

