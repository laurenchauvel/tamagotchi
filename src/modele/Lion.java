package modele;

@SuppressWarnings("serial")
public class Lion extends Animal {

	/**
     * attributs
     */

    //=================================================================================================================

	/**
     * Constructeur
     */
    public Lion(String n) {
        super(n);
        setCri(Cri.Rugir);
        setEspece(Espece.Lion);
    }

    //=================================================================================================================
    
    /**
     * methodes
     */

    //action specifique au lion
    public void sauter() {
        System.out.println("le lion saute");
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }
}
