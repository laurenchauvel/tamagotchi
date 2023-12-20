package modele;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sauvegarde implements Serializable {

    private static final long serialVersionUID = 1L; //inutile
    
    //attributs tamagotchi
    private Tamagotchi tamagotchi;
    
    //liste des tamagotchis sauvegardes
	private ArrayList<Tamagotchi> tamagotchisSauvegardes;
	
	//=================================================================================================================
	
	/*
	 * constructeur
	 */

    public Sauvegarde() {
        tamagotchisSauvegardes = new ArrayList<>();
    }
    
    //=================================================================================================================
    
    /*
     * les methodes
     */

    // Méthode pour charger la liste des Tamagotchis sauvegardés
    public void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tamagotchis_sauvegardes.dat"))) {
            tamagotchisSauvegardes = (ArrayList<Tamagotchi>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des Tamagotchis sauvegardés : " + e.getMessage());
            tamagotchisSauvegardes = new ArrayList<>();  // Créer une nouvelle liste si le chargement échoue
        }
    }
    
    //=================================================================================================================
    
    //methode pour fournir sous forme de string la liste des tamagotchis
    public String[] showTamagotchiSauvegardes() {
    	 String[] tamagotchisStrings = new String[tamagotchisSauvegardes.size()];
    	 for (int i = 0; i < tamagotchisSauvegardes.size(); i++) {
    	 tamagotchisStrings[i] = tamagotchisSauvegardes.get(i).getNom() + " | " + tamagotchisSauvegardes.get(i).getClass(); 
    	 }
    	 return tamagotchisStrings;
	}
    
    //=================================================================================================================
    
    //retourne le tamagotchi avec lequel la partie sera effectuée
    public Tamagotchi reprendrePartie(Tamagotchi t) {
    	//charger();
    	for (Tamagotchi val : tamagotchisSauvegardes) {
    		if ((val == t)) {
    			this.tamagotchi = val;
    			return this.tamagotchi;
    		}
    	}
    	return null;
    }
    
    //=================================================================================================================
    
    //retourne le tamagotchi choisi
    public Tamagotchi euqalsTamagotchi(String tamagotchi) {
    	 String[] parts = tamagotchi.split(" \\| ");
    	 String nom = parts[0];
    	 String type = parts[1];
    	 for(Tamagotchi t: tamagotchisSauvegardes) {
	    	 if(t.getNom().equals(nom) && t.getEspece().equals(type)) {
	    		 return t;
	    	 }
    	 }
    	 return null;
    }
    
    //=================================================================================================================
    
    public Tamagotchi euqalsTamagotchi(int index) {
    	return tamagotchisSauvegardes.get(index);
    }
    
    //=================================================================================================================

    // Méthode pour sauvegarder les Tamagotchis
    public void sauvegarder(Tamagotchi tamagotchi) {
        tamagotchisSauvegardes.add(tamagotchi);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tamagotchis_sauvegardes.dat"))) {
            oos.writeObject(tamagotchisSauvegardes);
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde des Tamagotchis : " + e.getMessage());
        }
    }
    
    //=================================================================================================================
    
    //transformation de la reponse la view pour créer un nouveau tamagotchi
    public Tamagotchi nouvellePartie(String nom , String esp) {
    	switch(esp) {
    	
    	case "Chien":
    		sauvegarder(new Chien(nom));
    		break;
    	
    	case "Lion":
    		sauvegarder(new Lion(nom));
    		break;
    		
    	case "Oiseau":
    		sauvegarder(new Oiseau(nom));
    		break;
    	
    	case "Robot":
    		sauvegarder(new Robot(nom));
    		break;
    		
    	default:
    		return null;
    	}
    	
    	//recuperation du dernier tamagotchi de la liste 
		return reprendrePartie(tamagotchisSauvegardes.get(tamagotchisSauvegardes.size()-1));		
    }

    // Méthode pour obtenir la liste des Tamagotchis sauvegardés
    public ArrayList<Tamagotchi> getTamagotchisSauvegardes() {
        return tamagotchisSauvegardes;
    }
}
