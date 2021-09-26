package com.g1a6iator.mycalories.ui.today_eaten_food;

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

import com.g1a6iator.mycalories.databinding.FragmentTodayEatenFoodBinding;

public class TodayEatenFoodFragment extends Fragment {

    private TodayEatenFoodViewModel todayEatenFoodViewModel;
    private FragmentTodayEatenFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayEatenFoodViewModel =
                new ViewModelProvider(this).get(TodayEatenFoodViewModel.class);

        binding = FragmentTodayEatenFoodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        todayEatenFoodViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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