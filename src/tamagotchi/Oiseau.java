package src.tamagotchi;

public class Oiseau extends Animal {

    /**
     * attributs
     */

    //=================================================================================================================

    /**
     * Constructeur
     */
    public Oiseau(String n , Lieu l) {
        super(n,l);
        setCri(Cri.Chanter);
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

    //action specifique de l'oiseau
    public void voler() {
        System.out.println("L'oiseau vole");
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }


}
