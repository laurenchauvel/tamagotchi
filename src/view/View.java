package view;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class View extends JFrame{
	
	private Controller controller ;
	private CardLayout layout ;

	private JPanel panel ;
	
	private StartScreenView startScreen = new StartScreenView(this);	//ecran de debut
	private MenuView menuScreen = new MenuView(this);	//choix de la partie (ancienne ou nouvelle)
	private CreateTamagotchiView createTamagotchi = new CreateTamagotchiView(this);	//creation d'un nouveau Tamagotchi
	private InterfaceJeuView gameView ;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500,900);
		this.setLocationRelativeTo(null); 	//mets la fenetre au milieu de l'ecran
		
		
		this.add(startScreen, start);
		this.add(menuScreen, menu);
		this.add(createTamagotchi, create);
		//this.add(gameView, game);		//cette ligne se fait mtn dans la methode showGameView() de cette classe
		this.add(sauvegardesView, sauvegardeName); //todo Linda
		showStartScreen();
		
		
	}
	
	/*
	 * Affiche le panel de démarrage à l'écran
	 */
	public void showStartScreen() {
		layout.show(panel, start);
	}
	
	/*
	 * Affiche le panel du menu à l'écran
	 */
	public void showMenu() {
		layout.show(panel, menu);
	}
	
	/*
	 * Affiche le panel de creation d'un nouveau tamagotchi à l'écran
	 */
	public void showCreateView() {
		layout.show(panel, create);
	}
	
	/*
	 * Affiche le panel du jeu à l'écran
	 */
	public void showGameView() {
		this.add(gameView, game);
		layout.show(panel, game);
	}
	
	/*
	 * Affiche le panel des parties sauvegardées à l'écran
	 */
	public void showSauvegardes() {
		layout.show(panel, sauvegardeName);
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
	
	public void setGameView(InterfaceJeuView ijv) {
		gameView=ijv;
	}
	
	public JPanel getPanel() {
		return panel ;
	}
	
	public CardLayout getLayout() {
		return layout;
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

