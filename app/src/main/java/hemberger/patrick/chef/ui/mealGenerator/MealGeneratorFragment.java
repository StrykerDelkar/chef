package hemberger.patrick.chef.ui.mealGenerator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Collections;

import hemberger.patrick.chef.databinding.FragmentMealGeneratorBinding;
import hemberger.patrick.chef.object.Dessert;
import hemberger.patrick.chef.object.DessertCollection;
import hemberger.patrick.chef.object.Dish;
import hemberger.patrick.chef.object.MainDish;
import hemberger.patrick.chef.object.MainDishCollection;
import hemberger.patrick.chef.object.Meal;

import hemberger.patrick.chef.R;

public class MealGeneratorFragment extends Fragment {
  private Meal chosenMeal;
  private ArrayList<String> intolerances;
  private MainDishCollection allMainDishes;
  private DessertCollection allDesserts;
  private String chosenIngredient;
  
  private MealGeneratorViewModel mealGeneratorViewModel;
  private FragmentMealGeneratorBinding binding;
  
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    intolerances = new ArrayList<>();
    allMainDishes = new MainDishCollection();
    allDesserts = new DessertCollection();
    chosenIngredient = "";
    
    mealGeneratorViewModel =
            new ViewModelProvider(this).get(MealGeneratorViewModel.class);
    
    binding = FragmentMealGeneratorBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    
    final TextView textView = binding.textGeneratorIntolerances;
    mealGeneratorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    
    // Switches for to communicate intolerances the generator has to account for
    SwitchCompat chocolateSwitch = root.findViewById(R.id.switch_chocolate);
    chocolateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          addIntolerance("chocolate");
        } else {
          removeIntolerance("chocolate");
        }
      }
    });
    
    SwitchCompat lactoseSwitch = root.findViewById(R.id.switch_lactose);
    lactoseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          addIntolerance("chocolate");
        } else {
          removeIntolerance("chocolate");
        }
      }
    });
    
    SwitchCompat nutsSwitch = root.findViewById(R.id.switch_nuts);
    nutsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          addIntolerance("chocolate");
        } else {
          removeIntolerance("chocolate");
        }
      }
    });
    
    Button button = (Button) root.findViewById(R.id.button_generate);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        MainDish randomMainDish = (MainDish) pickRandomDish(allMainDishes.getCollection());
        Dessert randomDessert = (Dessert) pickRandomDish(allDesserts.getCollection());
        System.out.println(randomMainDish.getName());
        System.out.println(randomDessert.getName());
      }
    });
    
    return root;
  }
  
  
  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
  
  // methods to add and remove intolerances
  public void addIntolerance(String intolerance) {
    if (!this.intolerances.contains(intolerance)) {
      this.intolerances.add(intolerance);
    }
  }
  
  public void removeIntolerance(String intolerance) {
    intolerances.remove(intolerance);
    
  }
  
  public Dish pickRandomDish(ArrayList<Dish> dishCollection) {
    Collections.shuffle(dishCollection);
    return dishCollection.get(0);
  }
}