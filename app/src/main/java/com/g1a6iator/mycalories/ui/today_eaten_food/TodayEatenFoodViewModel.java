package com.g1a6iator.mycalories.ui.today_eaten_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodayEatenFoodViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TodayEatenFoodViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}