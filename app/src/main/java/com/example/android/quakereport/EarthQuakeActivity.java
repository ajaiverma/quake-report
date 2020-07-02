package com.example.android.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ListView earthQuakeList = findViewById(R.id.list);

        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, QueryUtils.extractEarthQuakes());

        earthQuakeList.setAdapter(adapter);
    }
}