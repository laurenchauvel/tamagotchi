package tamagotchi;

import java.io.*;

public abstract class Animal extends Tamagotchi {

    /**
     * les attributs
     */

    //attribut hygiene
    private int hygiene;

    //attribut toielette
    private int toilette;

    //attribut nourriture
    private int nourriture;

    //enum avec les differents cris
    public enum Cri {Aboyer , Rugir , Chanter};

    //attribut du cri de l'animal
    private Cri cri;

    //attribut du fichier son pour le cri
    private File son;

    //=================================================================================================================

    /**
     * le Constructeur
     *
     * @param n
     */
    public Animal(String n , Lieu l) {
        super(n,l);
        setHygiene(100);
        setNourriture(100);
        setToilette(100);
    }

    //=================================================================================================================

    /**
     * les methodes
     */

    //getter fichier son
    public File getSon() {
        return son;
    }

    //setter fichier son
    public void setSon(File s) {
        this.son = s;
    }

    //=================================================================================================================

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

    //getter hygiene
    public int getHygiene() {
        return hygiene;
    }

    //setter hygiene
    public void setHygiene(int n) {
        hygiene = n;
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
        if (getEnergie() >= 20 && getNourriture() >= 20) {
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
    	if (getEnergie() >= 10) {
	        majMoral(30);
	        majEnergie(-5);
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
        if (getEnergie() >= 20 && getNourriture() >= 30) {
            majMoral(15);
            majNourriture(-20);
            majEnergie(-10);
            majHygiene(-30);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================
    //Méthode jouer
    @Override
    public void jouer() {
        if (getEnergie() >= 35 && getNourriture() >= 30) {
            //changement positif
            majMoral(25);
            majNourriture(-20);
            majEnergie(-30);
            majHygiene(-20);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }
    
    





}
