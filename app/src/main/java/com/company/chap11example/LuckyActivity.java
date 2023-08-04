package com.company.chap11example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {

    TextView result, lucky;
    Button share;

    String userName;
    int lucky_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        result = findViewById(R.id.result1);
        lucky = findViewById(R.id.result2);
        share = findViewById(R.id.share);

        userName = getIntent().getStringExtra("userName");
        result.setText("Your name is " + userName + ".\nYour lucky number is");

        Random random = new Random();
        lucky_number = random.nextInt(999) + 1;
        lucky.setText("" + lucky_number);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We use implicit intent here.
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                // EXTRA_SUBJECT and EXTRA_TEXT work similarly
                // to the subject and the text of the email.
                String subject = userName + " is lucky today!";
                String text = "My lucky number is " + lucky_number;
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);

                // Intent.createChooser can create a window for the user to select the sharing platform.
                startActivity(Intent.createChooser(intent, "Choose a platform"));
            }
        });
    }
}