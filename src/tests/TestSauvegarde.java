package tests;

import java.io.IOException;

import controller.Sauvegarde;
import modele.*;
import view.View;




public class TestSauvegarde {

    public static void main(String[] args) throws IOException {
        // Crée une nouvelle instance de ChargerPartie
        Sauvegarde sauvegarde = new Sauvegarde(new View());

        //Crée quelques Tamagotchis et les sauvegarde
        Tamagotchi tama1 = new Lion("Lee");
        Tamagotchi tama2 = new Oiseau("Polly");
        Tamagotchi tama3 = new Robot("Aobbie");
        Tamagotchi tama4 = new Robot("Joe");

        sauvegarde.sauvegarderV2(tama1);
        //sauvegarde.fermerFlux();
        sauvegarde.sauvegarderV2(tama2);
        //sauvegarde.fermerFlux();
        sauvegarde.sauvegarderV2(tama3);
        //sauvegarde.fermerFlux();

        // Charge les Tamagotchis sauvegardés
        //sauvegarde.charger();
        sauvegarde.majSauvegarde();

        // Récupère la liste des Tamagotchis sauvegardés
        //ArrayList<Tamagotchi> tamagotchisSauvegardes = sauvegarde.getTamagotchisSauvegardes();

        // Affiche les Tamagotchis chargés
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : sauvegarde.getTamagotchisSauvegardes()) {
        	System.out.println(tamagotchi.getNom()+ ", Energie : " + tamagotchi.getEnergie());
        }
        
        
        
        //tama1.setNom("koko");
        tama1.setEnergie(20);
        sauvegarde.sauvegarderV2(tama1);
        sauvegarde.deleteTamagotchi(tama1);
        //sauvegarde.charger();
        sauvegarde.majSauvegarde();
        
        
        System.out.println("Tamagotchis chargés : ");
        for (Tamagotchi tamagotchi : sauvegarde.getTamagotchisSauvegardes()) {
            System.out.println(tamagotchi.getNom()+ ", Energie : " + tamagotchi.getEnergie());
        }
        
        
    }
}