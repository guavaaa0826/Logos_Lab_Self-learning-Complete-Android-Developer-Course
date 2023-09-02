package com.company.chap30example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondActivity extends AppCompatActivity {
    // Variables
    private DatabaseReference prices, goldPrice, diamondPrice, emeraldPrice, rubyPrice;
    private TextView gold, diamond, emerald, ruby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // initialize
        prices = FirebaseDatabase.getInstance().getReference("Prices");
        goldPrice = prices.child("GoldPrice");
        diamondPrice = prices.child("DiamondPrice");
        emeraldPrice = prices.child("EmeraldPrice");
        rubyPrice = prices.child("RubyPrice");
        gold = findViewById(R.id.textViewGold);
        diamond = findViewById(R.id.textViewDiamond);
        emerald = findViewById(R.id.textViewEmerald);
        ruby = findViewById(R.id.textViewRuby);

        // Reading data from the database
        prices.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int index = 1;
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    if (index == 1) {
                        gold.setText("Gold price is " + dataSnapshot.getValue().toString());
                    } else if (index == 2) {
                        diamond.setText("Diamond price is " + dataSnapshot.getValue().toString());
                    } else if (index == 3) {
                        emerald.setText("Emerald price is " + dataSnapshot.getValue().toString());
                    } else if (index == 4) {
                        ruby.setText("Ruby price is " + dataSnapshot.getValue().toString());
                    }
                    index++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}