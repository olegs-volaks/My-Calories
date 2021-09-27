package com.g1a6iator.mycalories.ui.all_eaten_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.g1a6iator.mycalories.model.EatenFood;
import com.g1a6iator.mycalories.repository.EatenFoodRepository;

import java.util.List;

public class AllEatenFoodViewModel extends ViewModel {

    private final LiveData<List<EatenFood>> mEatenFoodList;
    private final EatenFoodRepository mEatenFoodRepository;

    public AllEatenFoodViewModel() {
        mEatenFoodRepository = new EatenFoodRepository();
        mEatenFoodList = mEatenFoodRepository.getAllDesc();
    }

    public LiveData<List<EatenFood>> getAllEatenFood() {
        return mEatenFoodList;
    }

    public void delete(EatenFood eatenFood) {
        mEatenFoodRepository.delete(eatenFood);
    }
}