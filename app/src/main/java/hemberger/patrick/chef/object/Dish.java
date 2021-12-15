package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class Dish {
  private final String name;
  private final ArrayList<String> ingredients;
  private String type;
  
  public Dish(String name, ArrayList<String> ingredients){
    this.name=name;
    this.ingredients=ingredients;
    this.type = "";
  }
  
  public String getName() {
    return name;
  }
  
  public ArrayList<String> getIngredients() {
    return ingredients;
  }
  
  public String getType() {
    return type;
  }
  
  protected void setType(String type) {
    this.type=type;
  }
}
