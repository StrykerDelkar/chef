package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class BlacklistItem {
  private ArrayList<String> ingredients;
  
  public BlacklistItem(ArrayList<String> ingredients) {
    this.ingredients = ingredients;
  }
  
  public BlacklistItem(){
    ingredients = new ArrayList<>();
  }
  
  public ArrayList<String> getIngredients() {
    return ingredients;
  }
  
  
  public boolean checkForIngredient(String ingredient) {
    boolean contained = false;
    for (String item : ingredients) {
      contained = item.equals(ingredient);
      if (contained) break;
    }
    return contained;
  }
}
