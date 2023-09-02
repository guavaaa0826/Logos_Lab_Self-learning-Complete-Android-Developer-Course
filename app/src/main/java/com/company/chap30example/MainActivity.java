package com.company.chap30example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Android Debug Key
// MD5: 91:AE:CC:A7:0E:EF:FF:6F:A1:6C:86:33:EC:B1:04:E0
// SHA1: E2:29:9B:71:B0:90:64:A7:9F:20:C4:04:43:2E:38:EF:37:96:59:A8
// SHA-256: B6:47:BA:13:E5:46:9C:4D:CC:9E:59:96:55:82:3D:46:BA:9D:5D:27:09:9E:15:62:B6:01:F3:0B:73:24:72:E7

// https://stackoverflow.com/questions/67405791/gradle-tasks-are-not-showing-in-the-gradle-tool-window-in-android-studio-4-2

public class MainActivity extends AppCompatActivity {
    // Variables
    private FirebaseDatabase firebase;
    private DatabaseReference users;
    private Button login;
    private EditText userName, passWord;
    private UserData user;
    private static int userNum = 0;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        firebase = FirebaseDatabase.getInstance();

        login = findViewById(R.id.buttonLogin);
        userName = findViewById(R.id.editUsername);
        passWord = findViewById(R.id.editPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = userName.getText().toString(), passwordText = passWord.getText().toString();
                if (!nameText.equals("") && !passwordText.equals("")) {
                    // Write data to database
                    user = new UserData(nameText, passwordText);
                    users = firebase.getReference("Users");
                    users.child("User" + (++userNum)).setValue(user);

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else if (nameText.equals("")) {
                    Toast.makeText(getApplicationContext(), "Name field cannot be empty.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Password field cannot be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}