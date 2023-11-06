package tamagotchi;

public abstract class Tamagotchi {

	/**
	 * attributs
	 */

	private String nom ;
	private int vie;
	private int energie ;
	private int moral;
	private Lieu lieu ;
	private Sauvegarde sauvegarde;

	//=================================================================================================================

	/**
	 * le Constructeur
	 */

	public Tamagotchi(String n , Lieu l) {
		setNom(n);
		setVie(100);
		setEnergie(100);
		setMoral(100);
		seDeplacer(l);
	}
	//=================================================================================================================

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
	
	public abstract void regarderTV(int n);
	
	public abstract void jouer(int n);
	
	public abstract void jardinage(int n);
	
	public abstract void sauvegarde();

	//=================================================================================================================

	/**
	 * methode optionnelles
	 */

	//methode mise a jour de Moral
	public void majMoral(int n) {
		if (n > 0) {
			if (getMoral() + n <= 100) {
				setMoral(getMoral() + n);
			} else {
				setMoral(100);
			}
		} else {
			if (getMoral() - n >= 0) {
				setMoral(getMoral() - n);
			} else {
				setMoral(0);
			}
		}
	}

	//=================================================================================================================

	//methode mise a jour de Energie
	public void majEnergie(int n) {
		if (n > 0) {
			if (getEnergie() + n <= 100) {
				setEnergie(getEnergie() + n);
			} else {
				setEnergie(100);
			}
		} else {
			if (getEnergie() - n >= 0) {
				setEnergie(getEnergie() - n);
			} else {
				setEnergie(0);
			}
		}
	}
	
}
