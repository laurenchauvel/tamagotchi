package tests;

import java.io.IOException;

import controller.Sauvegarde;
import modele.Lion;
import modele.Oiseau;
import modele.Robot;
import modele.Tamagotchi;

public class TestSauvegarde {

    public static void main(String[] args) throws IOException {
        // Crée une nouvelle instance de ChargerPartie
        Sauvegarde sauvegarde = new Sauvegarde();

        //Crée quelques Tamagotchis et les sauvegarde
        Tamagotchi tama1 = new Lion("Lee");
        Tamagotchi tama2 = new Oiseau("Polly");
        Tamagotchi tama3 = new Robot("Aobbie");

        sauvegarde.sauvegarderV2(tama1);
        sauvegarde.sauvegarderV2(tama2);
        sauvegarde.sauvegarderV2(tama3);

        // Charge les Tamagotchis sauvegardés
        sauvegarde.majSauvegarde();

        // Affiche les Tamagotchis chargés
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : sauvegarde.getTamagotchisSauvegardes()) {
        	System.out.println(tamagotchi.getNom()+ ", Energie : " + tamagotchi.getEnergie());
        }
        
        tama1.setEnergie(20);
        sauvegarde.sauvegarderV2(tama1);
        sauvegarde.deleteTamagotchi(tama1);
        sauvegarde.majSauvegarde();
        
        
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : sauvegarde.getTamagotchisSauvegardes()) {
            System.out.println(tamagotchi.getNom()+ ", Energie : " + tamagotchi.getEnergie());
        }
        
        
    }
}