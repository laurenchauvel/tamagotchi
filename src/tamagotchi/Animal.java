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
        nourriture = n;
      }

      //getter toilette
      public int getToilette() {
        return toilette;
      }

      //setter toilette
      public void setToilette(int n) {
        toilette = n;
      }

      //getter hygiene
      public int getHygiene() {
        return hygiene;
      }

      //setter hygiene
      public void setHygiene(int n) {
        hygiene = n;
      }

      //methode de mise a jour hygiene
      public void majHygiene(int n) {
          if (n > 0) {
              if (getHygiene() + n <= 100) {
                  setHygiene(getHygiene() + n);
              }
              else {
                  setHygiene(100);
              }
          }
          else {
              if (getHygiene() - n >= 0)
                  setHygiene(getHygiene() - n);
              else {
                  setHygiene(0);
              }
          }
      }

      //methode pour manger
      public void manger(int n) {
        if (getNourriture() + n <= 100) {
            setNourriture(getNourriture() + n);
        }
        else {
            setNourriture(100);
        }
      }

      //methode pour se laver
      public void seLaver(int n) {
            majHygiene(n);
      }

      //methode pour faire du sport
      public void faireSport(int n) {
          if (getEnergie() >= 20) {
              //maj energie
              setEnergie(getEnergie() - n);
              //maj hygiene
              majHygiene(-n);
              //maj morale
              if (super.getMoral() + n <= 100) {
                  super.setMoral(getMoral() + n);
              }
              else {
                  super.setMoral(100);
              }
          }
      }


}
