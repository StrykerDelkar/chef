package hemberger.patrick.chef.ui.ingredientCombinator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import hemberger.patrick.chef.R;
import hemberger.patrick.chef.databinding.FragmentIngredientCombinatorBinding;
import hemberger.patrick.chef.object.Blacklist;
import hemberger.patrick.chef.object.BlacklistItem;
import hemberger.patrick.chef.object.Ingredients;

public class IngredientCombinatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
  
  private ArrayList<String> intolerances;
  private String chosenIngredient;
  private String ingredientCount;
  private String pickedIngredients;
  private Blacklist blacklist;
  private BlacklistItem currentCombination;
  private FragmentIngredientCombinatorBinding binding;
  
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    
    intolerances = new ArrayList<>();
    ingredientCount = "1";
    chosenIngredient = "";
    blacklist = new Blacklist();
    currentCombination = new BlacklistItem();
    
    binding = FragmentIngredientCombinatorBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    
    final TextView textIntolerances = binding.textCombinerIntolerances;
    textIntolerances.setText(R.string.generator_intolerances);
    
    final TextView textCount = binding.textCombineCount;
    textCount.setText(R.string.combiner_count);
    
    final TextView textIngredient = binding.textGeneratorIngredient;
    textIngredient.setText(R.string.generator_ingredient);
    
    TextView textPickedIngredients = binding.textGeneratorDisplayMain;
    textPickedIngredients.setText(R.string.empty_string);
    
    // Switches to communicate intolerances the generator has to account for
    SwitchCompat chocolateSwitch = root.findViewById(R.id.switch_chocolate);
    chocolateSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        addIntolerance("chocolate");
      } else {
        removeIntolerance("chocolate");
      }
    });
    
    SwitchCompat lactoseSwitch = root.findViewById(R.id.switch_lactose);
    lactoseSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        addIntolerance("chocolate");
      } else {
        removeIntolerance("chocolate");
      }
    });
    
    SwitchCompat nutsSwitch = root.findViewById(R.id.switch_nuts);
    nutsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        addIntolerance("chocolate");
      } else {
        removeIntolerance("chocolate");
      }
    });
    
    Spinner countSpinner = root.findViewById(R.id.spinner_combine_count);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> countAdapter = ArrayAdapter.createFromResource(this.getContext(),
            R.array.count_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    countAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    countSpinner.setAdapter(countAdapter);
    countSpinner.setOnItemSelectedListener(this);
    
    EditText ingredientEdit = root.findViewById(R.id.edit_ingredient_input);
    String ingredientEditValue = ingredientEdit.getText().toString();
    
    Button ingredientSubmitButton = root.findViewById(R.id.button_ingredient_input);
    
    ingredientSubmitButton.setOnClickListener(v -> chosenIngredient = ingredientEditValue);
    
    Button generateButton = root.findViewById(R.id.button_combine);
    generateButton.setOnClickListener(v -> {
      combineIngredients();
      textPickedIngredients.invalidate();
      textPickedIngredients.setText(pickedIngredients);
    });
    
    Button clearButton = root.findViewById(R.id.button_blacklist_clear);
    clearButton.setOnClickListener(v -> blacklist.clearList());
    
    Button addButton = root.findViewById(R.id.button_blacklist_add);
    addButton.setOnClickListener(v -> blacklist.addItem(currentCombination));
    
    return root;
  }
  
  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
  
  public void onItemSelected(AdapterView<?> parent, View view,
                             int pos, long id) {
    ingredientCount = parent.getItemAtPosition(pos).toString();
  }
  
  public void onNothingSelected(AdapterView<?> parent) {
    ingredientCount = "1";
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
  
  public void combineIngredients() {
    Ingredients ingredients = new Ingredients();
    boolean allowed;
    boolean ingredientContained = true;
    ArrayList<String> picked;
    ingredients.filterIntolerances(intolerances);
    do {
      picked = ingredients.pickRandomIngredients(Integer.parseInt(ingredientCount));
      BlacklistItem newBLI = new BlacklistItem(picked);
      currentCombination = newBLI;
      if (!chosenIngredient.equals(""))
        ingredientContained = newBLI.checkForIngredient(chosenIngredient);
      allowed = !blacklist.searchItem(newBLI) && ingredientContained;
      System.out.println(newBLI.checkForIngredient(chosenIngredient));
    } while (!allowed);
    pickedIngredients = String.join(", ", picked);
  }
}