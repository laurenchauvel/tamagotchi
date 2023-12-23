package modele;

import java.io.*;

public abstract class Animal extends Tamagotchi {

    /**
     * les attributs
     */

    //attribut nourriture
    private int nourriture;

    //=================================================================================================================

    /**
     * le Constructeur
     *
     * @param n
     */
    public Animal(String n) {
        super(n);
        setNourriture(100);
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

    //methode pour manger
    public void manger() {
        majNourriture(30);
        majEnergie(10);
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
    
    public void seSoulager() {
    	majToilette(50);
    	majHygiene(15);
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
    
    
    
    
    





}