package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class MainDishCollection {
  private ArrayList<Dish> collection;
  
  public MainDishCollection(){
    collection= new ArrayList<>();
    ArrayList<String> ingWS = new ArrayList<>();
    ingWS.add("pork");
    ingWS.add("flour");
    ingWS.add("egg");
    ingWS.add("bread");
    ingWS.add("lemon");
    collection.add(new MainDish("Wiener Schnitzel", ingWS));
  
    ArrayList<String> ingPS = new ArrayList<>();
    ingPS.add("potato");
    ingPS.add("bacon");
    ingPS.add("pickles");
    collection.add(new MainDish("Potato Salad", ingPS));
  
    ArrayList<String> ingEB = new ArrayList<>();
    ingEB.add("bacon");
    ingEB.add("egg");
    ingEB.add("beans");
    collection.add(new MainDish("English Breakfast", ingPS));
  }
  
  public ArrayList<Dish> getCollection() {
    return collection;
  }
}