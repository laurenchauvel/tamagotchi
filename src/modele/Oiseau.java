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
        setEspece(Espece.Oiseau);
    }

    //=================================================================================================================
    
    /**
     * methodes
     */

    //action specifique de l'oiseau
    public void voler() {
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }


}
