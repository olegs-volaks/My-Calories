package com.g1a6iator.mycalories.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.adapter.ProductListAdapter;
import com.g1a6iator.mycalories.databinding.FragmentHomeBinding;
import com.g1a6iator.mycalories.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    public static final int NEW_PRODUCT_ACTIVITY_REQUEST_CODE = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View layout = binding.getRoot();
        ActivityResultLauncher<Integer> activityResultLauncher = registerForActivityResult(new NewProductActivityContract(), result -> {
            if (result != null) {
                homeViewModel.insert(result);
            } else {
                Toast.makeText(getContext(), R.string.product_not_saved, Toast.LENGTH_LONG).show();
            }
        });

        FloatingActionButton addProductButton = layout.findViewById(R.id.product_add_button);
        addProductButton.setOnClickListener(view -> {
            activityResultLauncher.launch(null);
        });

        RecyclerView recyclerView = layout.findViewById(R.id.product_recyclerview);
        final ProductListAdapter adapter = new ProductListAdapter(new ProductListAdapter.ProductDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        homeViewModel.getAllProducts().observe(getViewLifecycleOwner(), products -> {
            adapter.submitList(products);
        });
        return layout;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}