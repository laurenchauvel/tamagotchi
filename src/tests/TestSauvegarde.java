package tests;

import java.util.ArrayList;

import modele.*;
import modele.Maison.Piece;


public class TestSauvegarde {

    public static void main(String[] args) {
        // Crée une nouvelle instance de ChargerPartie
        Sauvegarde sauvegarde = new Sauvegarde();

        //Crée quelques Tamagotchis et les sauvegarde
        Tamagotchi tama1 = new Lion("Lee");
        Tamagotchi tama2 = new Oiseau("Polly");
        Tamagotchi tama3 = new Robot("Robbie");
        Tamagotchi tama4 = new Robot("Joe");

        sauvegarde.sauvegarder(tama1);
        sauvegarde.sauvegarder(tama2);
        sauvegarde.sauvegarder(tama3);

        // Charge les Tamagotchis sauvegardés
        //sauvegarde.charger();

        // Récupère la liste des Tamagotchis sauvegardés
        //ArrayList<Tamagotchi> tamagotchisSauvegardes = sauvegarde.getTamagotchisSauvegardes();

        // Affiche les Tamagotchis chargés
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : sauvegarde.getTamagotchisSauvegardes()) {
            System.out.println(tamagotchi.getNom());
        }
        
        tama1.setNom("koko");
        //sauvegarde.sauvegarder(tama1);
        //sauvegarde.charger();
        
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : sauvegarde.getTamagotchisSauvegardes()) {
            System.out.println(tamagotchi.getNom());
        }
        
    }
}
