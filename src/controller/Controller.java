package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import modele.Maison.Piece;
import modele.Tamagotchi;
import view.View;;

public class Controller {
	
	private View view ;	//La vue
	
	private Sauvegarde sauvegarde ; //Le modele
	
	private Tamagotchi tamagotchi ; 	//Le Tamagotchi courant
	
	private Piece piece ; 	//La piece courante
	
	private boolean enCours;
	
	//=================================================================================================================
	
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
	
	//=================================================================================================================

	public void createTamagotchi() {
		//On recupere les infos de la View
		String name = view.getName();
		String espece = view.getEspece();
		
		
		tamagotchi = sauvegarde.nouvellePartie(name, espece);
		
		piece = tamagotchi.getPiece();
		
		play();
		//todo Linda
		sauvegarde.sauvegarder(tamagotchi);
	}
	
	//=================================================================================================================
	
	public void play() {
		
		enCours = true;
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		//lancer la perte de vie
		Runnable pv = () -> {
			while(enCours) {
				tamagotchi.mourirDeVieillesse();
				if (tamagotchi.estMort()) {
					enCours = false;
				}
			}
		};
		
		//lancer la perte des points de moral
		Runnable pm = () -> {
			while (enCours) {
				tamagotchi.mourirDeDepression();
				if (tamagotchi.estMort()) {
					enCours = false;
				}
			}
		};
		
		ex.execute(pv);
		ex.execute(pm);
		
}
	
	//=================================================================================================================
	
	//todo Linda
	public ArrayList<Tamagotchi> getTamagoSauvegardes() {
        return sauvegarde.getTamagotchisSauvegardes();
    }
	
	//=================================================================================================================
	
	public Tamagotchi getTamagotchi() {
		return tamagotchi;
		
	}
	
	//=================================================================================================================
	
	//yodo Linda
	public void getdelete(Tamagotchi t) {
		sauvegarde.deleteTamagotchi(t);
	}
	
	//=================================================================================================================
	
	//TODO : Oldton
	public boolean getState() {
		return enCours;
	}
	
	
}
