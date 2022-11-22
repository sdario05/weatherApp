package com.jig.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button listCitiesButton;
    private Button currentForecastButton;
    private final Integer LIST_ACTIVITY_REQUEST_CODE = 1915;
    private String currentCity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCitiesButton = findViewById(R.id.btn_cities);
        currentForecastButton = findViewById(R.id.btn_current_forecast);

        setListeners();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == LIST_ACTIVITY_REQUEST_CODE) {
                if (data != null) {
                    currentCity = data.getStringExtra("city_name");
                }
            }
        }
    }

    private void setListeners() {
        listCitiesButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivityForResult(intent, LIST_ACTIVITY_REQUEST_CODE);
        });
        currentForecastButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(Constants.CITY_NAME, currentCity);
            startActivity(intent);
        });
    }
}