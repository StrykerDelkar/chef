package hemberger.patrick.chef.object;

import java.util.ArrayList;

public class DessertCollection {
  private ArrayList<Dish> collection;
  
  public DessertCollection(){
    collection= new ArrayList<>();
    ArrayList<String> ingBS = new ArrayList<>();
    ingBS.add("chocolate");
    ingBS.add("milk");
    ingBS.add("vanilla");
    ingBS.add("banana");
    collection.add(new Dessert("Banana Split", ingBS, "ice cream"));
  
    ArrayList<String> ingCC = new ArrayList<>();
    ingCC.add("flour");
    ingCC.add("butter");
    ingCC.add("sugar");
    ingCC.add("powdered sugar");
    ingCC.add("egg");
    ingCC.add("baking pulver");
    ingCC.add("curd");
    ingCC.add("custard powder");
    ingCC.add("vanilla sugar");
    collection.add(new Dessert("Cheesecake", ingCC, "cake"));
  
    ArrayList<String> ingBC = new ArrayList<>();
    ingBC.add("chocolate");
    collection.add(new Dessert("Bar of Chocolate", ingBC, "chocolate"));
  }
  
  public ArrayList<Dish> getCollection() {
    return collection;
  }
}