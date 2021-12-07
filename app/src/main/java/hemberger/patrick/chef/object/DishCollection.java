package hemberger.patrick.chef.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class DishCollection {
  ArrayList<Dish> collection;
  
  DishCollection() {
    collection = new ArrayList<>();
  }
  
  public void filterIntolerances(ArrayList<String> intolerances) {
    ArrayList<Dish> temp = collection;
    for (Iterator<Dish> dishIterator = temp.iterator(); dishIterator.hasNext(); ) {
      Dish dish = dishIterator.next();
      for (String ingredient : intolerances) {
        if (dish.getIngredients().contains(ingredient)) {
          dishIterator.remove();
        }
      }
    }
  }
  
  /**
   * picks a random Dish from this DishCollection
   *
   * @return the randomly picked Dish
   */
  public Dish pickRandomDish() {
    Collections.shuffle(collection);
    return collection.get(0);
  }
  
  /**
   * removes all Dishes from this DishCollection that aren't of the given type
   *
   * @param type the given type
   */
  public void filterType(String type) {
    ArrayList<Dish> temp = collection;
    for (Iterator<Dish> dishIterator = temp.iterator(); dishIterator.hasNext(); ) {
      Dish dish = dishIterator.next();
      if (!dish.getType().equals(type)) {
        dishIterator.remove();
      }
    }
    collection = temp;
  }
  
  public void filterIngredient(String ingredient) {
    ArrayList<Dish> temp = collection;
    for (Iterator<Dish> dishIterator = temp.iterator(); dishIterator.hasNext(); ) {
      Dish dish = dishIterator.next();
      if (!ingredient.equals("") &&  dish.getIngredients().contains(ingredient)) {
        dishIterator.remove();
      }
    }
    collection = temp;
  }
  
}
