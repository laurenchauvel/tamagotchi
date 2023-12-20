package tamagotchi;

public abstract class Tamagotchi {

	/**
	 * attributs
	 */
	
	//attribut pour le nom
	private String nom ;
	
	//attribut hygiene
    private int hygiene;
    
    //attribut pour la vie
	private int vie;
	
	//attribut pour l'energie
	private int energie ;
	
	//attribut pour le moral
	private int moral;
	
	//attribut representant la maison de chaque tamagotchi
	private Maison maison ;
	
	//
	private Sauvegarde sauvegarde;

	//=================================================================================================================

	/**
	 * le Constructeur
	 */

	public Tamagotchi(String n) {
		setNom(n);
		setVie(100);
		setEnergie(100);
		setMoral(100);
		maison = new Maison();
	}
	
	//=================================================================================================================

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//=================================================================================================================

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	//=================================================================================================================

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	//=================================================================================================================

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
	}
	
	//=================================================================================================================

    //getter hygiene
    public int getHygiene() {
        return hygiene;
    }

    //setter hygiene
    public void setHygiene(int n) {
        hygiene = n;
    }
	
	//=================================================================================================================

	public Maison getMaison() {
		return maison;
	}

	public void seDeplacer(Maison.Piece p) {
		//a verifier , surement inutile
		for (Maison.Piece val : maison.getToutesLesPieces()) {
			if (val == p) {
				this.maison.setPiece(p); //plus simple de juste garder cette ligne
			}
		}
	}
	
	//=================================================================================================================
	
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

    //methode de mise a jour hygiene
    public void majHygiene(int n) {
        if (n > 0) {
            if (getHygiene() + n <= 100) {
                setHygiene(getHygiene() + n);
            } else {
                setHygiene(100);
            }
        } else {
            if (getHygiene() + n >= 0) {
                setHygiene(getHygiene() + n);
            } else {
                setHygiene(0);
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
	 * p le nombre de pv perdu
	 * s l'intervalle entre deux pertes
	 */
	public void perteDeVie(int p , int s) {
		while(!estMort()) {
			majVie(p);
			System.out.println(getNom() + " vie : " +getVie());
			wait(s);
		}
	}
	
	
	//=================================================================================================================
	
	//methode perte de vie progressive
	/*
	 *toutes les 180 sec , le tamagotchi perd 1 pv
	 * si on ne s'occupe pas de lui il meurt au bout de 5h
	 */
	public void mourirDeVieillesse() {
		perteDeVie(-3,2);
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
	/*
	 * m le nombre de points de morale qui baissent toutes les s secondes
	 */
	public void perteDeMoral(int m , int s) {
		while(!pasDeMoral()) {
			majMoral(m);
			//System.out.println(getNom() + " moral : " + getMoral());
			wait(s);
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
	/*
	 * perte de 1 pv par minute
	 * perte de 1 pm toutes les 2 secondes
	 */
	public void mourirDeDepression() {
		perteDeMoral(-2,2);
		if (pasDeMoral()) {
			System.out.println(getNom() + " n'est pas de bonne humeur");
			perteDeVie(-3,2);
		}
		if (estMort()) {
			System.out.println(getNom() + " a succombé face à ses problèmes");
		}
	}
	
	//=================================================================================================================
    
    //methode qui signale si le tamagotchi est sale
    public boolean estSale() {
    	if (getHygiene() == 0) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
    
    //methode pour perde des points d'hygiene
    /*
	 * h le nombre de points d'hygiene qui baissent toutes les s secondes
	 */
    public void perteHygiene(int h, int s) {
    	while(!estSale()) {
    		majHygiene(h);
    		wait(s);
    	}
    }
    
    //=================================================================================================================
    
    //methode pour mourir de manque d'hygiene
    /*
     * perte de 1 ph toutes les 5 secondes
     * pere de 1 pv toutes les 60 secondes
     */
    public void mourirParHygiene() {
    	perteHygiene(-1, 5);
    	if (estSale()) {
			System.out.println(getNom() + " est tout crade");
			perteDeVie(-1,60);
		}
		if (estMort()) {
			System.out.println(getNom() + " a succombé face à son insalubrité maladive");
		}
    }
    
//=================================================================================================================
    
    //methode qui signale si le tamagotchi est sale
    public boolean estFatigue() {
    	if (getEnergie() < 10) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
    
    //methode pour perde des points d'hygiene
    /*
	 * e le nombre de points d'hygiene qui baissent toutes les s secondes
	 */
    public void perteEnergie(int h, int s) {
    	while(!estFatigue()) {
    		majHygiene(h);
    		wait(s);
    	}
    	if (estFatigue()) {
    		System.out.println(getNom() + " est KO");
    	}
    }
    
	
	
	
	
	
	
	
	
	
	
}