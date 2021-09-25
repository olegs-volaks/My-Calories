package com.g1a6iator.mycalories.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.g1a6iator.mycalories.model.Product;
import com.g1a6iator.mycalories.repository.ProductRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final LiveData<List<Product>> mProducts;
    private final ProductRepository mProductRepository;

    public HomeViewModel() {
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