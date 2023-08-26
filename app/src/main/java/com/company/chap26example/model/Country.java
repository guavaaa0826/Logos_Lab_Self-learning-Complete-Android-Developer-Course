package com.company.chap26example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

// This is the object in the result of Result.
@Generated("jsonschema2pojo")
public class Country {
    // Variables
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("states")
    @Expose
    private Object states;

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Object getStates() {
        return states;
    }
    public void setStates(Object states) {
        this.states = states;
    }
}
