package com.company.chap28example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Variables
    public final static String COUNT_GOAL = "count_goal";
    private Button button;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        // Once the work is defined, it must be scheduled with the WorkManager service in order to run.
        // WorkManager offers a lot of flexibility in how you schedule your work.
        // You can schedule it to run periodically over an interval of time,
        // or you can schedule it to run only one time.

        // However you choose to schedule the work, you should use a WorkRequest.
        // A Worker defines the unit of work, and a WorkRequest(and its subclasses) defines how and when it should run.
        // In the simplest case, you can use a OneTimeWorkRequest.

        //
        Data data = new Data.Builder()
                .putInt(COUNT_GOAL, 500)
                .build();

        // Constraints show under what circumstances the work can/cannot run.
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .build();

        WorkRequest countWorkRequest = new OneTimeWorkRequest.Builder(DemoWorker.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance(getApplicationContext()).enqueue(countWorkRequest);
            }
        });

        WorkManager.getInstance(getApplicationContext()).getWorkInfoByIdLiveData(countWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if (workInfo != null) {
                            Toast.makeText(getApplicationContext(), "Status: " + workInfo.getState().name(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}