package com.company.chap25example;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.company.chap25example.databinding.ActivityMainBinding;
import com.company.chap25example.model.Category;
import com.company.chap25example.model.Course;
import com.company.chap25example.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private ArrayList<Category> categoriesList;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler handler;
    private Category selectedCategory;

    // RecyclerView
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private ArrayList<Course> courses;

    // Intent
    private static final int ADD_COURSE_REQUEST_CODE = 1;
    private static final int EDIT_COURSE_REQUEST_CODE = 2;
    public int selectedCourseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        handler = new MainActivityClickHandler();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setClickHandler(handler);

        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoriesList = (ArrayList<Category>) categories;

                for (Category category: categories) {
                    Log.i("TAG", category.getCategoryName());
                }

                showOnSpinner();
            }
        });

        mainActivityViewModel.getCourseOfSelectedCategory(1).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                for (Course course: courses) {
                    Log.v("TAG", course.getCourseName());
                }
            }
        });
    }

    public void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(
                this, R.layout.spinner_item, categoriesList
        );
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    public void loadCoursesArrayList(int categoryId) {
        mainActivityViewModel.getCourseOfSelectedCategory(categoryId).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courseList) {
                courses = (ArrayList) courseList;
                loadRecyclerView();
            }
        });
    }
    public void loadRecyclerView() {
        recyclerView = activityMainBinding.secondaryLayout.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        courseAdapter = new CourseAdapter();
        recyclerView.setAdapter(courseAdapter);
        courseAdapter.setCourses(courses);

        // Update course
        courseAdapter.setListener(new CourseAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(Course course) {
                selectedCourseId = course.getCourseId();
                Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
                intent.putExtra(AddEditActivity.COURSE_ID, selectedCourseId);
                intent.putExtra(AddEditActivity.COURSE_NAME, course.getCourseName());
                intent.putExtra(AddEditActivity.UNIT_PRICE, course.getUnitPrice());
                startActivityForResult(intent, EDIT_COURSE_REQUEST_CODE);
            }
        });

        // Delete course
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Course courseDelete = courses.get(viewHolder.getAdapterPosition());
                mainActivityViewModel.deleteCourse(courseDelete);
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int selectCategoryId = selectedCategory.getId();

        if (requestCode == ADD_COURSE_REQUEST_CODE && resultCode == RESULT_OK) {
            Course course = new Course();
            course.setCategoryId(selectCategoryId);
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));

            mainActivityViewModel.addNewCourse(course);
        } else if (requestCode == EDIT_COURSE_REQUEST_CODE && resultCode == RESULT_OK) {
            Course course = new Course();
            course.setCategoryId(selectCategoryId);
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            course.setCourseId(selectedCourseId);

            mainActivityViewModel.updateCourse(course);
        }
    }

    public class MainActivityClickHandler {
        public void onFABClicked(View view) {
            Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
            startActivityForResult(intent, ADD_COURSE_REQUEST_CODE);
        }

        public void onSelectItem(AdapterView<?> parent, View view, int position, long id) {
            selectedCategory = (Category) parent.getItemAtPosition(position);

            String message = "The ID is: " + selectedCategory.getId()
                    + "\nThe name is: " + selectedCategory.getCategoryName() + ".";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

            loadCoursesArrayList(selectedCategory.getId());
        }
    }
}