package hemberger.patrick.chef.ui.mealGenerator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MealGeneratorViewModel extends ViewModel {
  
  private MutableLiveData<String> mText;
  
  public MealGeneratorViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("Intolerances to account for:");
  }
  
  public LiveData<String> getText() {
    return mText;
  }
}