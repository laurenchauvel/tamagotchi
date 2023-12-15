package tamagotchi;

import java.util.Scanner;
import java.io.*;
import tamagotchi.Lieu.Piece;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu Tamagotchi!");
        System.out.println("Veuillez choisir un Tamagotchi:");
        System.out.println("1. Chien");
        System.out.println("2. Lion");
        System.out.println("3. Oiseau");
        System.out.println("4. Robot");
      

        int choix = scanner.nextInt();
        Tamagotchi tamagotchi = null;
        File image = null;
        File son = null;
        Lieu l = new Lieu(Piece.Chambre, image, son);
        switch (choix) {
        
        	case 1:
        	
            tamagotchi = new Chien("Chien", l);
            break;
            
            case 2:
            	
                tamagotchi = new Lion("Lion", l);
                break;
            case 3:
                tamagotchi = new Oiseau("Oiseau", l);
                break;
                
            case 4:
                tamagotchi = new Robot("Robot", l);
                break;
            
            default:
                System.out.println("Choix non valide.");
                System.exit(0);
        }

        System.out.println("Vous avez choisi: " + tamagotchi.getNom());
        
       
        System.out.println("Entrez le nom de votre Tamagotchi");
        String nom = scanner.next();
        tamagotchi.setNom(nom);
        System.out.println("Le Tamagotchi s'appelle desormais: " + tamagotchi.getNom());
        
        
        scanner.close();
    }
}