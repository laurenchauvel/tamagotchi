package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import modele.Action ;
import modele.Maison.Piece;
import modele.Tamagotchi;
import modele.Tamagotchi.Espece;

@SuppressWarnings("serial")
public class InterfaceJeuView extends JPanel /*implements Observateur*/  {
	
	private View view ;
	//private Controller controller ;
	
	//Image de fond
    private Image backgroundImage;
    
    
    //Label des attributs
    private JProgressBar vie ;
    private JProgressBar energie ;
    private JProgressBar moral ;
    private JProgressBar hygiene ;
    private JProgressBar toilette;
    private JProgressBar nourriture_batterie;
    private JPanel attributs ;
    
    private JLabel name ;
    private JLabel espece; 
    
    
    private JLabel labelVie ;
    private JLabel labelEnergie ;
    private JLabel labelMoral ;
    private JLabel labelHygiene ;
    private JLabel labelToilette;
    private JLabel labelNourriture_Batterie;
   // private JPanel attributs ;	
    			//panel des attributs
    
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
    
        // Configuration du layout du panneau principal
        setLayout(new BorderLayout());

        // Charger l'image d'arrière-plan
        changeBackgroundImage(view.getController().getTamagotchi().getMaison().getPiece().getImage());
        
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
        switch(view.getController().getEspece()){
        	case "Robot":
        		changeImage(view.getController().choisirEspece(Espece.Robot));
        		
        		Action.Manger_SeRecharger.setActionName("Se recharger");
        		Action.Dormir_EnVeille.setActionName("En veille");
        		break ;
        	case "Chien":
        		changeImage(view.getController().choisirEspece(Espece.Chien));
        		
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Va chercher");
        		break ;
        	case "Oiseau":
        		changeImage(view.getController().choisirEspece(Espece.Oiseau));
        		
        		Action.Manger_SeRecharger.setActionName("Manger");
        		Action.Dormir_EnVeille.setActionName("Dormir");
        		Action.ActionSpeciale.setActionName("Voler");
        		break ;
        	case "Lion":
        		changeImage(view.getController().choisirEspece(Espece.Lion));
        		
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
        quitter.addActionListener(e -> {

        	 Options();

        });
    	 boutonsPieces.add(quitter);
    	 }
    	 private void Options() {
        	 String[] options = {"Oui", "Non"};
        	 
        	 int response = JOptionPane.showOptionDialog(this, "Voulez vous quitter ?", "Quitter" ,
        	 JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
        	 
        	 switch (response) {
        	 case 0: // Oui
        		 view.getController().setState(false);
        		 view.getController().enregistrer();
        		 view.showStartScreen();
        	 	break;
        	 case 1: // Non
        		 break;    	 
    	 }
	 }
    
    /*
     * Initialisation et affichage sur le panel (this) des attributs du Tamagotchi courant
     */
    public synchronized void affichageLabelsAttributs() {
    	
    	labelVie = new JLabel("Vie : ");
        labelEnergie = new JLabel("Énergie : ");
    	labelMoral = new JLabel("Moral : ");
    	labelHygiene = new JLabel("Hygiène : ");
    	labelToilette = new JLabel("Toilette : ");
    	labelNourriture_Batterie = new JLabel(view.getController().getEspece().equals("Robot") ? "Batterie : " : "Nourriture : ");

    	
    	//=============================================================
        name = new JLabel("Nom : " + view.getController().getNom()) ;
        espece = new JLabel("Espèce : " + view.getController().getEspece()) ;
    	vie = new JProgressBar(0,100/*"Vie : " + controller.getVie()*/) ;
    	vie.setValue(view.getController().getVie());
    	vie.setStringPainted(true);
    	
        energie = new JProgressBar(0,100/*"Energie : " + controller.getEnergie()*/) ;
        energie.setValue(view.getController().getEnergie());
    	energie.setStringPainted(true);
    	
        moral = new JProgressBar(0,100/*"Moral : " + controller.getMoral()*/) ;
        moral.setValue(view.getController().getMoral());
    	moral.setStringPainted(true);
    	
        hygiene = new JProgressBar(0,100/*"Hygiene : " + controller.getHygiene()*/) ;
        hygiene.setValue(view.getController().getHygiene());
    	hygiene.setStringPainted(true);
    	
        toilette = new JProgressBar(0,100/*"Toilettes : " + controller.getToilette()*/) ;
        toilette.setValue(view.getController().getToilette());
    	toilette.setStringPainted(true);
    	
        if (view.getController().getEspece().equals("Robot")){
        	nourriture_batterie = new JProgressBar(0,100/*"Batterie : " + controller.getNourriture_Batterie()*/) ;
        	nourriture_batterie.setValue(view.getController().getNourriture_Batterie());
        	nourriture_batterie.setStringPainted(true);
        }else {
        	nourriture_batterie = new JProgressBar(0,100/*"Nourriture : " + controller.getNourriture_Batterie()*/) ;
        	nourriture_batterie.setValue(view.getController().getNourriture_Batterie());
        	nourriture_batterie.setStringPainted(true);
        }
    		
      //Changement de la couleur et de la taille du texte des JProgressBar

        Font labelFont = new Font("Arial", Font.BOLD, 20);

        name.setForeground(new Color(210, 119, 221));
        name.setFont(labelFont);
        espece.setForeground(new Color(210, 119, 221));
        espece.setFont(labelFont);
        vie.setForeground(new Color(108, 12, 119));
        vie.setFont(labelFont);
        energie.setForeground(new Color(108, 12, 119));
        energie.setFont(labelFont);
        moral.setForeground(new Color(108, 12, 119));
        moral.setFont(labelFont);
        hygiene.setForeground(new Color(108, 12, 119));
        hygiene.setFont(labelFont);
        toilette.setForeground(new Color(108, 12, 119));
        toilette.setFont(labelFont);
        nourriture_batterie.setForeground(new Color(108, 12, 119));
        nourriture_batterie.setFont(labelFont);
        
      //Changement de la couleur et de la taille du texte des JLabel

        labelVie.setForeground(Color.white);
        labelVie.setFont(labelFont);
     // Configuration de labelVie (déjà fait)
        labelVie.setForeground(Color.white);
        labelVie.setFont(labelFont);

        // Configuration de labelEnergie
        labelEnergie.setForeground(Color.white);
        labelEnergie.setFont(labelFont);

        // Configuration de labelMoral
        labelMoral.setForeground(Color.white);
        labelMoral.setFont(labelFont);

        // ... Continuez avec les autres labels de la même manière
        labelHygiene.setForeground(Color.white);
        labelHygiene.setFont(labelFont);

        labelToilette.setForeground(Color.white);
        labelToilette.setFont(labelFont);

        labelNourriture_Batterie.setForeground(Color.white);
        labelNourriture_Batterie.setFont(labelFont);

        // ... et ainsi de suite pour les autres labels que vous avez

        
        attributs = new JPanel();
        attributs.setLayout(new BoxLayout(attributs, BoxLayout.Y_AXIS));
        
        attributs.add(name);
        attributs.add(espece);
        attributs.add(labelVie);
        attributs.add(vie);
        attributs.add(labelEnergie);
        attributs.add(energie);
        attributs.add(labelMoral);
        attributs.add(moral);
        attributs.add(labelHygiene);
        attributs.add(hygiene);
        attributs.add(labelToilette);
        attributs.add(toilette);
        attributs.add(labelNourriture_Batterie);
        attributs.add(nourriture_batterie);
        attributs.setBackground(new Color(255, 255, 255, 0));
        
        this.add(attributs, BorderLayout.WEST);
        
        ExecutorService ex = Executors.newCachedThreadPool();
        
        Runnable stat = () -> {
        	while (view.getController().getState() == true) {
        		mettreAJour();
        		Tamagotchi.wait(1);
        	}
        };
        
        ex.execute(stat);
        
    }
    
    /*
     * Ajout de listeners aux boutons des pieces 
     */
    private synchronized void addListenersToPieces() {
    	chambre.addActionListener(new ActionListener() {
            @Override
            public synchronized void actionPerformed(ActionEvent e) {
            	view.getController().changerDePiece(Piece.Chambre);
                changeBackgroundImage(view.getController().getImagePiece());
                afficherBoutonsAction(Piece.Chambre);
            }
        });
        
        salon.addActionListener(new ActionListener() {
            @Override
            public synchronized void actionPerformed(ActionEvent e) {
            	view.getController().changerDePiece(Piece.Salon);
                changeBackgroundImage(view.getController().getImagePiece());
                afficherBoutonsAction(Piece.Salon);
            }
        });
        
        salle_de_bain.addActionListener(new ActionListener() {
            @Override
            public synchronized void actionPerformed(ActionEvent e) {
            	view.getController().changerDePiece(Piece.SDB);
                changeBackgroundImage(view.getController().getImagePiece());
                afficherBoutonsAction(Piece.SDB);
            }
        });
        
        cuisine.addActionListener(new ActionListener() {
            @Override
            public synchronized void actionPerformed(ActionEvent e) {
            	view.getController().changerDePiece(Piece.Cuisine);
                changeBackgroundImage(view.getController().getImagePiece());
                afficherBoutonsAction(Piece.Cuisine);
            }
        });
        
        jardin.addActionListener(new ActionListener() {
            @Override
            public synchronized void actionPerformed(ActionEvent e) {
            	view.getController().changerDePiece(Piece.Jardin);
                changeBackgroundImage(view.getController().getImagePiece());
                afficherBoutonsAction(Piece.Jardin);
            }
        });
    }
    
    
    private void addListenersToActions() {
    	manger_recharge.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().manger_recharger();
			}
		});
    	
        dormir_veille.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().dormir_veille();
			}
		});
        
        jouer.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().jouer();
			}
		});
        
        regarderTV.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().regarderTV();
			}
		});
        
        sport.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().sport();
			}
		});
        
        jardiner.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().jardiner();
			}
		});
        
        seLaver.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().seLaver();
			}
		});
        
        brosserDents.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().brosserDents();
			}
		});
        
        
        toilettes.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().toilettes();
			}
		});
        
        actionSpeciale.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				view.getController().actionSpeciale();
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
    			if(view.getController().getEspece().equals("Robot")){
    				actionSpeciale.setVisible(false);
    			}else {
    				actionSpeciale.setVisible(true);
    			}
    			break;
    	}
    }
    
    public synchronized void mettreAJour() {
    	vie.setValue(view.getController().getVie()) ;
        energie.setValue(+ view.getController().getEnergie()) ;
        moral.setValue(view.getController().getMoral()) ;
        hygiene.setValue(view.getController().getHygiene()) ;
        toilette.setValue(view.getController().getToilette()) ;
        if (view.getController().getEspece().equals("Robot")){
        	nourriture_batterie.setValue(view.getController().getNourriture_Batterie()) ;
        }else {
        	nourriture_batterie.setValue(view.getController().getNourriture_Batterie()) ;
        }      
		
	}
	
	public synchronized void afficherMsgMort() {		
		JOptionPane.showMessageDialog(InterfaceJeuView.this, view.getController().getNom()+" a succombé au poids de sa pauvre existence...");
   	 	
		view.getController().setState(false);
		view.getController().getdelete(view.getController().getTamagotchi());
		view.showStartScreen();
   	 		
	}
	
}

