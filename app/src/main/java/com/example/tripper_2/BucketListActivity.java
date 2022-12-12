package com.example.tripper_2;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BucketListActivity extends Fragment implements View.OnClickListener {

    private static final String TAG = "Activity 2";
    private static final int[] ACTION_ICON_IDS = {
            R.id.pin1,
            R.id.pin2,
            R.id.pin3
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bucketlist_fragment, container, false);
        for (int id : ACTION_ICON_IDS) {
            ImageView imageView = view.findViewById(id);
            imageView.setOnClickListener(this);
        }
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.pin1:
                AlertDialog.Builder d = new AlertDialog.Builder(view.getContext());
                d.setTitle(R.string.past_city_1);
                d.setMessage(R.string.cityDetail1);
                d.setPositiveButton(android.R.string.ok, null);
                d.show();
                break;
            case R.id.pin2:
                AlertDialog.Builder d2 = new AlertDialog.Builder(view.getContext());
                d2.setTitle(R.string.past_city_2);
                d2.setMessage(R.string.cityDetail2);
                d2.setPositiveButton(android.R.string.ok, null);
                d2.show();
                break;
            case R.id.pin3:
                AlertDialog.Builder d3 = new AlertDialog.Builder(view.getContext());
                d3.setTitle(R.string.past_city_3);
                d3.setMessage(R.string.cityDetail3);
                d3.setPositiveButton(android.R.string.ok, null);
                d3.show();
                break;
        }
    }
}