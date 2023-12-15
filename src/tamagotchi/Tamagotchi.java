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
	
	public abstract void regarderTV();
	
	public abstract void jouer();
	
	public abstract void jardinage();
	
	public abstract void sauvegarde();

	//=================================================================================================================

	/**
	 * methode optionnelles
	 */
	
	//methode mise a jour de la vie
	public void majVie(int n) {
		if (n > 0) {
			if (getVie() + n <= 100) {
				setVie(getVie() + n);
			} else {
				setVie(100);
			}
		} else {
			if (getVie() + n >= 0) {
				setVie(getVie() + n);
			} else {
				setVie(0);
			}
		}
	}
	
	//=================================================================================================================

	//methode mise a jour de Moral
	public void majMoral(int n) {
		if (n > 0) {
			if (getMoral() + n <= 100) {
				setMoral(getMoral() + n);
			} else {
				setMoral(100);
			}
		} else {
			if (getMoral() + n >= 0) {
				setMoral(getMoral() + n);
			} else {
				setMoral(0);
			}
		}
	}

	//==============================false===================================================================================

	//methode mise a jour de Energie
	public void majEnergie(int n) {
		if (n > 0) {
			if (getEnergie() + n <= 100) {
				setEnergie(getEnergie() + n);
			} else {
				setEnergie(100);
			}
		} else {
			if (getEnergie() + n >= 0) {
				setEnergie(getEnergie() + n);
			} else {
				setEnergie(0);
			}
		}
	}
	
	//=================================================================================================================
	
	/*
	 * a mettre dans le main
	 */
	//methode utile pour la perte de vie progressive
	public static void wait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
	//=================================================================================================================
	
	//methode de perte de vie
	/*
	 * toutes les 180 sec , le tamagotchi perd 1 pv
	 * si on ne s'occupe pas de lui il meurt au bout de 5h
	 */
	public void perteDeVie() {
		while(!estMort()) {
			majVie(-1);
			System.out.println(getNom() + " : " +getVie());
			wait(180);
		}
	}
	
	
	//=================================================================================================================
	
	//methode perte de vie progressive
	public void mourirDeVieillesse() {
		perteDeVie();
		if (estMort()) {
			System.out.println(getNom() + " a succombé au poids de sa pauvre existence");
		}
	}
	
	//=================================================================================================================
	
	//methode qui signale si le tamagotchi est mort
	public boolean estMort() {
		if (getVie() == 0) {
			return true;
		}
		return false;
	}
	
	//=================================================================================================================
	
	//methode perte de morale progressive
	public void perteDeMoral() {
		while(!pasDeMoral()) {
			majMoral(-2);
			System.out.println(getNom() + " : " + getMoral());
			wait(2);
		}
		if (pasDeMoral()) {
			System.out.println(getNom() + " n'est pas de bonne humeur");
		}
	}
	
	//=================================================================================================================
	
	//methode qui signale si le tamagotchi a du morale
	public boolean pasDeMoral() {
		if (getMoral() == 0) {
			return true;
		}
		return false;
	}
	
	//=================================================================================================================
	
	//methode pour mourir de depression
	public void mourirDeDepression() {
		while (pasDeMoral()) {
			perteDeVie();
		}
		if (estMort()) {
			System.out.println(getNom() + " a succombé face au poids de ses problemes");
		}
	}
	
	
	
	
	
	
	
	
	
	
}