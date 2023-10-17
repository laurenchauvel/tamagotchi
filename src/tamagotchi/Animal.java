package tamagotchi;

public abstract class Animal extends Tamagotchi {

    /**
     * les attributs
     */

     //attribut hygiene
     private int hygiene;

     //attribut toielette
     private int toilette;

     //attribut nourriture
     private int nourriture;

     //enum avec les differents cris
     public enum Cri {Aboyer , Rugir , Chanter};

     //attribut du cri de l'animal
     private Cri cri;

     /**
      * les methodes
      */

      //getter nourriture
      public int getNourriture() {
        return nourriture;
      }

      //setter nourriture
      public void setNourriture(int n) {
        nourriture += n;
      }

      //getter toilette
      public int getToilette() {
        return toilette;
      }

      //setter toilette
      public void setToilette(int n) {
        toilette += n;
      }

      //getter hygiene
      public int getHygiene() {
        return hygiene;
      }

      //setter hygiene
      public void setHygiene(int n) {
        hygiene += n;
      }

      //methode pour manger
      public void manger(int n) {
        if (getNourriture() + n <= 100) {
            setNourriture(n);
        }
        else {
            setNourriture(100 - getNourriture());
        }
      }

      //methode pour se laver
      public void seLaver(int n) {
        if (getHygiene() + n <= 100) {
            setHygiene(n);
        }
        else {
            setHygiene(100 - getHygiene());
        }
      }

      //methode pour faire du sport
      public void faireSport(int n) {
        if (getEnergie() >= 20) {
            setEnergie(n);
        }
        if (getHygiene() >= 20) {
            setHygiene(n);
        }
        if (getMoral() + n <= 100) {
            setMoral(n);
        }
        else {
            set
        }
      }

}
