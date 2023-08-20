package com.company.chap24example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.company.chap24example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    TextView namePerson, emailPerson;
    private ActivityMainBinding activityMainBinding;
    private ClickHandler mainActivityClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namePerson = findViewById(R.id.name);
        emailPerson = findViewById(R.id.email);

        Person me = new Person("Guavaaa", "poyiwu0826@gmail.com");

        // Binding with the TextView
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setPerson(me);

        // Binding with the click handler
        mainActivityClickHandler = new ClickHandler(this, me);
        activityMainBinding.setClickHandler(mainActivityClickHandler);
    }

    public class ClickHandler{
        Context context;
        Person me;

        public ClickHandler(Context context, Person me) {
            this.context = context;
            this.me = me;
        }

        public void greetButtonClicked(View view) {

            Toast.makeText(this.context, "Hello, " + me.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}