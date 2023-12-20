package view;

import java.awt.CardLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	private CardLayout layout ;

	private JPanel panel ;
	
	private StartScreenView startScreen = new StartScreenView(this);	//ecran de debut
	private MenuView menuScreen = new MenuView(this);	//choix de la partie (ancienne ou nouvelle)
	private CreateTamagotchiView createTamagotchi = new CreateTamagotchiView(this);	//creation d'un nouveau Tamagotchi
	
	//Nom des fenêtres 
	private final String start = "Start";
	private final String menu = "Menu";
	private final String create = "Create";
	
	public View() {
		super();
		layout = new CardLayout();
		panel = new JPanel(layout);
		setContentPane(panel);
		
		
		//Reglage des parametres de la fenetre
		this.setTitle("Dark Tamagotchi");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800,700);
		this.setLocationRelativeTo(null); 	//mets la fenetre au milieu de l'ecran
		
		
		this.add(startScreen, start);
		this.add(menuScreen, menu);
		this.add(createTamagotchi, create);
		layout.show(panel, start);
		
		
	}
	
	
	public JPanel getPanel() {
		return panel ;
	}
	
	public CardLayout getLayout() {
		return layout;
	}
	
	public String getStart() {
		return start;
	}
	
	public String getMenu() {
		return menu;
	}
	
	public String getCreate() {
		return create;
	}
	
	public static void main (String args []) {	
		View view = new View();
		view.setVisible(true);
	}
	
}

