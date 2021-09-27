package com.g1a6iator.mycalories.ui.today_eaten_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.g1a6iator.mycalories.model.EatenFood;
import com.g1a6iator.mycalories.repository.EatenFoodRepository;

import java.util.List;

public class TodayEatenFoodViewModel extends ViewModel {

    private final LiveData<Double> mCaloriesToday;
    private final LiveData<List<EatenFood>> mTodayEatenFoodList;
    private final EatenFoodRepository mEatenFoodRepository;

    public TodayEatenFoodViewModel() {
        mEatenFoodRepository = new EatenFoodRepository();
        mCaloriesToday = mEatenFoodRepository.getTotalCaloriesToday();
        mTodayEatenFoodList = mEatenFoodRepository.getAllTodayDesc();
    }

    public LiveData<Double> getCaloriesToday() {
        return mCaloriesToday;
    }

    public LiveData<List<EatenFood>> getTodayEatenFoodList() {
        return mTodayEatenFoodList;
    }

    public void delete(EatenFood eatenFood) {
        mEatenFoodRepository.delete(eatenFood);
    }
}