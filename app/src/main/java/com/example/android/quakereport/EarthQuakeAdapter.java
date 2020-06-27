package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    //ArrayList<EarthQuake> mEarthQuakes = new ArrayList<>();

    public EarthQuakeAdapter(@NonNull Context context, List<EarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
        //mEarthQuakes = earthQuakes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list, parent, false
            );
        }

        EarthQuake currentEarthQuake = getItem(position);

        TextView magTextView = view.findViewById(R.id.magnitude);
        magTextView.setText(currentEarthQuake.getMagnitude());

        TextView cityTextView = view.findViewById(R.id.location);
        cityTextView.setText(currentEarthQuake.getLocation());

        TextView dateTextView = view.findViewById(R.id.date);
        dateTextView.setText(currentEarthQuake.getDate());

        return view;
    }
}
