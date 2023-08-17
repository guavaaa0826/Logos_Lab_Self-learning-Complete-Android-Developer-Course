package com.company.chap22livedataexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        LiveData<String> display = mainActivityViewModel.getText(true);
        display.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                textView.setText(string);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.getText(false);
            }
        });
    }
}