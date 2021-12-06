package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class Dish {
  private String name;
  private ArrayList<String> ingredients;
  private ArrayList<String> intolerances;
  
  public Dish(String name, ArrayList<String> ingredients){
    this.name=name;
    this.ingredients=ingredients;
  }
  
  public String getName() {
    return name;
  }
  
  public ArrayList<String> getIngredients() {
    return ingredients;
  }
  
}
