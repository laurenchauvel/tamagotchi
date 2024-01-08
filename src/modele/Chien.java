package modele;

@SuppressWarnings("serial")
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
        super(n);
        setEspece(Espece.Chien);
    }

    //=================================================================================================================

    /**
     * methodes
     */

    //action specifique au chien
    public void vaChercher() {
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }
}
