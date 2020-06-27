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

        ArrayList<EarthQuake> earthQuakes = new ArrayList<>();
        earthQuakes.add(new EarthQuake("7.2", "San Francisco", "Feb 2, 2016"));
        earthQuakes.add(new EarthQuake("6.1", "London", "Feb 2, 2016"));
        earthQuakes.add(new EarthQuake("6.1", "Tokyo", "Feb 2, 2016"));
        earthQuakes.add(new EarthQuake("6.1", "Mexico City", "Feb 2, 2016"));
        earthQuakes.add(new EarthQuake("6.1", "Moscow", "Feb 2, 2016"));
        earthQuakes.add(new EarthQuake("6.1", "Rio de Janeiro", "Feb 2, 2016"));
        earthQuakes.add(new EarthQuake("6.1", "Paris", "Feb 2, 2016"));

        ListView earthQuakeList = findViewById(R.id.list);

        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthQuakes);

        earthQuakeList.setAdapter(adapter);
    }
}