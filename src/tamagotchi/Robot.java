package src.tamagotchi;

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
            if (getBatterie() - n >= 0) {
                setBatterie(getBatterie() - n);
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
    public void regarderTV(int n) {
        //maj positive
        majMoral(n);
        //maj negative
        n *= -1;
        majEnergie(n);
        majBatterie(n);
    }

    //=================================================================================================================

    @Override
    public void jouer(int n) {
        if (getEnergie() >= n && getBatterie() >- n) {
            //maj positive
            majMoral(n);
            //maj negative
            n *= -1;
            majBatterie(n);
            majEnergie(n);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    @Override
    public void jardinage(int n) {
        if (getEnergie() >= n && getBatterie() >- n) {
            //maj positive
            majMoral(n);
            //maj negative
            n *= -1;
            majBatterie(n);
            majEnergie(n);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    @Override
    public void sauvegarde() {

    }


}
