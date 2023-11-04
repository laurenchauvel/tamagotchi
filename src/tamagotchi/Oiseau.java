package tamagotchi;

public class Oiseau extends Animal {

    /**
     * attributs
     */

    //=================================================================================================================

    /**
     * Constructeur
     */
    public Oiseau(String n) {
        setVie(100);
        setHygiene(100);
        setEnergie(100);
        setMoral(100);
        setNourriture(100);
        setToilette(100);
        setNom(n);
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
