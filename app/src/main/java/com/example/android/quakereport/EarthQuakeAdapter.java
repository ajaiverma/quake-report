package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthQuakeAdapter(@NonNull Context context, List<EarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
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

        TextView magnitude = view.findViewById(R.id.magnitude);
        magnitude.setText(currentEarthQuake.getMagnitude());

        String primaryLocation;
        String locationOffset;

        String originalLocation = currentEarthQuake.getLocation();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView locationOffsetView = view.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        TextView primaryLocationView = view.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        Date dateObject = new Date(currentEarthQuake.getTimeInMilliseconds());

        TextView date = view.findViewById(R.id.date);
        date.setText(formatDate(dateObject));

        TextView time = view.findViewById(R.id.time);
        time.setText(formatTime(dateObject));

        return view;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
