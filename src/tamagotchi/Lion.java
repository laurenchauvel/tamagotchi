package tamagotchi;

public class Lion extends Animal {

    /**
     * attributs
     */

    //=================================================================================================================

    /**
     * Constructeur
     */
    public Lion(String n , Lieu l) {
        super(n,l);
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
