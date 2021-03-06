package hemberger.patrick.chef.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Ingredients {
  private final ArrayList<String> list;
  
  public Ingredients() {
    list = new ArrayList<>();
    list.add("pork");
    list.add("potato");
    list.add("chicken");
    list.add("rice");
    list.add("pasta");
    list.add("cheese");
    list.add("bacon");
    list.add("dough");
    list.add("bread");
    list.add("melon");
    list.add("apple");
    list.add("tomato");
    list.add("paprika");
    list.add("chili");
  }
  
  public void filterIntolerances(ArrayList<String> intolerances) {
    list.removeIf(intolerances::contains);
  }
  
  public ArrayList<String> pickRandomIngredients(int count) {
    ArrayList<String> picked = new ArrayList<>();
    Collections.shuffle(list);
    for (int i = 0; i < count && i < list.size(); i++) {
      picked.add(list.get(i));
    }
    return picked;
  }
  
}
