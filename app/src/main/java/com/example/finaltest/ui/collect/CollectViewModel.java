package com.example.finaltest.ui.collect;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CollectViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CollectViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is collect fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}