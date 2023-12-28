package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import modele.Animal;
import modele.Chien;
import modele.Lion;
import modele.Maison.Piece;
import modele.Oiseau;
import modele.Robot;
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
		view.getSauvegardesView().setSauvegarde(s);
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
	
	//=================================================================================================================
	
	//APPELS AUX METHODES DE TYPE ACTION DU TAMAGOTCHI (jouer, regarder TV...)
	
	/*
	 * Methode qui execute une action en fonction de l'espece
	 * manger pour un Animal
	 * seRecharger pour un Robot
	 */
	public void manger_recharger() {
		if (getEspece().equals("Robot")) {
			((Robot)tamagotchi).seRecharger();
		}else {
			((Animal)tamagotchi).manger();
		}
	}
	
	/*
	 * Methode qui execute une action en fonction de l'espece
	 * dormir pour un Animal
	 * enVeille pour un Robot
	 */
	public void dormir_veille() {
		if (getEspece().equals("Robot")) {
			((Robot)tamagotchi).enVeille();
		}else {	
			((Animal)tamagotchi).dormir();
		}
	}
	
	/*
	 * Execute la methode jouer
	 */
	public void jouer() {
		tamagotchi.jouer();
	}
	
	/*
	 * Execute la methode regarderTV
	 */
	public void regarderTV() {
		tamagotchi.regarderTV();
	}
	
	/*
	 * Execute la methode faireSport
	 */
	public void sport() {
		tamagotchi.faireSport();
	}
	
	/*
	 * Execute la methode jardinage
	 */
	public void jardiner() {
		tamagotchi.jardinage();
	}
	
	/*
	 * Execute la methode seLaver
	 */
	public void seLaver() {
		tamagotchi.seLaver();
	}
	
	/*
	 * Execute la methode brosserDent
	 */
	public void brosserDents() {
		tamagotchi.brosserDent();
	}
	
	/*
	 * Execute la methode seSoulager
	 */
	public void toilettes() {
		tamagotchi.seSoulager();
	}
	
	/*
	 * Methode qui execute une action speciale en fonction de l'espece
	 * sauter si c'est un Lion,
	 * voler si c'est un Oiseau,
	 * va chercher si c'est un Chien
	 */
	public void actionSpeciale() {
		if (getEspece().equals("Lion")) {
			((Lion)tamagotchi).sauter();
		}else if(getEspece().equals("Oiseau")) {
			((Oiseau)tamagotchi).voler();
		}else if(getEspece().equals("Chien")) {
			((Chien)tamagotchi).vaChercher();
		}
	}
	
	//=================================================================================================================
	
	//GETTER DES ATTRIBUTS
	
	public String getNom() {
		return tamagotchi.getNom();
	}
	
	/*
	 * Methode qui retourne l'espece du Tamgocthi courant sous forme de String
	 * (Elle est utilisee dans la classe InterfaceJeuView pour l'affichage des boutons d'actions
	 */
	public String getEspece() {
		if (tamagotchi instanceof Robot) {
			return "Robot" ;
		}else if(tamagotchi instanceof Chien) {
			return "Chien" ;
		}else if(tamagotchi instanceof Oiseau) {
			return "Oiseau" ;
		}else if (tamagotchi instanceof Lion) {
			return "Lion";
		}
		return null;		//TODO: ajouter un try catch avec msg d'erreur
	}
	
	public int getVie() {
		return tamagotchi.getVie();
	}
	
	public int getEnergie() {
		return tamagotchi.getEnergie();
	}
	
	public int getMoral() {
		return tamagotchi.getMoral();
	}
	
	public int getHygiene() {
		return tamagotchi.getHygiene();
	}
	
	public int getToilette() {
		return tamagotchi.getToilette();
	}
	
	public int getNourriture_Batterie() {
		if(getEspece().equals("Robot")){
			return ((Robot)tamagotchi).getBatterie();
		}else {
			return ((Animal)tamagotchi).getNourriture();
		}
	}
	
}
