package com.jig.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button listCitiesButton;
    private Button currentForecastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCitiesButton = findViewById(R.id.btn_cities);
        currentForecastButton = findViewById(R.id.btn_current_forecast);

        setListeners();
    }

    private void setListeners() {
        listCitiesButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        });
        currentForecastButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });
    }
}