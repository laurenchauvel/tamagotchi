package modele;

@SuppressWarnings("serial")
public class Oiseau extends Animal {

	/**
     * attributs
     */

    //=================================================================================================================

	/**
     * Constructeur
     */
    public Oiseau(String n) {
        super(n);
        setCri(Cri.Chanter);
    }

    //=================================================================================================================
    
    /**
     * methodes
     */

    //action specifique de l'oiseau
    public void voler() {
        System.out.println("L'oiseau vole");
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }


}
