package com.company.chap26example.service;

import com.company.chap26example.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    @GET("countries")
    Call<Result> getResult();

}
