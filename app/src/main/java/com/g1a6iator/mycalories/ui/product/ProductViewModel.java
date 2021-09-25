package com.g1a6iator.mycalories.ui.product;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.g1a6iator.mycalories.model.Product;
import com.g1a6iator.mycalories.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private final LiveData<List<Product>> mProducts;
    private final ProductRepository mProductRepository;

    public ProductViewModel() {
        mProductRepository = new ProductRepository();
        mProducts = mProductRepository.getAll();
    }

    public LiveData<List<Product>> getAllProducts() {
        return mProducts;
    }

    public void insert(Product product) {
        mProductRepository.insert(product);
    }
}