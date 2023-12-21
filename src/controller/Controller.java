package controller;

import view.*;
import modele.*;
import modele.Maison.Piece;;

public class Controller {
	
	private View view ;	//La vue
	
	private Sauvegarde sauvegarde ; //Le modele
	
	private Tamagotchi tamagotchi ; 	//Le Tamagotchi courant
	
	private Piece piece ; 	//La piece courante
	
	
	public Controller(View v, Sauvegarde s) {
		view = v;
		view.setController(this);
		view.setVisible(true);
		sauvegarde = s ;
		tamagotchi = null ;
		piece = null;
	}

	public void createTamagotchi() {
		//On recupere les infos de la View
		String name = view.getName();
		String espece = view.getEspece();
		
		
		tamagotchi = sauvegarde.nouvellePartie(name, espece);
		piece = tamagotchi.getPiece();
	}
	
	public Tamagotchi getTamagotchi() {
		return tamagotchi;
		
	}
	
}
