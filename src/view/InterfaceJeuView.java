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
import modele.Tamagotchi;

@SuppressWarnings("serial")
public class InterfaceJeuView extends JPanel implements Observateur {
	
	private View view ;
	private Controller controller ;
	
	//Image de fond
    private Image backgroundImage;
    
    
    //Label des attributs
    private JLabel name ;
    private JLabel espece; 
    private JLabel vie ;
    private JLabel energie ;
    private JLabel moral ;
    private JLabel hygiene ;
    private JLabel toilette;
    private JLabel nourriture_batterie;
    private JPanel attributs ;				//panel des attributs
    
    //Boutons des pieces
    private GradientButton salon;
    private GradientButton salle_de_bain;
    private GradientButton chambre;
    private GradientButton cuisine;
    private GradientButton jardin;
    private JPanel boutonsPieces;			//panel des pieces
    
    //Boutons des actions
    private GradientButton manger_recharge ;
    private GradientButton dormir_veille ;
    private GradientButton jouer ;
    private GradientButton regarderTV ;
    private GradientButton sport ;
    private GradientButton jardiner ;
    private GradientButton seLaver ;
    private GradientButton brosserDents ;
    private GradientButton toilettes ;
    private GradientButton actionSpeciale ;		//sauter, vaChercher, voler
    private JPanel boutonsActions;			//panel des actions
    
