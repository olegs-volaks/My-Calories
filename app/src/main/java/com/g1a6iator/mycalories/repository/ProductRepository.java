package com.g1a6iator.mycalories.repository;

import androidx.lifecycle.LiveData;

import com.g1a6iator.mycalories.MainApplication;
import com.g1a6iator.mycalories.dao.ProductDao;
import com.g1a6iator.mycalories.database.ApplicationDatabase;
import com.g1a6iator.mycalories.model.Product;

import java.util.List;

public class ProductRepository {

    private final ProductDao mProductDao;

    public ProductRepository() {
        ApplicationDatabase db = MainApplication.getInstance().getDatabase();
        mProductDao = db.productDao();
    }

    public LiveData<List<Product>> getAll() {
        return mProductDao.getAll();
    }

    public LiveData<Product> getById(long id) {
        return mProductDao.getById(id);
    }

    public void insert(Product product) {
        ApplicationDatabase.databaseWriteExecutor.execute(() -> mProductDao.insert(product));
    }

    public void delete(Product product) {
        ApplicationDatabase.databaseWriteExecutor.execute(() -> mProductDao.delete(product));
    }
}
