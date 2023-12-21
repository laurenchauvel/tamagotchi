package controller;

import java.util.Scanner;
//import java.util.concurrent.Executor; //inutile avec serivce qui est plus complet
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import modele.*;
import view.*;

public class Controller {
	
	
	private Tamagotchi tamagotchi; //modele
	
	private View view; //view
	
	private Sauvegarde sauvegarde; //modele
	
	private boolean enCours; //indique si une partie est en cours
	
	private Scanner scan;
	
	public Controller()  {
		enCours = true;
		scan = new Scanner(System.in);
		switch(scan.nextInt()) {
		case 1:
			tamagotchi = new Chien("Chien");
			break;
			
		case 2:
			tamagotchi = new Lion("Lion");
			break;
			
		case 3:
			tamagotchi = new Oiseau("Oiseau");
			break;
			
		case 4:
			tamagotchi = new Robot("Robot");
			break;
			
		default:
            System.out.println("Choix non valide.");
            System.exit(0);
		}
		
	}
	
	public void play() {
		
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
	
	public void newGame() {
		enCours = true;
	}
	
	
	
    public static void main(String[] args) {
    	
        System.out.println("Bienvenue dans le jeu Tamagotchi!");
        System.out.println("Veuillez choisir un Tamagotchi:");
        System.out.println("1. Chien");
        System.out.println("2. Lion");
        System.out.println("3. Oiseau");
        System.out.println("4. Robot");
      

        //int choix = scanner.nextInt();
        
        Controller test = new Controller();
        

        System.out.println("Vous avez choisi: " + test.tamagotchi.getNom());
        
       
        System.out.println("Entrez le nom de votre Tamagotchi");
        String nom = test.scan.next();
        test.tamagotchi.setNom(nom);
        System.out.println("Le Tamagotchi s'appelle desormais: " + test.tamagotchi.getNom());
        
        
        test.play(); //lancement du jeu
        
        String line = test.scan.next();
        	
        while(!line.equals(".") && line != null) {
        	switch(line) {
        	case "j":
        		test.tamagotchi.jouer();
        		System.out.println(test.tamagotchi.getEnergie());
        		break;
        		
        	case "jardinage":
        		test.tamagotchi.jardinage();
        		System.out.println("XXXXXXXXXXXXXX " + test.tamagotchi.getEnergie());
        		break;
        		
        	}
        	line = test.scan.next();
        	
        }
       
        test.scan.close();
        
        
        
      
       
    }
    
}