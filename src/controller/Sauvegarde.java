package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import modele.Chien;
import modele.Lion;
import modele.Oiseau;
import modele.Robot;
import modele.Tamagotchi;
import view.View;

@SuppressWarnings("serial")
public class Sauvegarde implements Serializable {

    //test Oldton
    private final String dir = "src/not-user-dir/";
    //test Oldton fin
    
    //liste des tamagotchis sauvegardes
	private ArrayList<Tamagotchi> tamagotchisSauvegardes;
	
	//=================================================================================================================
	
	/*
	 * constructeur
	 */

    public Sauvegarde() {
    	try {
	    	if (!Files.exists(Paths.get(dir)) && !Files.isDirectory(Paths.get(dir))) {
	        	Files.createDirectory(Paths.get(dir)); //creation du rep si il n'existe pas
	        }
	        tamagotchisSauvegardes = charger(); //recuper la liste la plus recente
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    //=================================================================================================================
    
    /*
     * les methodes
     */
    

    // Méthode pour obtenir la liste des Tamagotchis sauvegardés
    public ArrayList<Tamagotchi> getTamagotchisSauvegardes() {
        return tamagotchisSauvegardes;
    }
    
    //=================================================================================================================

    // Méthode pour obtenir la liste des Tamagotchis sauvegardés
    public Tamagotchi findTamagotchi(Tamagotchi t) {
    	majSauvegarde();
        for (Tamagotchi val : tamagotchisSauvegardes) {
        	if (val.equals(t)) {
        		return val;
        	}
        }
        return null;
    }
    
    //=================================================================================================================
    
    private String newFileName(Tamagotchi t) {
    	return dir + "/" + t.getNom() + "_" + t.getEspece() + ".dat";
    }
    
    //=================================================================================================================

    // Méthode pour sauvegarder les Tamagotchis
    public void sauvegarder(Tamagotchi t) {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newFileName(t)))) {
    		if (t != null) {
        		oos.writeObject(t);
        		oos.flush();
    		}
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    //=================================================================================================================
    
    //methode pour supprimer une partie
    public void deleteTamagotchi(Tamagotchi t) {
    	Path fichier = Paths.get(newFileName(t));
    	try {
    		Files.delete(fichier);
    	} catch (NoSuchFileException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	majSauvegarde();
    }
    
    //=================================================================================================================

    // Méthode pour sauvegarder les Tamagotchis
    public void sauvegarderV2(Tamagotchi t) {
    	if (findTamagotchi(t) == null) { //si il n'existe pas il est créé
    		sauvegarder(t);
    	} else {
    		//si le tamagotchi existe , il est supprimé puis recréé
    		deleteTamagotchi(t);
    		sauvegarder(t);
    		majSauvegarde();
    	}
    }
    
    //=================================================================================================================

    // Méthode pour charger la liste des Tamagotchis sauvegardés
    public ArrayList<Tamagotchi> charger() {
    	ArrayList<Tamagotchi> result = new ArrayList<Tamagotchi>();
    	File[] fichiers = new File(dir).listFiles(); //regarde toutes les entrees du rep
    	for (File f : fichiers) {
    		if (f.isFile()) {
    			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
    				result.add((Tamagotchi) ois.readObject());
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return result;
    }
    
    //=================================================================================================================
    
    //mise a jour de la liste
    public void majSauvegarde() {
    	tamagotchisSauvegardes = charger();
    }
    
    //=================================================================================================================
    
    //retourne le tamagotchi avec lequel la partie sera effectuée
    public Tamagotchi reprendrePartie(Tamagotchi t) {
    	return findTamagotchi(t);
    }
    
    //=================================================================================================================
    
    //transformation de la reponse la view pour créer un nouveau tamagotchi
    public Tamagotchi nouvellePartie(String nom , String esp) {
    	Tamagotchi tamagotchi = null;
    	switch(esp) {
    	
    	case "Chien":
    		tamagotchi = new Chien(nom);
    		break;
    	
    	case "Lion":
    		tamagotchi = new Lion(nom);
    		break;
    		
    	case "Oiseau":
    		tamagotchi = new Oiseau(nom);
    		break;
    	
    	case "Robot":
    		tamagotchi = new Robot(nom);
    		break;
    		
    	default:
    		return null;
    	}
    	sauvegarderV2(tamagotchi);
    	//maj de la liste
    	majSauvegarde();
    	//recuperation du dernier tamagotchi de la liste 
		return reprendrePartie(tamagotchi);		
    }
    
    //=================================================================================================================
    
    /*
     * Return true si le nom donné existe déjà pour un autre Tamagotchi
     */
    public boolean compareNames(String name) {
    	majSauvegarde();
    	boolean trouve = false ;
    	for(Tamagotchi t : tamagotchisSauvegardes) {
    		if(t.getNom().equals(name)) {
    			trouve = true ;
    		}
    	}
		return trouve;
    }
    
}