package com.jig.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView myListView = findViewById(R.id.lv_cities);
        List<String> list = new ArrayList<>();
        list.add("Bolívar");
        list.add("El Palomar");
        list.add("Lanús");
        list.add("Lomas de Zamora");
        list.add("Mar del Plata");
        MyAdapter citiesAdapter = new MyAdapter(this, R.layout.list_item, list);
        myListView.setAdapter(citiesAdapter);
        myListView.setOnItemClickListener((adapterView, view, position, l) -> {
            Intent data = new Intent();
            data.putExtra(Constants.CITY_NAME, list.get(position));
            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }
}
