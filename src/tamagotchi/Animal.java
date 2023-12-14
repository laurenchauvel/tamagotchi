package src.tamagotchi;

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
            if (getHygiene() - n >= 0) {
                setHygiene(getHygiene() - n);
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
            if (getNourriture() - n >= 0) {
                setNourriture(getNourriture() - n);
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
            if (getToilette() - n >= 0) {
                setToilette(getToilette() - n);
            } else {
                setToilette(0);
            }
        }
    }

    //=================================================================================================================

    //methode pour manger
    public void manger(int n) {
        majNourriture(n);
        majEnergie(n);
    }

    //=================================================================================================================

    //methode pour se laver
    public void seLaver(int n) {
        majHygiene(n);
    }

    //=================================================================================================================

    //methode pour faire du sport
    public void faireSport(int n) {
        //maj energie
        if (getEnergie() >= n && getNourriture() >= n) {
            //changement positif
            majMoral(n);
            //changement negatif
            n *= -1;
            majNourriture(n);
            majHygiene(n);
            majEnergie(n);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    public void brosserDent(int n) {
        majHygiene(n);
    }

    //=================================================================================================================

    public void regarderTV(int n) {
        //changement positif
        majMoral(n);
        //changement negatif
        n *= -1;
        majEnergie(n/7);
        majNourriture(n/10);
        majHygiene(n/10);
    }

    //=================================================================================================================

    //methode pour dormir
    public void dormir(int n) {
        majEnergie(n);
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
    public void jardinage(int n) {
        if (getEnergie() >= n && getNourriture() >= n) {
            //changement positif
            majMoral(n);
            //changement negatif
            n *= 1;
            majNourriture(n);
            majEnergie(n);
            majHygiene(n);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    @Override
    public void jouer(int n) {
        if (getEnergie() >= n && getNourriture() >= n) {
            //changement positif
            majMoral(n);
            //changement negatif
            n *= 1;
            majNourriture(n);
            majEnergie(n);
            majHygiene(n);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }





}
