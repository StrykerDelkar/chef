package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class Dessert extends Dish{
  private String type;
  
  public Dessert(String name, ArrayList<String> ingredients, String type) {
    super(name, ingredients);
    this.type = type;
  }
  
  public String getType() {
    return type;
  }
}
