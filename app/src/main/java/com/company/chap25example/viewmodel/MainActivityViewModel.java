package com.company.chap25example.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.company.chap25example.MainActivity;
import com.company.chap25example.model.Category;
import com.company.chap25example.model.Course;
import com.company.chap25example.model.CourseShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    // Repository
    private CourseShopRepository repository;

    // LiveData
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> courseOfSelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = repository.getCategories();
        return allCategories;
    }
    public LiveData<List<Course>> getCourseOfSelectedCategory(int categoryId) {
        courseOfSelectedCategory = repository.getCourses(categoryId);
        return courseOfSelectedCategory;
    }

    public void addNewCourse(Course course) {
        repository.insertCourse(course);
    }
    public void updateCourse(Course course) {
        repository.updateCourse(course);
    }
    public void deleteCourse(Course course) {
        repository.deleteCourse(course);
    }
}
