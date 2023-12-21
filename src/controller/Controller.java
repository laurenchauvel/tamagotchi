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
		sauvegarde = s ;
		tamagotchi = null ;
		piece = tamagotchi.getMaison().getPiece();
	}

	public void createTamagotchi() {
		//On recupere les infos de la View
		String name = view.getName();
		String espece = view.getEspece();
		
		
		tamagotchi = sauvegarde.nouvellePartie(name, espece);
		
		/*
		//On cree un nouveau tamagotchi de l'espece choisie par l'utilisateur
		switch(espece){
			case "Chien" : 
				tamagotchi = new Chien(name);
				break;
			case "Lion" : 
				tamagotchi = new Lion(name);
				break;
			case "Oiseau" :
				tamagotchi = new Oiseau(name);
				break;
			case "Robot" : 
				tamagotchi = new Robot(name);
				break;
		}*/
		
		//sauvegarde.sauvegarder(tamagotchi);
		
	}
	
}
