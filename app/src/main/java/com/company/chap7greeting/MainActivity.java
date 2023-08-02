package com.company.chap7greeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myEditText;
    Button myButton;
    TextView myTextView, counter;
    int counterNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = findViewById(R.id.editText);
        myButton = findViewById(R.id.button);
        myTextView = findViewById(R.id.textView);
        counter = findViewById(R.id.counter);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = myEditText.getText().toString();
                if (!name.equals("")) {
                    myEditText.setText("");
                    myTextView.setText("Hello, " + name + "!");
                    counterNum++;
                    counter.setText("Greeting count: " + counterNum);
                }
            }
        });
    }
}