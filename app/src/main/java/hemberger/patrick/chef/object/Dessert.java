package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class Dessert extends Dish{
  
  public Dessert(String name, ArrayList<String> ingredients, String type) {
    super(name, ingredients);
    setType(type);
  }
}
