package com.company.chap22example;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int clickTime = 0;

    // Return the text when the app is launched.
    public String getText() {
        String ret;
        if (clickTime <= 1) {
            ret = "You clicked " + clickTime + " time.";
        } else {
            ret = "You clicked " + clickTime + " times.";
        }
        return ret;
    }

    // Return the text when the button is clicked.
    public String getTextIncrement() {
        String ret;
        clickTime++;
        if (clickTime == 1) {
            ret = "You clicked " + clickTime + " time.";
        } else {
            ret = "You clicked " + clickTime + " times.";
        }
        return ret;
    }

}
