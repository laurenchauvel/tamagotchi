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

public class Sauvegarde implements Serializable {

    private static final long serialVersionUID = 1L; //inutile
    
    private View view ;
    
    //test Oldton
    private final String dir = "src/not-user-dir/";
    //test Oldton fin
    
    //liste des tamagotchis sauvegardes
	private ArrayList<Tamagotchi> tamagotchisSauvegardes;
	
	//=================================================================================================================
	
	/*
	 * constructeur
	 */

    public Sauvegarde(View view) {
    	try {
    		this.view=view;
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
    
    public void ajouterSauvegarde(Tamagotchi t) {
    	tamagotchisSauvegardes.add(t);
    }
    
    //=================================================================================================================

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
        		System.out.println(t.getNom());
    		} else {
    			System.out.println("ECHEC");
    		}
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Erreur lors de la sauvegarde des Tamagotchis : " + e.getMessage());
        }
    }
    
    //=================================================================================================================
    
    //methode pour supprimer une partie
    public void deleteTamagotchi(Tamagotchi t) {
    	Path fichier = Paths.get(newFileName(t));
    	try {
    		Files.delete(fichier);
    		System.out.println("Le fichier a été supprimé avec succès.");
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
    	return findTamagotchi(t);
    }
    
    //=================================================================================================================
    
    //transformation de la reponse la view pour créer un nouveau tamagotchi
    public Tamagotchi nouvellePartie(String nom , String esp) {
    	Tamagotchi t = null;
    	switch(esp) {
    	
    	case "Chien":
    		sauvegarderV2(new Chien(nom));
    		t = findTamagotchi(new Chien(nom));
    		break;
    	
    	case "Lion":
    		sauvegarderV2(new Lion(nom));
    		t = findTamagotchi(new Lion(nom));
    		break;
    		
    	case "Oiseau":
    		sauvegarderV2(new Oiseau(nom));
    		t = findTamagotchi(new Oiseau(nom));
    		break;
    	
    	case "Robot":
    		sauvegarderV2(new Robot(nom));
    		t = findTamagotchi(new Robot(nom));
    		break;
    		
    	default:
    		return null;
    	}
    	t.ajouterObservateur(view.getGameView());	//TODO : Observateur
    	//maj de la liste
    	majSauvegarde();
    	//recuperation du dernier tamagotchi de la liste 
		return reprendrePartie(t);		
    }
    
    //=================================================================================================================
    
    //retourne le tamagotchi choisi
    public Tamagotchi equalsTamagotchi(String tamagotchi) {
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
    
    public Tamagotchi equalsTamagotchi(int index) {
    	return tamagotchisSauvegardes.get(index);
    }
    
    //=================================================================================================================
    
    
}