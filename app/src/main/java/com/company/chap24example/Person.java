package com.company.chap24example;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Person extends BaseObservable {

    // Variables
    private String name;
    private String email;

    // Constructors
    public Person() {}

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
