package com.company.chap26example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.company.chap26example.adapter.CountryAdapter;
import com.company.chap26example.model.Country;
import com.company.chap26example.model.Result;
import com.company.chap26example.service.GetCountryDataService;
import com.company.chap26example.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Country> countries;
    private RecyclerView recyclerView;
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    public void getCountries() {
        GetCountryDataService service = RetrofitInstance.getService();
        Call<Result> call = service.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResult() != null) {
                    countries = (ArrayList<Country>) result.getResult();
                }

                viewData();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

    public void viewData() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CountryAdapter(countries);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}