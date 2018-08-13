package com.example.codingtest.codingapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.codingtest.codingapplication.domainobject.LocationDetail;

import java.util.List;

/**
 * SpinnerLocationListAdapter is ArrayAdapter to display data in Spinner
 */
public class SpinnerLocationListAdapter extends ArrayAdapter<LocationDetail> {
    private Context context;
    private List<LocationDetail> locationList;

    public SpinnerLocationListAdapter(@NonNull Context context, int resource, @NonNull List<LocationDetail> objects) {
        super(context, resource, objects);
        this.context = context;
        this.locationList = objects;
    }

    @Override
    public int getCount() {
        return locationList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public LocationDetail getItem(int position) {
        return locationList.get(position);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textview = (TextView) super.getView(position, convertView, parent);
        LocationDetail locationData = locationList.get(position);
        textview.setText(locationData.getName());
        return textview;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textview = (TextView) super.getDropDownView(position, convertView, parent);
        LocationDetail locationData = locationList.get(position);
        textview.setText(locationData.getName());
        return textview;
    }
}
