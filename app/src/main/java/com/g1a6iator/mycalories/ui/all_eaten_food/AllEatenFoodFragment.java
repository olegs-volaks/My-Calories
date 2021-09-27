package com.g1a6iator.mycalories.ui.all_eaten_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.adapter.EatenFoodListAdapter;
import com.g1a6iator.mycalories.databinding.FragmentAllEatenFoodBinding;

public class AllEatenFoodFragment extends Fragment {

    private AllEatenFoodViewModel allEatenFoodViewModel;
    private FragmentAllEatenFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        allEatenFoodViewModel =
                new ViewModelProvider(this).get(AllEatenFoodViewModel.class);

        binding = FragmentAllEatenFoodBinding.inflate(inflater, container, false);
        View layout = binding.getRoot();
        RecyclerView recyclerView = layout.findViewById(R.id.all_eaten_food_recyclerview);
        final EatenFoodListAdapter adapter = new EatenFoodListAdapter(new EatenFoodListAdapter.EatenFoodDiff(), eatenFood -> {
            allEatenFoodViewModel.delete(eatenFood);
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        allEatenFoodViewModel.getAllEatenFood().observe(getViewLifecycleOwner(), adapter::submitList);

        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}