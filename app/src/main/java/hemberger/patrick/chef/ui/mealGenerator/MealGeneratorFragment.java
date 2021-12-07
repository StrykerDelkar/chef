package hemberger.patrick.chef.ui.mealGenerator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import hemberger.patrick.chef.databinding.FragmentMealGeneratorBinding;
import hemberger.patrick.chef.object.Dessert;
import hemberger.patrick.chef.object.DessertCollection;
import hemberger.patrick.chef.object.Dish;
import hemberger.patrick.chef.object.DishCollection;
import hemberger.patrick.chef.object.MainDish;
import hemberger.patrick.chef.object.MainDishCollection;
import hemberger.patrick.chef.object.Meal;

import hemberger.patrick.chef.R;

public class MealGeneratorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
  private ArrayList<String> intolerances;
  private MainDishCollection allMainDishes;
  private DessertCollection allDesserts;
  private String chosenIngredient;
  private String chosenDessertType;
  private String pickedMainDish;
  private String pickedDessert;
  private FragmentMealGeneratorBinding binding;
  
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    intolerances = new ArrayList<>();
    chosenDessertType = "";
    allMainDishes = new MainDishCollection();
    allDesserts = new DessertCollection();
    chosenIngredient = "";
    pickedMainDish = "";
    pickedDessert = "";
    
    binding = FragmentMealGeneratorBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    
    final TextView textIntolerances = binding.textGeneratorIntolerances;
    textIntolerances.setText(R.string.generator_intolerances);
    
    final TextView textDessertType = binding.textGeneratorDessertType;
    textDessertType.setText(R.string.generator_dessert_type);
  
    final TextView textIngredient = binding.textGeneratorIngredient;
    textIngredient.setText(R.string.generator_ingredient);
    
    TextView textMainDishDisplay = binding.textGeneratorDisplayMain;
    textMainDishDisplay.setText(R.string.empty_string);
  
    TextView textDessertDisplay = binding.textGeneratorDisplayDessert;
    textDessertDisplay.setText(R.string.empty_string);
    
    // Switches to communicate intolerances the generator has to account for
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
    
    Spinner dessertSpinner = root.findViewById(R.id.spinner_dessert_type);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> dessertAdapter = ArrayAdapter.createFromResource(this.getContext(),
            R.array.dessert_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    dessertAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    dessertSpinner.setAdapter(dessertAdapter);
    dessertSpinner.setOnItemSelectedListener(this);
  
    EditText ingredientEdit = root.findViewById(R.id.edit_ingredient_input);
    String ingredientEditValue = ingredientEdit.getText().toString();
    
    Button ingredientSubmitButton = root.findViewById(R.id.button_ingredient_input);
    ingredientSubmitButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        chosenIngredient = ingredientEditValue;
      }
    });
    
    Button generateButton = root.findViewById(R.id.button_generate);
    generateButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        generateMeal();
        textDessertDisplay.invalidate();
        textMainDishDisplay.invalidate();
        textMainDishDisplay.setText(pickedMainDish);
        textDessertDisplay.setText(pickedDessert);
        
      }
    });
    
    return root;
  }
  
  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
  
  public void onItemSelected(AdapterView<?> parent, View view,
                             int pos, long id) {
    chosenDessertType = parent.getItemAtPosition(pos).toString();
  }
  
  public void onNothingSelected(AdapterView<?> parent) {
    chosenDessertType = "";
  }
  
  /**
   * adds a given intolerance to the list of intolerances,
   * if it's not already present
   *
   * @param intolerance the given intolerance
   */
  public void addIntolerance(String intolerance) {
    if (!this.intolerances.contains(intolerance)) {
      this.intolerances.add(intolerance);
    }
  }
  
  /**
   * removes a given intolerance from the list of intolerances
   *
   * @param intolerance the given intolerance
   */
  public void removeIntolerance(String intolerance) {
    intolerances.remove(intolerance);
  }
  
  public void generateMeal() {
    MainDishCollection filteredMain = this.allMainDishes;
    DessertCollection filteredDessert = this.allDesserts;
  
    // filter both collections
    filteredMain.filterIntolerances(intolerances);
    filteredMain.filterIngredient(chosenIngredient);
    filteredDessert.filterIntolerances(intolerances);
    filteredDessert.filterType(chosenDessertType);
  
    // get random items from each collection
    MainDish pickedMain = (MainDish) filteredMain.pickRandomDish();
    Dessert pickedDessert = (Dessert) filteredDessert.pickRandomDish();
    // generate meal
    Meal generated = new Meal(pickedMain, pickedDessert);
    this.pickedMainDish = generated.getMainDish().getName();
    this.pickedDessert = generated.getDessert().getName();
    System.out.println(pickedDessert);
    allMainDishes = new MainDishCollection();
    allDesserts = new DessertCollection();
  }
}