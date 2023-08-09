package com.company.chap14example;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pronounce(View view) {

        Button clickedButton = (Button)view;
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this, getResources().getIdentifier(
                        clickedButton.getTag().toString(), "raw", getPackageName())
        );

        mediaPlayer.start();

    }
}