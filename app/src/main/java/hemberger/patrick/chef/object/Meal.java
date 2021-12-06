package hemberger.patrick.chef.object;

public class Meal {
  private MainDish mainDish;
  private Dessert dessert;
  
  public Meal(MainDish mainDish, Dessert dessert){
    this.mainDish = mainDish;
    this.dessert = dessert;
  }
  
  public Dessert getDessert() {
    return dessert;
  }
  
  public MainDish getMainDish() {
    return mainDish;
  }
}
