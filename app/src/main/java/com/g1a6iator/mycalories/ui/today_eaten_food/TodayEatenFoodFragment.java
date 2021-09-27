package com.g1a6iator.mycalories.ui.today_eaten_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.adapter.EatenFoodListAdapter;
import com.g1a6iator.mycalories.databinding.FragmentTodayEatenFoodBinding;

public class TodayEatenFoodFragment extends Fragment {

    private TodayEatenFoodViewModel todayEatenFoodViewModel;
    private FragmentTodayEatenFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayEatenFoodViewModel =
                new ViewModelProvider(this).get(TodayEatenFoodViewModel.class);

        binding = FragmentTodayEatenFoodBinding.inflate(inflater, container, false);
        View layout = binding.getRoot();
        TextView todayCalories = layout.findViewById(R.id.eaten_food_today_calories);
        RecyclerView recyclerView = layout.findViewById(R.id.today_eaten_food_recyclerview);
        todayEatenFoodViewModel.getCaloriesToday().observe(getViewLifecycleOwner(), aDouble -> {
            if (aDouble == null) {
                aDouble = 0d;
            }
            todayCalories.setText(String.valueOf(aDouble));
        });
        final EatenFoodListAdapter adapter = new EatenFoodListAdapter(new EatenFoodListAdapter.EatenFoodDiff(), eatenFood -> {
            todayEatenFoodViewModel.delete(eatenFood);
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        todayEatenFoodViewModel.getTodayEatenFoodList().observe(getViewLifecycleOwner(), adapter::submitList);
        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}