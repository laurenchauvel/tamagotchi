package tests;

import java.util.ArrayList;

import modele.*;
import modele.Maison.Piece;


public class TestSauvegarde {

    public static void main(String[] args) {
        // Crée une nouvelle instance de ChargerPartie
        Sauvegarde chargerPartie = new Sauvegarde();

        //Crée quelques Tamagotchis et les sauvegarde
        Tamagotchi tama1 = new Lion("Lee");
        Tamagotchi tama2 = new Oiseau("Polly");
        Tamagotchi tama3 = new Robot("Robbie");
        Tamagotchi tama4 = new Robot("Joe");

        chargerPartie.sauvegarder(tama1);
        chargerPartie.sauvegarder(tama2);
        chargerPartie.sauvegarder(tama3);

        // Charge les Tamagotchis sauvegardés
        //chargerPartie.charger();

        // Récupère la liste des Tamagotchis sauvegardés
        //ArrayList<Tamagotchi> tamagotchisSauvegardes = chargerPartie.getTamagotchisSauvegardes();

        // Affiche les Tamagotchis chargés
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : chargerPartie.getTamagotchisSauvegardes()) {
            System.out.println(tamagotchi.getNom());
        }
        
        chargerPartie.sauvegarder(tama4);
        //chargerPartie.charger();
        
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : chargerPartie.getTamagotchisSauvegardes()) {
            System.out.println(tamagotchi.getNom());
        }
        
    }
}
