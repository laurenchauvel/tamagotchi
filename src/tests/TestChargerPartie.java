package tests;

import java.util.ArrayList;

import tamagotchi.*;
import tamagotchi.Maison.Piece;


public class TestChargerPartie {

    public static void main(String[] args) {
        // Crée une nouvelle instance de ChargerPartie
        ChargerPartie chargerPartie = new ChargerPartie();

        //Crée quelques Tamagotchis et les sauvegarde
        Tamagotchi tama1 = new Lion("Leo");
        Tamagotchi tama2 = new Oiseau("Polly");
        Tamagotchi tama3 = new Robot("Robbie");

        chargerPartie.sauvegarder(tama1);
        chargerPartie.sauvegarder(tama2);
        chargerPartie.sauvegarder(tama3);

        // Charge les Tamagotchis sauvegardés
        chargerPartie.charger();

        // Récupère la liste des Tamagotchis sauvegardés
        ArrayList<Tamagotchi> tamagotchisSauvegardes = chargerPartie.getTamagotchisSauvegardes();

        // Affiche les Tamagotchis chargés
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : tamagotchisSauvegardes) {
            System.out.println(tamagotchi.getNom());
        }
    }
}
