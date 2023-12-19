package tamagotchi;

import java.util.Scanner;
import java.io.*;
import tamagotchi.Lieu.Piece;
import java.util.concurrent.Executors;
//import java.util.concurrent.Executor; //inutile avec serivce qui est plus complet
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future; //peut servir plus tard

public class Game {
	
	private int choix;
	
	private Tamagotchi tamagotchi;
	
	private static boolean enCours;
	
	public Game(int c) {
		enCours = true;
		choix = c;
		switch(choix) {
		case 1:
			tamagotchi = new Chien("Chien",new Lieu(Piece.Chambre,null,null));
			break;
			
		case 2:
			tamagotchi = new Chien("Lion",new Lieu(Piece.Chambre,null,null));
			break;
			
		case 3:
			tamagotchi = new Chien("Oiseau",new Lieu(Piece.Chambre,null,null));
			break;
			
		case 4:
			tamagotchi = new Chien("Robot",new Lieu(Piece.Chambre,null,null));
			break;
			
		default:
            System.out.println("Choix non valide.");
            System.exit(0);
		}
	}
	
	public void play() {
		
		/*
			//lancer la perte de vie
			new Thread(new Runnable() {
				public void run() {
					while(enCours) {
						tamagotchi.mourirDeVieillesse();
						if (tamagotchi.estMort()) {
							enCours = false;
						}
					}
				}
			}).start();
			
			//lancer la perte de morale
			new Thread(new Runnable() {
				public void run() {
					while(enCours) {
						tamagotchi.mourirDeDepression();
					}
				}
			}).start();
			*/
		
			ExecutorService ex = Executors.newCachedThreadPool();
			
			Runnable pv = () -> {
				while(enCours) {
					tamagotchi.mourirDeVieillesse();
					if (tamagotchi.estMort()) {
						enCours = false;
					}
				}
			};
			
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
	
	
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu Tamagotchi!");
        System.out.println("Veuillez choisir un Tamagotchi:");
        System.out.println("1. Chien");
        System.out.println("2. Lion");
        System.out.println("3. Oiseau");
        System.out.println("4. Robot");
      

        int choix = scanner.nextInt();
        
        Game test = new Game(choix);
        

        System.out.println("V"
        		+ "ous avez choisi: " + test.tamagotchi.getClass());
        
       
        System.out.println("Entrez le nom de votre Tamagotchi");
        String nom = scanner.next();
        test.tamagotchi.setNom(nom);
        System.out.println("Le Tamagotchi s'appelle desormais: " + test.tamagotchi.getNom());
        
        
        test.play(); //lancement du jeu
        
        String line = scanner.next();
        	
        while(!line.equals(".") && line != null) {
        	switch(line) {
        	case "jouer":
        		test.tamagotchi.jouer();
        		System.out.println(test.tamagotchi.getEnergie());
        		break;
        		
        	case "jardinage":
        		test.tamagotchi.jardinage();
        		System.out.println("XXXXXXXXXXXXXX " + test.tamagotchi.getEnergie());
        		break;
        		
        	}
        	line = scanner.next();
        	try {
        		Thread.sleep(5000);
        	} catch (InterruptedException e) {
        		line = null;
        	}
        }
       
        scanner.close();
        
        
        
      
       
    }
    
}