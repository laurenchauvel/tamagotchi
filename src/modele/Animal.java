package modele;

import java.io.*;

public abstract class Animal extends Tamagotchi {

    /**
     * les attributs
     */

    //attribut toielette
    private int toilette;

    //attribut nourriture
    private int nourriture;

    //enum avec les differents cris
    public enum Cri {
    	Aboyer(new File("../media/cri-chien.wav")),
    	Rugir(new File("../media/cri-lion.wav")),
    	Chanter(new File("../media/cri-oiseau-2.wav"));
    	
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

    //attribut du cri de l'animal
    private Cri cri;

    //=================================================================================================================

    /**
     * le Constructeur
     *
     * @param n
     */
    public Animal(String n) {
        super(n);
        setHygiene(100);
        setNourriture(100);
        setToilette(100);
    }

    //=================================================================================================================

    /**
     * les methodes
     */

    //getter nourriture
    public int getNourriture() {
        return nourriture;
    }

    //setter nourriture
    public void setNourriture(int n) {
        nourriture = n;
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

    //getter cri
    public Cri getCri() {
        return cri;
    }

    //setter cri
    public void setCri(Cri cri) {
        this.cri = cri;
    }

    //=================================================================================================================

    //methode mise a jour de nourriture
    public void majNourriture(int n) {
        if (n > 0) {
            if (getNourriture() + n <= 100) {
                setNourriture(getNourriture() + n);
            }
            else {
                setNourriture(100);
            }
        } else {
            if (getNourriture() + n >= 0) {
                setNourriture(getNourriture() + n);
            } else {
                setNourriture(0);
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

    //methode pour manger
    public void manger() {
        majNourriture(30);
        majEnergie(10);
    }

    //=================================================================================================================

    //methode pour se laver
    public void seLaver() {
        majHygiene(60);
    }

    //=================================================================================================================

    //methode pour faire du sport
    public void faireSport() {
        //maj energie
        if (getEnergie() > 20 && getNourriture() > 20) {
            majMoral(20);
            majNourriture(-20);
            majHygiene(-30);
            majEnergie(-20);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    public void brosserDent() {
        majHygiene(40);
    }

    //=================================================================================================================

    public void regarderTV() {
    	if (getNourriture() > 10) {
	        majMoral(15);
	        majEnergie(5);
	        majNourriture(-10);
	        majHygiene(-10);
    	} else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    //methode pour dormir
    public void dormir() {
    	majEnergie(20);
    }

    //=================================================================================================================

    public boolean equalsCri (Animal a) {
        boolean result = false;
        if (this.getCri() == a.getCri()) {
            result = true;
        }
        return result;
    }

    //=================================================================================================================

    @Override
    public void jardinage() {
        if (getEnergie() > 15 && getNourriture() > 20) {
            majMoral(15);
            majNourriture(-20);
            majEnergie(-15);
            majHygiene(-30);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================
    
    //Méthode jouer
    @Override
    public void jouer() {
        if (getEnergie() > 30 && getNourriture() > 20) {
            //changement positif
            majMoral(25);
            majNourriture(-20);
            majEnergie(-30);
            majHygiene(-20);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }
    
    //=================================================================================================================
    
    //methode qui signale si le tamagotchi a faim
    public boolean estAffame() {
    	if (getNourriture() < 15) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
    
    //methode pour la perte de nutrition
    /*
	 * n le nombre de points de nutrition qui baissent toutes les s secondes
	 */
    public void perteNourriture(int n, int s) {
    	while(!estAffame()) {
    		majNourriture(n);
    		wait(s);
    	}
    }
    
    //=================================================================================================================
    
    //methode pour mourir de malnutrition
    /*
     * perte de 1 pn toutes les 5 secondes
     * pere de 5 pv toutes les 180 secondes
     */
    public void mourirDeMalNutrition() {
    	perteNourriture(-1, 5);
    	if (estAffame()) {
			System.out.println(getNom() + " est affamé");
			perteDeVie(-5,180);
		}
    	if (estMort()) {
			System.out.println(getNom() + " a succombé face à la brutalité du manque soudain de vivres !!!!");
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
  
    
    
    





}
