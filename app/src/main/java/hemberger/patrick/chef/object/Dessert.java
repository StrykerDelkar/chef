package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class Dessert extends Dish{
  private String type;
  
  public Dessert(String name, ArrayList<String> ingredients, ArrayList<String> intolerances, ArrayList<String> animalProducts) {
    super(name, ingredients, intolerances, animalProducts);
    this.type = type;
  }
  
  public String getType() {
    return type;
  }
}
