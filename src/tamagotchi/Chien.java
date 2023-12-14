package tamagotchi;

public class Chien extends Animal {

    /**
     * attributs
     */

    //=================================================================================================================

    /**
     * Cosntructeur
     * @param n
     */
    public Chien(String n , Lieu l) {
        super(n,l);
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
