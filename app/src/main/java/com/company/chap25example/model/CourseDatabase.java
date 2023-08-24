package com.company.chap25example.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

@Database(entities = {Category.class, Course.class}, version = 1)
public abstract class CourseDatabase extends RoomDatabase {

    public abstract CategoryDAO categoryDAO();
    public abstract CourseDAO courseDAO();

    // Singleton pattern
    private static CourseDatabase instance;
    public static synchronized CourseDatabase getInstance(Context context) {
        // Make sure we don't create multiple database.
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CourseDatabase.class,
                    "courses_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            initialize();
        }
    };

    private static void initialize() {
        CourseDAO courseDAO = instance.courseDAO();
        CategoryDAO categoryDAO = instance.categoryDAO();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // Initial data
                // Categories
                Category category1 = new Category("Failure Management", "Very effective.");
                Category category2 = new Category("Asian Cooking", "Fuiyoh!");

                categoryDAO.insert(category1);
                categoryDAO.insert(category2);

                // Courses
                Course course1 = new Course("How to Deal Emotional Damage", "6666$",1);
                Course course2 = new Course("How to Use Slippers", "2222$", 1);
                Course course3 = new Course("How to use Nunchuk", "2222$", 1);

                Course course4 = new Course("How to Make Egg Fries Rice", "1000$",2);
                Course course5 = new Course("How to Use MSG, the King of Flavor", "1000$", 2);
                Course course6 = new Course("How to Diss Jamie Oliver", "1000$", 2);

                courseDAO.insert(course1);
                courseDAO.insert(course2);
                courseDAO.insert(course3);
                courseDAO.insert(course4);
                courseDAO.insert(course5);
                courseDAO.insert(course6);
            }
        });

    }
}
