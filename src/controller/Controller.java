package controller;

import view.*;

import java.util.ArrayList;

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
		view.setSauvegarde(s);
		view.setVisible(true);
		
		//add Linda
		
	    if (s == null) {
	        throw new IllegalArgumentException("L'objet Sauvegarde ne doit pas être null");
	    }
	    this.sauvegarde = s;
	    
		//sauvegarde = s ;
		tamagotchi = null ;
		piece = null;
		
	}

	public void createTamagotchi() {
		//On recupere les infos de la View
		String name = view.getName();
		String espece = view.getEspece();
		
		
		tamagotchi = sauvegarde.nouvellePartie(name, espece);
		
		piece = tamagotchi.getPiece();
		//todo Linda
		sauvegarde.sauvegarder(tamagotchi);
	}
	//todo Linda
	public ArrayList<Tamagotchi> getTamagoSauvegardes() {
        return sauvegarde.getTamagotchisSauvegardes();
    }
	public Tamagotchi getTamagotchi() {
		return tamagotchi;
		
	}
	//yodo Linda
	public void getdelete(Tamagotchi t) {
		sauvegarde.deleteTamagotchi(t);
	}
	
	
}
