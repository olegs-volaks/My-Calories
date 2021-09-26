package com.g1a6iator.mycalories.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.adapter.ProductListAdapter;
import com.g1a6iator.mycalories.databinding.FragmentProductBinding;
import com.g1a6iator.mycalories.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProductFragment extends Fragment {

    private ProductViewModel productViewModel;
    private FragmentProductBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                new ViewModelProvider(this).get(ProductViewModel.class);

        binding = FragmentProductBinding.inflate(inflater, container, false);
        View layout = binding.getRoot();
        ActivityResultLauncher<Integer> newProductActivityLauncher = registerForActivityResult(new NewProductActivityContract(), result -> {
            if (result != null) {
                productViewModel.insert(result);
            } else {
                Toast.makeText(getContext(), R.string.product_not_saved, Toast.LENGTH_LONG).show();
            }
        });

        ActivityResultLauncher<Product> addProductToEatenFoodActivityLauncher = registerForActivityResult(new AddProductToEatenFoodActivityContract(), result -> {
            productViewModel.addProductToEatenFood(result);
        });

        FloatingActionButton addProductButton = layout.findViewById(R.id.product_add_button);
        addProductButton.setOnClickListener(view -> {
            newProductActivityLauncher.launch(null);
        });

        RecyclerView recyclerView = layout.findViewById(R.id.product_recyclerview);
        final ProductListAdapter adapter = new ProductListAdapter(new ProductListAdapter.ProductDiff(), new ProductListAdapter.ProductOnClickListener() {
            @Override
            public void onDelete(Product product) {
                productViewModel.delete(product);
            }

            @Override
            public void onItemClick(Product product) {
                addProductToEatenFoodActivityLauncher.launch(product);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        productViewModel.getAllProducts().observe(getViewLifecycleOwner(), products -> {
            adapter.submitList(products);
        });
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        return layout;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}