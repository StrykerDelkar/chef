package hemberger.patrick.chef.ui.mealGenerator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hemberger.patrick.chef.databinding.FragmentMealGeneratorBinding;

public class MealGeneratorFragment extends Fragment {
  
  private MealGeneratorViewModel mealGeneratorViewModel;
  private FragmentMealGeneratorBinding binding;
  
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    mealGeneratorViewModel =
            new ViewModelProvider(this).get(MealGeneratorViewModel.class);
    
    binding = FragmentMealGeneratorBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    
    final TextView textView = binding.textDashboard;
    mealGeneratorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
  
  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}