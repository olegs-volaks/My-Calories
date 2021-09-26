package com.g1a6iator.mycalories.ui.product;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.g1a6iator.mycalories.model.EatenFood;
import com.g1a6iator.mycalories.model.Product;
import com.g1a6iator.mycalories.repository.EatenFoodRepository;
import com.g1a6iator.mycalories.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private final LiveData<List<Product>> mProducts;
    private final ProductRepository mProductRepository;
    private final EatenFoodRepository mEatenFoodRepository;

    public ProductViewModel() {
        mProductRepository = new ProductRepository();
        mEatenFoodRepository = new EatenFoodRepository();
        mProducts = mProductRepository.getAll();
    }

    public LiveData<List<Product>> getAllProducts() {
        return mProducts;
    }

    public void insert(Product product) {
        mProductRepository.insert(product);
    }

    public void delete(Product product) {
        mProductRepository.delete(product);
    }

    public void addProductToEatenFood(EatenFood eatenFood) {
        mEatenFoodRepository.insert(eatenFood);
    }
}