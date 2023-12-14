package tamagotchi;

import java.io.File;
import java.util.ArrayList;

public class Lieu {
	
	//Les differentes pieces du jeu
	public enum Piece{Chambre, Salon, Cuisine, SDB, Jardin} ;	//SDB = Salle de bain
	
	//Piece courante
	private Piece piece;
	
	//L'image associée à ce lieu
	private File image;
	
	//Le son associé à ce lieu
	private File son;
	
	//Les voisins du lieu courant
	private ArrayList<Lieu> voisins;
	
	/**
	 * Constructeur de la classe Lieu
	 */
	public Lieu (Piece piece, File image, File son){
		this.piece=piece;
		this.image = image;
		this.son=son;
		this.voisins=new ArrayList<Lieu>();
	} 
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getSon() {
		return son;
	}

	public void setSon(File son) {
		this.son = son;
	}

	public ArrayList<Lieu> getVoisins() {
		return voisins;
	}
	
	public void addVoisin(Lieu lieu) {
		voisins.add(lieu);
	}
	
}
