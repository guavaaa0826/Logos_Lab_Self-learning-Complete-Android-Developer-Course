package com.company.chap22livedataexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int count = 0;
    private MutableLiveData<String> countLiveData = new MutableLiveData<>();

    // Return the LiveData according to count.
    public MutableLiveData<String> getText(boolean isInitial) {
        String val;
        if (!isInitial) {
            count++;
        }
        if (count <= 1) {
            val = "You clicked " + count + " time.";
        } else {
            val = "You clicked " + count + " times.";
        }
        countLiveData.setValue(val);
        return countLiveData;
    }

}
