package com.company.chap28example;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DemoWorker extends Worker {

    // Constructor
    public DemoWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    // Methods
    @NonNull
    @Override
    public Result doWork() {
        // Count the number.
        Data data = getInputData();
        int count_goal = data.getInt(MainActivity.COUNT_GOAL, 300);

        for (int i = 1; i <= count_goal; i++) {
            Log.i("COUNT", "Counting to " + i + ".");
        }

        return Result.success();
        // Result.success(): The work finished successfully.
        // Result.failure(): The work failed.
        // Result.retry(): The work failed and should be retried another time.
    }
}
