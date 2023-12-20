package tamagotchi;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import tamagotchi.Tamagotchi;

public class Controleur {
    private List<Tamagotchi> tamagotchis;
    public enum Espece {
        ANIMAL,
        ROBOT,
    }
    
    public Controleur() {
        this.tamagotchis = new ArrayList<>();
        // Peut-être initialiser la sélection ici ou laisser null et créer lors de nouvellePartie()
    }
    public void addTamagotchi(Tamagotchi tamagotchi) {
        tamagotchis.add(tamagotchi);
    }
    public void nouvellePartie() {
        // Réinitialisation de la liste des Tamagotchis pour une nouvelle partie
        tamagotchis.clear();

    }

public void chargerPartie() {
    // Logique pour charger une partie sauvegardée

    String fichierSauvegarde = "sauvegarde.txt"; // Nom du fichier de sauvegarde

    // Création des fichiers File nécessaires pour le lieu
    File imageJardin = new File("/home/salma/Downloads/jardin.jpg");
    File sonJardin = new File("/home/salma/Downloads/jardin.mp3");

    // Création du lieu avec les bons arguments
    Maison jardinCharge = new Maison(Piece.JARDIN, imageJardin, sonJardin);

    // Ajout du Tamagotchi chargé avec le lieu créé
    tamagotchis.clear();
    tamagotchis.add(new Chien("RexChargé", jardinCharge));
}



    public void sauvegarderPartie() {
        // Exemple de sauvegarde du premier Tamagotchi
        if (!tamagotchis.isEmpty()) {
            Sauvegarde.sauvegarder(tamagotchis.get(0), "sauvegarde.txt");
        }
    }

    public void quitter() {
        System.exit(0);
    }

    // Méthodes pour accéder et manipuler les Tamagotchis
    public List<Tamagotchi> getTamagotchis() {
        return tamagotchis;
    }
}
