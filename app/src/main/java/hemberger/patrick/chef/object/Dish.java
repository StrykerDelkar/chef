package hemberger.patrick.chef.object;

import java.util.ArrayList;

class Dish {
  private String name;
  private ArrayList<String> ingredients;
  private ArrayList<String> intolerances;
  private ArrayList<String> animalProducts;
  
  public Dish(String name, ArrayList<String> ingredients, ArrayList<String> intolerances, ArrayList<String> animalProducts){
    this.name=name;
    this.ingredients=ingredients;
    this.intolerances=intolerances;
    this.animalProducts=animalProducts;
  }
  
  public String getName() {
    return name;
  }
  
  public ArrayList<String> getIngredients() {
    return ingredients;
  }
  
  public ArrayList<String> getIntolerances() {
    return intolerances;
  }
  
  public ArrayList<String> getAnimalProducts() {
    return animalProducts;
  }
}
