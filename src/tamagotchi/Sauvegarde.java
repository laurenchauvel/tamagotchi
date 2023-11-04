package tamagotchi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sauvegarde {

  public static void sauvegarder(Tamagotchi tamagotchi, String fichier) {
        try {
            //flux de sortie de fichier pour écrire des données dans un fichier
            FileOutputStream fileOutputStream = new FileOutputStream(fichier);
            //flux d'objet qui utilise le flux de sortie de fichier pour sérialiser l'objet Tamagotchi
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Écrit l'objet Tamagotchi dans le flux d'objet
            objectOutputStream.writeObject(tamagotchi);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Tamagotchi sauvegardé avec succès dans " + fichier);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la sauvegarde du Tamagotchi : " + e.getMessage());
        }
    }

  public static void sauvegardeAutomatique(Tamagotchi tamagotchi, String fichier) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // exécuté lors de la fermeture de l'application
            sauvegarderTamagotchi(tamagotchi, fichier);
        }));
    }

}
