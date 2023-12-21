package modele;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Maison implements Serializable { //public class maison
	
	private static final long serialVersionUID = 1L; //inutile

	//Les differentes pieces du jeu
	public enum Piece{
		
		Salon("Salon",new File("../media/salon-image.avif")),
		Chambre("Chambre",new File("../media/chambre-image.avif")),
		Cuisine("Cuisine",new File("../media/cuisine-image.avif")),
		SDB("SDB", new File("../media/sdb-image.avif")),  //SDB = Salle de bain
		Jardin("Jardin", new File("../media/jardin-image.jpeg"));
		
		private final String name ;
		
		//attributs d'une piece
		private File image;
		
		
		//=================================================================================================================
		
		//constructeur
		private Piece(String name, File i) {
			this.name=name;
			this.image = i;
		}
		
		//=================================================================================================================
		
		public String getName() {
			return name;
		}
		
		//getter image
		public File getImage() {
			return image;
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
