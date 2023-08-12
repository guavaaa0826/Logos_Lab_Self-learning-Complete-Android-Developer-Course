package com.company.chap20example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    String FILENAME = "mySP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        DisplaySavedText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                displayAndSaveText(input);
            }
        });
    }

    private void DisplaySavedText() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILENAME, MODE_PRIVATE);

        String text = sharedPreferences.getString("input", "");
        textView.setText(text);
    }

    private void displayAndSaveText(String input) {
        textView.setText(input);
        SharedPreferences sharedPreferences = getSharedPreferences(FILENAME, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("input", input);

        editor.commit();
    }
}