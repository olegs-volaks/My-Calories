package com.g1a6iator.mycalories.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.g1a6iator.mycalories.model.EatenFood;

import java.util.List;

@Dao
public abstract class EatenFoodDao implements BaseDao<EatenFood> {

    @Query("SELECT * FROM eaten_foods")
    public abstract LiveData<List<EatenFood>> getAll();

    @Query("SELECT * FROM eaten_foods WHERE id = :id")
    public abstract LiveData<EatenFood> getById(long id);

    @Query("SELECT * FROM eaten_foods WHERE date > :millisFrom")
    public abstract LiveData<List<EatenFood>> getAllFrom(long millisFrom);

    @Query("SELECT SUM(totalCalories) FROM eaten_foods WHERE date > :millisFrom")
    public abstract LiveData<Double> getTotalCaloriesFrom(long millisFrom);
}
