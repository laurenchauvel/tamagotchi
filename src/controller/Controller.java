package controller;
//betise

import java.io.File;
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
import view.InterfaceJeuView;
import view.Observateur;
import view.View;;

public class Controller {
	
	private View view ;	//La vue
	
	private Sauvegarde sauvegarde ; //Le modele
	
	private Tamagotchi tamagotchi ; 	//Le Tamagotchi courant
	
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
		
	}
	
	//=================================================================================================================

	public void createTamagotchi() {
		//On recupere les infos de la View
		String name = view.getName();
		String espece = view.getEspece();
		
		tamagotchi = sauvegarde.nouvellePartie(name, espece);
		setState(true);
		
		view.setGameView(new InterfaceJeuView(view));
	}
	
	//=================================================================================================================
	
	public void chargerPartie(Tamagotchi t) {
		tamagotchi = sauvegarde.reprendrePartie(t);
		setState(true);	
		view.setGameView(new InterfaceJeuView(view));	
		
	}
	
	//=================================================================================================================
	
	public void demarrerPartie(Tamagotchi t) {
		if (sauvegarde.findTamagotchi(t) == null) {
			createTamagotchi();
		} else {
			chargerPartie(t);
		}
		play();
	}
	
	//=================================================================================================================
	
	//TODO : Oldton
	public void play() {
		
		tamagotchi.setState(true);
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		Runnable perte = () -> {
			while(getState() == true) {
				tamagotchi.decreaseStat();
				if (tamagotchi.estMort() == true) {
					view.getGameView().afficherMsgMort();
				}
			}
		};	
		ex.execute(perte);
	}
	
	//=================================================================================================================
	
	public void enregistrer() {
		sauvegarde.sauvegarderV2(tamagotchi);
	}
	
	//=================================================================================================================
	
	//TODO : Oldton
	public boolean getState() {
		return tamagotchi.getState();
	}
	
	//TODO : Oldton
	public void setState(boolean b) {
		tamagotchi.setState(b);
	}

	
	
	//todo Linda
	public ArrayList<Tamagotchi> getTamagoSauvegardes() {
        return sauvegarde.getTamagotchisSauvegardes();
    }
	
	//=================================================================================================================
	
	public Tamagotchi getTamagotchi() {
		return tamagotchi;
		
	}
	
	public void setTamagotchi(Tamagotchi t) {
		this.tamagotchi = t;
	}
	
	public String getImagePiece() {
		return tamagotchi.getMaison().getPiece().getImage();
	}
	public void changerDePiece(Piece p) {
		tamagotchi.seDeplacer(p);
	}
	
	//TODO: Linda
	public String choisirEspece(Tamagotchi.Espece t) {
		
		return tamagotchi.getImageEspece();
		
	}
	//=================================================================================================================
	
	//todo Linda
	public void getdelete(Tamagotchi t) {
		sauvegarde.deleteTamagotchi(t);
	}
	
	//=================================================================================================================
	
	
	//APPELS AUX METHODES DE TYPE ACTION DU TAMAGOTCHI (jouer, regarder TV...)
	
	/*
	 * Methode qui execute une action en fonction de l'espece
	 * manger pour un Animal
	 * seRecharger pour un Robot
	 */
	public synchronized void manger_recharger() {
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
	public synchronized void dormir_veille() {
		if (getEspece().equals("Robot")) {
			((Robot)tamagotchi).enVeille();
		}else {	
			((Animal)tamagotchi).dormir();
		}
	}
	
	/*
	 * Execute la methode jouer
	 */
	public synchronized void jouer() {
		tamagotchi.jouer();
	}
	
	/*
	 * Execute la methode regarderTV
	 */
	public synchronized void regarderTV() {
		tamagotchi.regarderTV();
	}
	
	/*
	 * Execute la methode faireSport
	 */
	public synchronized void sport() {
		tamagotchi.faireSport();
	}
	
	/*
	 * Execute la methode jardinage
	 */
	public synchronized void jardiner() {
		tamagotchi.jardinage();
	}
	
	/*
	 * Execute la methode seLaver
	 */
	public synchronized void seLaver() {
		tamagotchi.seLaver();
	}
	
	/*
	 * Execute la methode brosserDent
	 */
	public synchronized void brosserDents() {
		tamagotchi.brosserDent();
	}
	
	/*
	 * Execute la methode seSoulager
	 */
	public synchronized void toilettes() {
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
		return null;		
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
