package modele;

public class Robot extends Tamagotchi{

    /**
     * les attributs
     */
    private int batterie;

    //=================================================================================================================

    /**
     * Constructeur
     */
    public Robot(String n) {
        super(n);
        setBatterie(100);
        setCri(Cri.ORDI);
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
    public void seRecharger() {
        majBatterie(30);
        majEnergie(10);
    }

    //=================================================================================================================

    //methode equivalente a dormir
    public void enVeille(){
        majEnergie(20);
    }

    //=================================================================================================================
    public int getBatterie(){
        return batterie;
    }
    public void setBatterie(int n){
        batterie = n;
        notifierObservateurs();	//TODO : Observateur
    }

    //=================================================================================================================

    @Override
    public void regarderTV() {
    	if (getBatterie() > 10) {
	        majMoral(15);
	        majEnergie(5);
	        majBatterie(-10);
    	} else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================

    @Override
    public void jouer() {
	    if (getEnergie() > 30 && getBatterie() > 20) {
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
    	if (getEnergie() > 10 && getBatterie() > 20) {
            majMoral(15);
            majEnergie(-10);
            majBatterie(-20);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }

    //=================================================================================================================
    
    //methode pour faire du sport
    public void faireSport() {
        //maj energie
        if (getEnergie() > 20 && getBatterie() > 20) {
            majMoral(20);
            majBatterie(-20);
            majHygiene(-30);
            majEnergie(-20);
        } else {
            System.out.println("Ressources insuffisantes");
        }
    }
    
    //=================================================================================================================
    
    //methode qui signale si le robot est dechargé
    public boolean estDecharge() {
    	if (getBatterie() < 15) {
    		return true;
    	}
    	return false;
    }
    
    //=================================================================================================================
    
    //methode pour la perte de nutrition
    /*
	 * n le nombre de points de nutrition qui baissent toutes les s secondes
	 */
    public void perteDeCharge(int n, int s) {
    	while(!estDecharge()) {
    		majBatterie(n);
    		wait(s);
    	}
    }
    
    //=================================================================================================================
    
    //methode pour mourir de malnutrition
    /*
     * perte de 1 pn toutes les 5 secondes
     * pere de 5 pv toutes les 180 secondes
     */
    public void dechargement() {
    	perteDeCharge(-1, 5);
    	if (estDecharge()) {
			System.out.println(getNom() + " est déchargé");
			perteDeVie(-5,180);
		}
    	if (estMort()) {
			System.out.println(getNom() + " a succombé face à la brutalité du manque soudain de vivres !!!!");
		}
    	
    }
    



}