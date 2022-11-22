package com.jig.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private int resourceLayout;
    private Context context;


    public MyAdapter(@NonNull Context context, int resource, List<String> list) {
        super(context, resource, list);
        this.resourceLayout = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }

        String p = getItem(position);

        if (p != null) {
            TextView cityName = v.findViewById(R.id.txt_name);
            cityName.setText(p);
        }

        return v;
    }
}
