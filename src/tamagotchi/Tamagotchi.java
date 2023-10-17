package tamagotchi;

public abstract class Tamagotchi {

	private String nom ;
	private int vie;
	private int energie ;
	private int moral;
	private Lieu lieu ;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void seDeplacer(Lieu lieu) {
		this.lieu = lieu;
	}
	
	public abstract void regarderTV();
	
	public abstract void jouer();
	
	public abstract void jardinage();
	
	public abstract void sauvegarde();
	
}
