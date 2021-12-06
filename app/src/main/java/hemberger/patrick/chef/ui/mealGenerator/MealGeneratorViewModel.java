package hemberger.patrick.chef.ui.mealGenerator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MealGeneratorViewModel extends ViewModel {
  
  private MutableLiveData<String> mText;
  
  public MealGeneratorViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("Meal Generator");
  }
  
  public LiveData<String> getText() {
    return mText;
  }
}