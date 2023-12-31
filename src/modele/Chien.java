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
        setCri(Cri.Aboyer);
        setEspece(Espece.Chien);
    }

    //=================================================================================================================

    /**
     * methodes
     */

    //action specifique au chien
    public void vaChercher() {
        System.out.println("Le chien va chercher la  balle");
        majEnergie(-10);
        majMoral(10);
        majHygiene(-10);
    }
}
