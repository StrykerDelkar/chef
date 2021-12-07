package hemberger.patrick.chef.object;

import java.util.ArrayList;
import java.util.Iterator;

public class Blacklist{
  private ArrayList<BlacklistItem> blacklist;
  
  public Blacklist() {
    blacklist = new ArrayList<>();
  }
  
  public ArrayList<BlacklistItem> getBlacklist() {
    return blacklist;
  }
  
  public void addItem(BlacklistItem item){
    blacklist.add(item);
  }
  
  public void clearList() {
    for (Iterator<BlacklistItem> blacklistItemIterator = blacklist.iterator(); blacklistItemIterator.hasNext(); ) {
      BlacklistItem item = blacklistItemIterator.next();
        blacklistItemIterator.remove();
    }
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
