package com.company.chap8example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button convert;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        convert = findViewById(R.id.convert);
        result = findViewById(R.id.result);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 kilogram = 2.20462 pounds
                int kg = Integer.parseInt(editText.getText().toString());
                result.setVisibility(View.VISIBLE);
                result.setText("The weight in pounds is " + convertToPound(kg));
            }
        });
    }

    public double convertToPound(int kg) {
        return kg * 2.20462;
    }
}