package modele;

import java.io.Serializable;
import modele.Maison.Piece;

public abstract class Tamagotchi implements Serializable {

	private static final long serialVersionUID = 1L; //inutile

	/**
	 * attributs
	 */
	//enum avec les differents Espece 
	public enum Espece {
		Chien("/media/chien.png"),
        Oiseau("/media/oiseau.png"),
        Lion("/media/lion.png"),
        Robot("/media/robot.png");


	    private final String image;

	    private Espece(String imgPath) {
            this.image = imgPath;
        }

        public String getImage() {
            return image;
        }
	};
	
    
    //
    private boolean enCours;

    
	//attribut de l'espece
	private Espece espece;
	
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
	
	//attribut toielette
    private int toilette;

	
	//attribut representant la maison de chaque tamagotchi
	private Maison maison ;
	
	//attribut pour sa piece courante
	private Piece piece;
	
	//
	private long minuteur;

	//=================================================================================================================

	/**
	 * le Constructeur
	 */

	public Tamagotchi(String n) {
		setNom(n);
		setVie(100);
		setEnergie(100);
		setMoral(100);
		setHygiene(100);
		setToilette(100);
		setMinuteur(180);
		maison = new Maison();
		piece = maison.getPiece();
	}
	
	//=================================================================================================================
	//METHODES
	//=================================================================================================================
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//=================================================================================================================

	public boolean getState() {
		return enCours;
	}

	public void setState(boolean b) {
		this.enCours = b;
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

    //getter toilette
    public int getToilette() {
        return toilette;
    }

    //setter toilette
    public void setToilette(int n) {
        toilette = n;
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
    
  	public long getMinuteur() {
  		return minuteur;
  	}

  	public void setMinuteur(long m) {
  		this.minuteur = m;
  	}
  	
  	//=================================================================================================================

    //getter piece courange
    public Piece getPiece() {
        return piece;
    }
	
	//=================================================================================================================

	public Maison getMaison() {
		return maison;
	}

	public void seDeplacer(Piece p) {
		this.maison.setPiece(p); 
	}
	
	//=================================================================================================================
    
    public String getEspece() {
    	String result = null;
    	if (this instanceof Animal) {
    		if (this instanceof Chien) {
    			result = "Chien";
    			}
    		else if (this instanceof Lion) {
    			result = "Lion";
    			}
    		else if (this instanceof Oiseau) {
    			result = "Oiseau";
    		}
    	} else {
    		result = "Robot";
    	}
    	return result;
    }
    
    //=================================================================================================================
    
    //definit si 2 tamagotchis soient egaux
    public boolean equals(Tamagotchi t) {
    	boolean result = false;
    	if (t != null) {
    		if (t.getNom().equals(this.getNom()) && t.getEspece().equals(this.getEspece())) {
        		result = true;
        	}
    	}
    	return result;
    }
	
	//=================================================================================================================
	
	public abstract void regarderTV();
	
	public abstract void jouer();
	
	public abstract void jardinage();
	
	public abstract void faireSport();
	
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

    //methode mise a jour de toilette
    public void majToilette(int n) {
        if (n > 0) {
            if (getToilette() + n <= 100) {
                setToilette(getToilette() + n);
            } else {
                setToilette(100);
            }
        } else {
            if (getToilette() + n >= 0) {
                setToilette(getToilette() + n);
            } else {
                setToilette(0);
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

    public void brosserDent() {
        majHygiene(40);
    }

    
    //=================================================================================================================

    //methode pour se laver
    public void seLaver() {
        majHygiene(60);
    }
    
    //=================================================================================================================
    
    public void seSoulager() {
    	majToilette(50);
    	majHygiene(15);
    }
    
    //=================================================================================================================
	
	/*
	 * methode utile pour la perte de vie progressive
	 */
	public static void wait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e){
			e.printStackTrace();
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
	
	//methode qui signale si le tamagotchi a du morale
	public boolean pasDeMoral() {
		if (getMoral() == 0) {
			return true;
		}
		return false;
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
    
    //methode qui signale si le tamagotchi est sale
    public boolean estFatigue() {
    	if (getEnergie() < 10) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
    
    //methode qui signale si le tamagotchi veut se soulager
    public boolean doitSeSoulager() {
    	if (getToilette() < 5) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
    
    public void decreaseMinuteur() {
    	minuteur -= 1;
    	if (getMinuteur() == 0) {
    		setMinuteur(180);
    	}
    }
    
    //=================================================================================================================
    
    /*
     * perte de vie si les autres attributs sont vides
     */
    public void decreaseStat() {
		while (getState() == true) {
			decreaseMinuteur();
			//perte de vie
    		if (getMinuteur() % 180 == 0) {
        		majVie(-1);	
        	}
    		//perte moral
        	if (getMinuteur() % 60 == 0) {     		
        		if (pasDeMoral() == true) {
        			majVie(-1);
        		} else {
        			majMoral(-1);
        		}
        	}
        	//perte hygiene
        	if (getMinuteur() % 90 == 0) {
        		if (estSale() == true) {
        			majVie(-1);
        		} else {
        			majHygiene(-1);
        		}
        	}
        	//perte toilette
        	if (getMinuteur() % 20 == 0) {
        		if (doitSeSoulager() == true) {
        			majVie(-1);
        		} else {
        			majToilette(-1);
        		}
        	}
        	//perte energie
        	if (getMinuteur() % 30 == 0) {
        		if (estFatigue() == true) {
        			majVie(-1);
        		} else {
        			majEnergie(-1);
        		}
        	}
        	//perte nourriture
        	if (getMinuteur() % 45 == 0) {
        		if (this instanceof Robot) {
        			if (((Robot)this).estDecharge() == true) {
        				majVie(-1);
        			} else {
        				((Robot)this).majBatterie(-1);
        			}
        		}
        		if (this instanceof Animal) {
        			if (((Animal)this).estAffame() == true) {
        				majVie(-1);
        			} else {
        				((Animal)this).majNourriture(-1);
        			}
            	}
        	}
        	if (estMort() == true) {
        		setState(false);
        	}
        	wait(1);
    	}
    }
  
	//=================================================================================================================
	
    public String getImageEspece() {
    	return this.espece.getImage();
    }
    
    public void setEspece(Espece e) {
    	this.espece = e;
    }
    
}