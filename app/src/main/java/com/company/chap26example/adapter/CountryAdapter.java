package com.company.chap26example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.chap26example.R;
import com.company.chap26example.model.Country;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<Country> countries;

    public CountryAdapter(ArrayList<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CountryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.textView.setText(countries.get(position).getName());
    }
    @Override
    public int getItemCount() {
        if (countries != null) {
            return countries.size();
        }
        return 0;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.country_TextView);
        }
    }
}