    private GradientButton quitter ;
    private Image TamaImage;
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
        		changeImage("/media/robot.png");
        		Action.Manger_SeRecharger.setActionName("Se recharger");
        		Action.Dormir_EnVeille.setActionName("En veille");
        		break ;
        	case "Chien":
        		changeImage("/media/chien.png");
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Va chercher");
        		break ;
        	case "Oiseau":
        		changeImage("/media/oiseau.png");
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Voler");
        		break ;
        	case "Lion":
        		changeImage("/media/lion.png");
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Sauter");
        		break ;
        }
    	manger_recharge = new GradientButton(Action.Manger_SeRecharger.getActionName());
        dormir_veille = new GradientButton(Action.Dormir_EnVeille.getActionName());
        jouer = new GradientButton(Action.Jouer.getActionName());
        regarderTV = new GradientButton(Action.RegarderTV.getActionName());
        sport = new GradientButton(Action.Sport.getActionName());
        jardiner = new GradientButton(Action.Jardiner.getActionName());
        seLaver = new GradientButton(Action.SeLaver.getActionName());
        brosserDents = new GradientButton(Action.BrosserDents.getActionName());
        toilettes = new GradientButton(Action.Toilettes.getActionName());
        actionSpeciale = new GradientButton(Action.ActionSpeciale.getActionName());
        
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
        salon = new GradientButton("Salon");
        salle_de_bain = new GradientButton("Salle de bain");
        chambre = new GradientButton("Chambre");
        cuisine = new GradientButton("Cuisine");
        jardin = new GradientButton("Jardin");
      
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
        quitter = new GradientButton("Quitter");
        quitter.addActionListener(e -> view.showStartScreen());
        boutonsPieces.add(quitter);
    }
    
    /*
     * Initialisation et affichage sur le panel (this) des attributs du Tamagotchi courant
     */
    public void affichageLabelsAttributs() {
    	name = new JLabel("Nom : " + controller.getNom()) ;
        espece = new JLabel("Espèce : " + controller.getEspece()) ;
    	vie = new JLabel("Vie : " + controller.getVie()) ;
        energie = new JLabel("Energie : " + controller.getEnergie()) ;
        moral = new JLabel("Moral : " + controller.getMoral()) ;
        hygiene = new JLabel("Hygiene : " + controller.getHygiene()) ;
        toilette = new JLabel("Toilettes : " + controller.getToilette()) ;
        if (controller.getEspece().equals("Robot")){
        	nourriture_batterie = new JLabel("Batterie : " + controller.getNourriture_Batterie()) ;
        }else {
        	nourriture_batterie = new JLabel("Nourriture : " + controller.getNourriture_Batterie()) ;
        }
        	
        	//Changement de la couleur du texte des Label
        name.setForeground(Color.WHITE);
        espece.setForeground(Color.WHITE);
        vie.setForeground(Color.WHITE);
        energie.setForeground(Color.WHITE);
        moral.setForeground(Color.WHITE);
        hygiene.setForeground(Color.WHITE);
        toilette.setForeground(Color.WHITE);
        nourriture_batterie.setForeground(Color.WHITE);
        
        attributs = new JPanel();
        attributs.setLayout(new BoxLayout(attributs, BoxLayout.Y_AXIS));
        attributs.add(name);
        attributs.add(espece);
        attributs.add(vie);
        attributs.add(energie);
        attributs.add(moral);
        attributs.add(hygiene);
        attributs.add(toilette);
        attributs.add(nourriture_batterie);
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
				mettreAJour();			//TODO : Observateur
			}
		});
    	
        dormir_veille.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.dormir_veille();
				mettreAJour();			//TODO : Observateur
			}
		});
        
        jouer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.jouer();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        regarderTV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.regarderTV();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        sport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sport();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        jardiner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.jardiner();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        seLaver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.seLaver();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        brosserDents.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.brosserDents();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        
        toilettes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.toilettes();
				mettreAJour();			//TODO : Observateur
				
			}
		});
        
        actionSpeciale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.actionSpeciale();
				mettreAJour();			//TODO : Observateur
					
			}
		});
    }
    
    public void changeImage(String imagePath) {
        try {
        	Image originalImage = ImageIO.read(getClass().getResource(imagePath));
            TamaImage = originalImage.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (TamaImage != null) {
            int imageWidth = TamaImage.getWidth(this);
            int imageHeight = TamaImage.getHeight(this);

            int x = (this.getWidth() - imageWidth) / 2; // Centrer 
            int y = this.getHeight() - imageHeight;     // Positionner en bas

            g.drawImage(TamaImage, x, y, this);
        }
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
    
    public void eraseStat() {
    	System.out.println("ERASE");
    	//name.setText(null) ;
        //espece.setText(null) ;
    	vie.setText(null) ;
        energie.setText(null) ;
        moral.setText(null) ;
        hygiene.setText(null) ;
        toilette.setText(null) ;
        if (controller.getEspece().equals("Robot")){
        	nourriture_batterie.setText(null) ;
        }else {
        	nourriture_batterie.setText(null) ;
        }
    }
    
    public void resetStat() {
    	eraseStat();
    	name.setText("Nom : ") ;
        espece.setText("Espèce : ") ;
    	vie.setText("Vie : ") ;
        energie.setText("Energie : ") ;
        moral.setText("Moral : ") ;
        hygiene.setText("Hygiene : ") ;
        toilette.setText("Toilettes : ") ;
        if (controller.getEspece().equals("Robot")){
        	nourriture_batterie.setText("Batterie : ") ;
        }else {
        	nourriture_batterie.setText("Nourriture : ") ;
        }
    }
    
    //TODO : Observateur
	@Override
	public void mettreAJour() {
		System.out.println("Mise a jour des attributs");
		
		eraseStat();
		//name.setText("KOO") ;
		Tamagotchi.wait(1);
		//Changement de la valeur des attributs
		name.setText("Nom : " + controller.getNom()) ;
        espece.setText("Espèce : " + controller.getEspece()) ;
    	vie.setText("Vie : " + controller.getVie()) ;
        energie.setText("Energie : " + controller.getEnergie()) ;
        moral.setText("Moral : " + controller.getMoral()) ;
        hygiene.setText("Hygiene : " + controller.getHygiene()) ;
        toilette.setText("Toilettes : " + controller.getToilette()) ;
        if (controller.getEspece().equals("Robot")){
        	nourriture_batterie.setText("Batterie : " + controller.getNourriture_Batterie()) ;
        }else {
        	nourriture_batterie.setText("Nourriture : " + controller.getNourriture_Batterie()) ;
        }
		
	}
}

