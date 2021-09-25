package com.g1a6iator.mycalories.repository;

import androidx.lifecycle.LiveData;

import com.g1a6iator.mycalories.MainApplication;
import com.g1a6iator.mycalories.dao.EatenFoodDao;
import com.g1a6iator.mycalories.database.ApplicationDatabase;
import com.g1a6iator.mycalories.model.EatenFood;

import java.util.List;

public class EatenFoodRepository {

    private EatenFoodDao mEatenFoodDao;

    public EatenFoodRepository() {
        ApplicationDatabase db = MainApplication.getInstance().getDatabase();
        mEatenFoodDao = db.eatenFoodDao();
    }

    public LiveData<List<EatenFood>> getAll() {
        return mEatenFoodDao.getAll();
    }

    public LiveData<EatenFood> getById(long id) {
        return mEatenFoodDao.getById(id);
    }

    public void insert(EatenFood eatenFood) {
        ApplicationDatabase.databaseWriteExecutor.execute(() -> mEatenFoodDao.insert(eatenFood));
    }

    public void delete(EatenFood eatenFood) {
        ApplicationDatabase.databaseWriteExecutor.execute(() -> mEatenFoodDao.delete(eatenFood));
    }
}
