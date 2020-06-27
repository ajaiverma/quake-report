package com.example.android.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ArrayList<String> earthQuakes = new ArrayList<>();
        earthQuakes.add("San Francisco");
        earthQuakes.add("London");
        earthQuakes.add("Tokyo");
        earthQuakes.add("Mexico City");
        earthQuakes.add("Moscow");
        earthQuakes.add("Rio de Janeiro");
        earthQuakes.add("Paris");

        ListView earthQuakeList = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, earthQuakes);

        earthQuakeList.setAdapter(adapter);
    }
}