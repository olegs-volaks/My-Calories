package com.g1a6iator.mycalories.ui.all_eaten_food;

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

import com.g1a6iator.mycalories.databinding.FragmentAllEatenFoodBinding;

public class AllEatenFoodFragment extends Fragment {

    private AllEatenFoodViewModel allEatenFoodViewModel;
    private FragmentAllEatenFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        allEatenFoodViewModel =
                new ViewModelProvider(this).get(AllEatenFoodViewModel.class);

        binding = FragmentAllEatenFoodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        allEatenFoodViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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