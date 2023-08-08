package com.company.chap13example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button pickTime, pickDate, progress;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickTime = findViewById(R.id.pickTime);
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.show(getSupportFragmentManager(), "Pick Your Time");
            }
        });

        pickDate = findViewById(R.id.pickDate);
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getSupportFragmentManager(), "Pick Your Date.");
            }
        });

        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);

        progress = findViewById(R.id.progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(1);
            }
        });
    }
}