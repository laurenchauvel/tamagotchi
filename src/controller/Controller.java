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
		
		if (tamagotchi != null) {
			System.out.println("SUCCESS DE LA SAUVEGARDE");
			view.setGameView(new InterfaceJeuView(view));
			if (view.getGameView() != null) {
				System.out.println("VIEW NON NULL");
				tamagotchi.ajouterObservateur(view.getGameView());
			} else {
				System.out.println("VIEW NULL");
			}
			piece = tamagotchi.getPiece();
			play();
			//todo Linda
			sauvegarde.sauvegarder(tamagotchi);
		} else {
			System.out.println("ECHEC DE LA SAUVEGARDE");
		}
		
	}
	
	//=================================================================================================================
	
	//TODO : Oldton
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
			while(enCours) {
				tamagotchi.mourirDeDepression();
				if (tamagotchi.estMort()) {
					enCours = false;
				}
			}
		};
		
		//lance la perte des points d'hygiene
		Runnable ph = () -> {
			while(enCours) {
				tamagotchi.mourirParHygiene();
				if (tamagotchi.estMort()) {
					enCours = false;
				}
			}
		};
		
		//lance la perte d'energie
		Runnable pe = () -> {
			while(enCours) {
				tamagotchi.perteEnergie(-2, 3);
			}
		};
		
		//lance la perte des points de toielette
		Runnable pt = () -> {
			while(enCours) {
				tamagotchi.perteToilette(-1, 3);
			}
		};
		
		ex.execute(pv);
		ex.execute(pm);
		ex.execute(ph);
		ex.execute(pe);
		ex.execute(pt);
		
		if (tamagotchi instanceof Animal) {
			//lance la famine
			Runnable pn = () -> {
				while(enCours) {
					((Animal) tamagotchi).mourirDeMalNutrition();
					if (tamagotchi.estMort()) {
						enCours = false;
					}
				}
			};
			ex.execute(pn);
		}
		
		if (tamagotchi instanceof Robot) {
			//lance la perte de batterie
			Runnable pb = () -> {
				while(enCours) {
					((Robot) tamagotchi).dechargement();
					if (tamagotchi.estMort()) {
						enCours = false;
					}
				}
			};
			ex.execute(pb);
		}
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
	
	
	public String getImagePiece() {
		return tamagotchi.getMaison().getPiece().getImage();
	}
	public void changerDePiece(Piece p) {
		tamagotchi.seDeplacer(p);
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
	
	public Observateur getObservateur() {
		return view.getGameView();
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
