package com.g1a6iator.mycalories.ui.all_eaten_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllEatenFoodViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AllEatenFoodViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}