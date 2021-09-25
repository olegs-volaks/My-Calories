package com.g1a6iator.mycalories.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.g1a6iator.mycalories.model.Product;

import java.util.List;

@Dao
public abstract class ProductDao implements BaseDao<Product> {

    @Query("SELECT * FROM products")
    public abstract LiveData<List<Product>> getAll();

    @Query("SELECT * FROM products WHERE id = :id")
    public abstract LiveData<Product> getById(long id);
}
