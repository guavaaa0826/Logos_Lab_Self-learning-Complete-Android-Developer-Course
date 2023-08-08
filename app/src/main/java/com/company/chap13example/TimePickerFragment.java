package com.company.chap13example;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
    implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String minute_str;
        if (minute < 10) {
            minute_str = "0" + minute;
        } else {
            minute_str = "" + minute;
        }
        String message = "You pick " + hourOfDay + ":" + minute_str;
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
