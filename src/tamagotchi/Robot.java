package tamagotchi;

public class Robot extends Tamagotchi{
  private int batterie;
  public void seRecharger(int n){
    if (getBatterie() + n <= 100) {
            setBatterie(getBatterie() + n);
        }
        else {
            setBatterie(100);
        }
  }
  public void enVeille(int n){
    //TODO
  }
  public int getBatterie(int n){
    return batterie;
  }
  public void setBatterie(){
    batterie = n;
  }
}
