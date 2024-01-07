package modele;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import view.Observateur;

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
	//enum avec les differents cris
    public enum Cri {
    	Aboyer(new File("../media/cri-chien.wav")),
    	Rugir(new File("../media/cri-lion.wav")),
    	Chanter(new File("../media/cri-oiseau-2.wav")),
    	ORDI(new File("../media/musique-nintendo-utile.mp3"));
    	
    	//attribut du fichier son pour le cri
        private File son;
        
        //=================================================================================================================
        
        /*
         * constructeur
         */
    	private Cri(File s) {
    		son = s;
    	}
    	
    	//=================================================================================================================
    	
    	public File getSon() {
    		return son;
    	}
    };

	private ArrayList<Observateur> observateurs = new ArrayList<Observateur>();	//TODO : Observateur
    
	//attribut de l'espece
	private Espece espece;
	
    //attribut du cri de l'animal
    private Cri cri;
	
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
		maison = new Maison();
		piece = maison.getPiece();
	}
	
	//=================================================================================================================
	//METHODES
	//=================================================================================================================
	
	public void ajouterObservateur(Observateur observateur) {
        observateurs.add(observateur);
        System.out.println("Observateur ajoute");
    }
	
	public void notifierObservateurs() {
		
		if(observateurs.isEmpty()) {
			System.out.println("MAJ : appel de notifierObservateurs dans la classe Tamagotchi");
		}
        for (Observateur observateur : observateurs) {
            observateur.mettreAJour();
        }
    }
	
	
	
	//=================================================================================================================

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		notifierObservateurs();	//TODO : Observateur (j'ai ajouyé cette ligne dans tous les setters)
	}
	
	//=================================================================================================================

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
		notifierObservateurs();
	}
	
	//=================================================================================================================

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		System.out.println("Hereee");
		this.energie = energie;
		notifierObservateurs();
	}
	
	//=================================================================================================================

    //getter toilette
    public int getToilette() {
        return toilette;
    }

    //setter toilette
    public void setToilette(int n) {
        toilette = n;
        notifierObservateurs();
    }
	
	//=================================================================================================================

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
		notifierObservateurs();
	}
	
	//=================================================================================================================

    //getter hygiene
    public int getHygiene() {
        return hygiene;
    }

    //setter hygiene
    public void setHygiene(int n) {
        hygiene = n;
        notifierObservateurs();
    }
    
    //=================================================================================================================

    //getter cri
    public Cri getCri() {
        return cri;
    }

    //setter cri
    public void setCri(Cri cri) {
        this.cri = cri;
        notifierObservateurs();
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
		this.maison.setPiece(p); //plus simple de juste garder cette ligne
		notifierObservateurs();
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
    	if (t.getNom().equals(this.getNom()) && t.getEspece().equals(this.getEspece())) {
    		return true;
    	}
    	return false;
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
    
    //=================================================================================================================
    
    //methode qui signale si le tamagotchi veut se soulager
    public boolean doitSeSoulager() {
    	if (getToilette() < 5) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
     
    //methode pour la perte de la reserve des toilettes
    /*
	 * t la decrementaion des toilettes toutes les s secondes
	 */
    public void perteToilette(int t, int s) {
    	while(!doitSeSoulager()) {
    		majToilette(t);
    		wait(s);
    	}
    	if (doitSeSoulager()) {
			System.out.println(getNom() + " sens que sa vessie va exploser");
		}
    }
  
    
	
	//Linda
    public String getImageEspece() {
        
        return this.espece.getImage();
    }
    
    public void setEspece(Espece e) {
    	this.espece = e;
    }
    
}