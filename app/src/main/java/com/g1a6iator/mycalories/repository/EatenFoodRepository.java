package com.g1a6iator.mycalories.repository;

import androidx.lifecycle.LiveData;

import com.g1a6iator.mycalories.MainApplication;
import com.g1a6iator.mycalories.dao.EatenFoodDao;
import com.g1a6iator.mycalories.database.ApplicationDatabase;
import com.g1a6iator.mycalories.model.EatenFood;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public LiveData<List<EatenFood>> getAllToday() {
        return mEatenFoodDao.getAllFrom(getTodayMidnightInMillis());
    }

    public LiveData<Double> getTotalCaloriesToday() {
        return mEatenFoodDao.getTotalCaloriesFrom(getTodayMidnightInMillis());
    }

    private long getTodayMidnightInMillis() {
        Calendar todayMidnight = new GregorianCalendar();
        todayMidnight.set(Calendar.HOUR_OF_DAY, 0);
        todayMidnight.set(Calendar.MINUTE, 0);
        todayMidnight.set(Calendar.SECOND, 0);
        todayMidnight.set(Calendar.MILLISECOND, 0);
        return todayMidnight.getTimeInMillis();
    }
}
