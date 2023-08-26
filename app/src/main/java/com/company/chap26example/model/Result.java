package com.company.chap26example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

// This is the class of the outermost layer of the returned JSON data.
@Generated("jsonschema2pojo")
public class Result {
    // Variables
    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("result")
    @Expose
    private List<Country> result;

    @SerializedName("extra")
    @Expose
    private List<Object> extra;

    // Getters & Setters
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Country> getResult() {
        return result;
    }
    public void setResult(List<Country> countryList) {
        this.result = countryList;
    }

    public List<Object> getExtra() {
        return extra;
    }
    public void setExtra(List<Object> extra) {
        this.extra = extra;
    }
}
