package view;
import modele.*;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

import controller.Controller;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	private Controller controller ;
	private Sauvegarde sauvegarde ;
	private CardLayout layout ;

	private JPanel panel ;
	
	private StartScreenView startScreen = new StartScreenView(this);	//ecran de debut
	private MenuView menuScreen = new MenuView(this);	//choix de la partie (ancienne ou nouvelle)
	private CreateTamagotchiView createTamagotchi = new CreateTamagotchiView(this);	//creation d'un nouveau Tamagotchi
	private InterfaceJeuView gameView = new InterfaceJeuView(this);
	private SauvegardesView sauvegardesView = new SauvegardesView(this); //todo Linda

    
	//Nom des fenêtres 
	private final String start = "Start";
	private final String menu = "Menu";
	private final String create = "Create";
	private final String game = "Game";
	private final String sauvegardeName= "Sauvegarde"; //tood Linda
	
	public View() {
		super();
		layout = new CardLayout();
		panel = new JPanel(layout);
		setContentPane(panel);
		
		//Reglage des parametres de la fenetre
		this.setTitle("Dark Tamagotchi");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1500,900);
		this.setLocationRelativeTo(null); 	//mets la fenetre au milieu de l'ecran
		
		
		this.add(startScreen, start);
		this.add(menuScreen, menu);
		this.add(createTamagotchi, create);
		this.add(gameView, game);
		this.add(sauvegardesView, sauvegardeName); //todo Linda
		layout.show(panel, start);
		
		
	}
	
	public Controller getController() {
		return controller ; 
	}
	
	public void setController(Controller controller) {
		this.controller = controller ; 
	}
	
	//TOdo Linda
	public SauvegardesView getSauvegardesView() {
		return sauvegardesView;
	}
	
	public InterfaceJeuView getGameView() {
		return gameView ;
	}
	public void setSauvegarde(Sauvegarde sauvegarde) { //todo Linda
		this.sauvegarde = sauvegarde;
	}
	
	public Sauvegarde getSauvegarde() {
		return sauvegarde ; 
	}
	
	
	public JPanel getPanel() {
		return panel ;
	}
	
	public CardLayout getLayout() {
		return layout;
	}
	
	//Permet de recuperer le nom de l'ecran de demarrage 
	public String getStart() {
		return start;
	}
	
	//Permet de recuperer le nom du Menu dans lequel on chosit si on veut creer ou sauvegarder un tamagotchi
	public String getMenu() {
		return menu;
	}
	
	//Permet de recuperer le nom du panel de creation du Tamagotchi
	public String getCreate() {
		return create;
	}
	
	
	//Permet de recuperer le nom du panel de jeu
	public String getGame() {
		return game;
	}
	
	//Permet de recuperer le nom du panel de jeu
		public String getSauvegardeName() {
			return sauvegardeName;
		}
	
	
	//Permet de passer au controleur le nom du Tamagotchi que l'on souhaite creer
	public String getName() {
		return createTamagotchi.getName();
	}
	
	//Premet de passer au controlleur l'espece du Tamagotchi que l'on souhaite creer
	public String getEspece() {
		return createTamagotchi.getEspece();
	}
	
	
	public static void main (String args []) {	
		View view = new View();
		view.setVisible(true);
	}
	
}

