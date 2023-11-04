package tamagotchi;
import java.io.*;
public class Chien extends Animal {

    /**
     * attributs
     */

    //=================================================================================================================

    /**
     * Cosntructeur
     * @param n
     */
    public Chien(String n) {
        setVie(100);
        setHygiene(100);
        setEnergie(100);
        setMoral(100);
        setNourriture(100);
        setToilette(100);
        setNom(n);
        setCri(Cri.Aboyer);
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

    //action specifique au chien
    public void vaChercher() {
        System.out.println("Le chien va chercher la  balle");
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }
}
