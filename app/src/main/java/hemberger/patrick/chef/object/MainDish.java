package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class MainDish extends Dish{
  private String origin;
  
  public MainDish(String name, ArrayList<String> ingredients, ArrayList<String> intolerances, ArrayList<String> animalProducts, String origin) {
    super(name, ingredients, intolerances, animalProducts);
    this.origin = origin;
  }
  
  public String getOrigin() {
    return origin;
  }
}
