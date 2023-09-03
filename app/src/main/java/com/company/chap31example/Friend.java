package com.company.chap31example;

public class Friend {
    // Variables
    private String name;
    private String email;

    // Constructor
    public Friend() {}

    public Friend(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Methods
    public String print() {
        String ret = "name = " + name + ", email = " + email;
        return ret;
    }
}
