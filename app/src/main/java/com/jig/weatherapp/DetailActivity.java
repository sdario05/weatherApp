package com.jig.weatherapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String cityName = getIntent().getStringExtra(Constants.CITY_NAME);
        ((TextView)findViewById(R.id.txt_name_value)).setText(cityName);
    }
}