package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Maison implements Serializable { //public class maison
	
	private static final long serialVersionUID = 1L; //inutile

	//Les differentes pieces du jeu
	public enum Piece{
		
		Salon("Salon","/media/salon.png"),
		Chambre("Chambre","/media/chambre.png"),
		Cuisine("Cuisine","/media/cuisine.png"),
		SDB("SDB","/media/salle de bain.png"),  //SDB = Salle de bain
		Jardin("Jardin","/media/Jardin.png");
		
		private final String name ;
		
		//attributs d'une piece
		private String image;
		
		
		//=================================================================================================================
		
		//constructeur
		private Piece(String name, String i) {
			this.name=name;
			this.image = i;
		}
		
		//=================================================================================================================
		
		public String getName() {
			return name;
		}
		
		//getter image
		public String getImage() {
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
