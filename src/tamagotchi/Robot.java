package tamagotchi;

public class Robot extends Tamagotchi{

    /**
     * les attributs
     */
    private int batterie;

    //=================================================================================================================

    /**
     * Constructeur
     */
    public Robot(String n , Lieu l) {
        super(n,l);
        setBatterie(100);
    }

    //=================================================================================================================

    /**
     * les methodes
     * @param n
     */
    public void majBatterie(int n) {
        if (n > 0) {
            if (getBatterie() + n <= 100) {
                setBatterie(getBatterie() + n);
            } else {
                setBatterie(100);
            }
        } else {
            if (getBatterie() + n >= 0) {
                setBatterie(getBatterie() + n);
            } else {
                setBatterie(0);
            }
        }
    }

    //=================================================================================================================
    
    //methode equivalente a manger
    public void seRecharger(int n) {
        majBatterie(n);
        majEnergie(n);
    }

    //=================================================================================================================

    //methode equivalente a dormir
    public void enVeille(int n){
        majEnergie(n);
    }

    //=================================================================================================================
    public int getBatterie(){
        return batterie;
    }
    public void setBatterie(int n){
        batterie = n;
    }

    //=================================================================================================================

    @Override
    public void regarderTV() {
    	if (getEnergie() >= 10) {
	        majMoral(30);
	        majEnergie(-5);
	        majBatterie(-10);
    	} else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    @Override
    public void jouer() {
	    if (getEnergie() >= 35 && getBatterie() >= 30) {
	        majMoral(25);
	        majEnergie(-30);
	        majBatterie(-20);
	    } else {
	        System.out.println("Ressources insuffisantes");
	    }
    }

    //=================================================================================================================

    @Override
    public void jardinage() {
    	if (getEnergie() >= 20 && getBatterie() >= 30) {
            majMoral(15);
            majEnergie(-10);
            majBatterie(-20);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    @Override
    public void sauvegarde() {

    }


}
