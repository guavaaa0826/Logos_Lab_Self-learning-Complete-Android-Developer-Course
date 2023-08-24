package com.company.chap25example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.company.chap25example.databinding.ActivityAddEditBinding;
import com.company.chap25example.model.Course;

public class AddEditActivity extends AppCompatActivity {

    private Course course;
    public static final String COURSE_ID = "courseId";
    public static final String COURSE_NAME = "courseName";
    public static final String UNIT_PRICE = "unitPrice";
    private ActivityAddEditBinding activityAddEditBinding;
    private AddEditActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        course = new Course();
        handler = new AddEditActivityClickHandler(this);
        activityAddEditBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit);
        activityAddEditBinding.setCourse(course);
        activityAddEditBinding.setClickHandler(handler);

        Intent intent = getIntent();
        if (intent.hasExtra(COURSE_ID)) {
            setTitle("Edit course");
            course.setCourseName(intent.getStringExtra(COURSE_NAME));
            course.setUnitPrice(intent.getStringExtra(UNIT_PRICE));
        } else {
            setTitle("Add course");
        }
    }

    public class AddEditActivityClickHandler {
        private Context context;

        public AddEditActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSubmit(View view) {
            if (course.getCourseName() == null) {
                Toast.makeText(this.context, "Enter the name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra(COURSE_NAME, course.getCourseName());
                intent.putExtra(UNIT_PRICE, course.getUnitPrice());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}