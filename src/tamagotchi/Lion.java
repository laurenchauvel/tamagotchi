package tamagotchi;
import java.io.*;

public class Lion extends Animal {

    /**
     * attributs
     */

    //=================================================================================================================

    /**
     * Constructeur
     */
    public Lion(String n) {
        setVie(100);
        setHygiene(100);
        setEnergie(100);
        setMoral(100);
        setNourriture(100);
        setToilette(100);
        setNom(n);
        setCri(Cri.Rugir);
        setSon(null);
    }

    //=================================================================================================================

    /**
     * methodes
     */
    @Override
    public void sauvegarde() {

    }

    //=================================================================================================================

    //action specifique au lion
    public void sauter() {
        System.out.println("le lion saute");
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }
}
