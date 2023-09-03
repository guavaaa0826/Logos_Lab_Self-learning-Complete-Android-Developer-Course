package com.company.chap31example;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // Variables
    // Widgets
    private EditText editName, editEmail;
    private Button save, saveNew;
    private Button get, getAll;
    private Button delete;
    private Button updateName, updateEmail;
    private TextView info;
    // Database
    // The top-levels are called "collection", while lower levels are called "document".
    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    private CollectionReference userRef = database.collection("Users");
    private DocumentReference friendRef = userRef.document("Friends");
    // Keys
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widgets initialization
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.edtEmail);
        save = findViewById(R.id.buttonSave);
        saveNew = findViewById(R.id.buttonSaveNew);
        get = findViewById(R.id.buttonGet);
        getAll = findViewById(R.id.buttonGetAll);
        delete = findViewById(R.id.buttonDelete);
        info = findViewById(R.id.textViewInfo);
        updateName = findViewById(R.id.buttonUpdateName);
        updateEmail = findViewById(R.id.buttonUpdateEmail);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToFirebase();
            }
        });
        saveNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveObjectToFirebaseNew();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromFirebase();
            }
        });
        getAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllDataFromFirebase();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDataFromFirebase();
            }
        });

        updateName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDataToFirebase(KEY_NAME);
            }
        });
        updateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDataToFirebase(KEY_EMAIL);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Listening to data change
        friendRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(MainActivity.this, "Error found: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    String name = value.getString(KEY_NAME), email = value.getString(KEY_EMAIL);
                    info.setText("Name = " + name  + "\nEmail = " + email);
                    Toast.makeText(MainActivity.this, "Data updated.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Save data to Firebase.
    private void saveDataToFirebase() {
        String name = editName.getText().toString().trim(), email = editEmail.getText().toString().trim();
        editName.setText("");
        editEmail.setText("");

        Map<String, Object> data = new HashMap<>();
        data.put(KEY_NAME, name);
        data.put(KEY_EMAIL, email);

        friendRef.set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "Save to Firebase successfully.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Save new data(Object) to Firebase.
    private void saveObjectToFirebaseNew() {
        String name = editName.getText().toString().trim(), email = editEmail.getText().toString().trim();
        Friend friend = new Friend(name, email);

        userRef.add(friend);
    }

    // Get data from Firebase.
    private void getDataFromFirebase() {
        friendRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            editName.setText(documentSnapshot.getString(KEY_NAME));
                            editEmail.setText(documentSnapshot.getString(KEY_EMAIL));
                            Toast.makeText(getApplicationContext(), "Data get successfully.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "No data exists.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Get all data from Firebase. Show the data using Log.
    private void getAllDataFromFirebase() {
        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot snapshot: queryDocumentSnapshots) {
                            Friend temp = snapshot.toObject(Friend.class);
                            Log.i("getAllDataFromFirebase", temp.print());
                        }
                    }
                });
    }

    // Delete data from Firebase.
    private void deleteDataFromFirebase() {
        friendRef.delete();
        // You can also delete the data by deleting them respectively.
        // friendRef.update(KEY_NAME, FieldValue.delete());
        // friendRef.update(KEY_EMAIL, FieldValue.delete());
    }

    // Update data To Firebase.
    private void updateDataToFirebase(String key) {
        Map<String, Object> data;
        switch (key) {
            case KEY_NAME:
                String name = editName.getText().toString().trim();
                editName.setText("");

                data = new HashMap<>();
                data.put(KEY_NAME, name);

                friendRef.update(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(), "Name update to Firebase successfully.", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case KEY_EMAIL:
                String email = editEmail.getText().toString().trim();
                editEmail.setText("");

                data = new HashMap<>();
                data.put(KEY_EMAIL, email);

                friendRef.update(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(), "Email update to Firebase successfully.", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            default:
        }
    }
}