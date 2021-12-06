package hemberger.patrick.chef.ui.ingredientCombinator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IngredientCombinatorViewModel extends ViewModel {
  
  private MutableLiveData<String> mText;
  
  public IngredientCombinatorViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("Ingredient Combinator");
  }
  
  public LiveData<String> getText() {
    return mText;
  }
}