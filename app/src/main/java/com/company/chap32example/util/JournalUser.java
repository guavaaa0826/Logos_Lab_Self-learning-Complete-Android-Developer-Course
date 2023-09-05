package com.company.chap32example.util;

import android.app.Application;

public class JournalUser extends Application {
    // Variables
    private String userId;
    private String username;
    private static JournalUser instance;

    // Constructor
    public JournalUser() {}

    // Method
    // Singleton getInstance
    public static JournalUser getInstance() {
        if (instance == null) {
            instance = new JournalUser();
        }
        return instance;
    }

    // Getters & Setters
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
