package tamagotchi;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ChargerPartie implements Serializable {

    private static final long serialVersionUID = 1L; //inutile
    
	private ArrayList<Tamagotchi> tamagotchisSauvegardes;

    public ChargerPartie() {
        tamagotchisSauvegardes = new ArrayList<>();
    }

    // Méthode pour charger les Tamagotchis sauvegardés
    public void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tamagotchis_sauvegardes.dat"))) {
            tamagotchisSauvegardes = (ArrayList<Tamagotchi>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des Tamagotchis sauvegardés : " + e.getMessage());
            tamagotchisSauvegardes = new ArrayList<>();  // Créer une nouvelle liste si le chargement échoue
        }
    }

    // Méthode pour sauvegarder les Tamagotchis
    public void sauvegarder(Tamagotchi tamagotchi) {
        tamagotchisSauvegardes.add(tamagotchi);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tamagotchis_sauvegardes.dat"))) {
            oos.writeObject(tamagotchisSauvegardes);
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde des Tamagotchis : " + e.getMessage());
        }
    }

    // Méthode pour obtenir la liste des Tamagotchis sauvegardés
    public ArrayList<Tamagotchi> getTamagotchisSauvegardes() {
        return tamagotchisSauvegardes;
    }
}
