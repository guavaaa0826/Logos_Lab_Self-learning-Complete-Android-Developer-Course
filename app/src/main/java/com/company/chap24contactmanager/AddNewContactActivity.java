package com.company.chap24contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.company.chap24contactmanager.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding activityAddNewContactBinding;
    private AddNewContactActivityClickHandler handlers;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contact = new Contact();
        activityAddNewContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);
        activityAddNewContactBinding.setContact(contact);

        handlers = new AddNewContactActivityClickHandler(this);
        activityAddNewContactBinding.setClickHandler(handlers);
    }

    public class AddNewContactActivityClickHandler {
        Context context;

        public AddNewContactActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view) {
            if (contact.getName() == null) {
                Toast.makeText(getApplicationContext(), "Enter the name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("NAME", contact.getName());
                intent.putExtra("EMAIL", contact.getEmail());

                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}