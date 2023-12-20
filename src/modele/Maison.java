package modele;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Maison implements Serializable { //public class maison
	
	private static final long serialVersionUID = 1L; //inutile

	//Les differentes pieces du jeu
	public enum Piece{
		Salon(new File("../media/salon-image.avif"), new File("../media/menu-musique.wav")),
		Chambre(new File("../media/chambre-image.avif"), new File("../media/menu-musique.wav")),
		Cuisine(new File("../media/cuisine-image.avif"), new File("../media/menu-musique.wav")),
		SDB(new File("../media/sdb-image.avif"), new File("../media/menu-musique.wav")),  //SDB = Salle de bain
		Jardin(new File("../media/jardin-image.jpeg"), new File("../media/menu-musique.wav"));
		
		//attributs d'une piece
		private File image;
		private File son;
		
		//=================================================================================================================
		
		//constructeur
		private Piece(File i , File s) {
			this.image = i;
			this.son = s;
		}
		
		//=================================================================================================================
		
		//getter image
		public File getImage() {
			return image;
		}
		
		//getter son
		public File getSon() {
			return son;
		}
	};
	
	//=================================================================================================================

	//Piece courante
	private Piece piece;
	
	//ensemble des pieces dans lesquelles le tamagotchi vivra
	private ArrayList<Piece> toutesLespieces;
	 
	
	//=================================================================================================================
	
	/**
	 * Constructeur de la classe Lieu
	 */
	public Maison (){
		this.toutesLespieces = new ArrayList<Piece>();
		/*
		 * maison créée avec toutes les pieces
		 */
		this.toutesLespieces.add(Piece.Salon);
		this.toutesLespieces.add(Piece.Chambre);
		this.toutesLespieces.add(Piece.Cuisine);
		this.toutesLespieces.add(Piece.SDB);
		this.toutesLespieces.add(Piece.Jardin);
		this.piece = toutesLespieces.get(0); //le salon par defaut
	}
	
	//=================================================================================================================
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	//=================================================================================================================

	public ArrayList<Piece> getToutesLesPieces() {
		return toutesLespieces;
	}
	
	public void addPiece(Piece p) {
		toutesLespieces.add(p);
	}
	
}
