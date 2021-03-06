package hemberger.patrick.chef.object;

import java.util.ArrayList;
import java.util.Iterator;

public class Blacklist{
  private final ArrayList<BlacklistItem> blacklist;
  
  public Blacklist() {
    blacklist = new ArrayList<>();
  }
  
  public void addItem(BlacklistItem input){
    blacklist.add(input);
  }
  
  public void clearList() {
    for (Iterator<BlacklistItem> blacklistItemIterator = blacklist.iterator(); blacklistItemIterator.hasNext(); )
      blacklistItemIterator.remove();
  }
  
  public boolean searchItem(BlacklistItem input) {
    boolean blacklisted = false;
    for (BlacklistItem item : blacklist) {
      blacklisted = item.getIngredients().equals(input.getIngredients());
      if (blacklisted) break;
    }
    return blacklisted;
  }
}
