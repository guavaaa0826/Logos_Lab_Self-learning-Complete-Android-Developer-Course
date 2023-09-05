package com.company.chap32example.util;

import com.google.firebase.Timestamp;

public class Journal {
    // Variables
    private String title;
    private String thought;
    private String imageUrl;

    private String userId;
    private String username;
    private Timestamp timestamp;

    // Constructors
    public Journal() {}

    public Journal(String title, String thought, String imageUrl, String userId, String username, Timestamp timestamp) {
        this.title = title;
        this.thought = thought;
        this.imageUrl = imageUrl;
        this.userId = userId;
        this.username = username;
        this.timestamp = timestamp;
    }

    // Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getThought() {
        return thought;
    }
    public void setThought(String thought) {
        this.thought = thought;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
