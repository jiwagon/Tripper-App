package com.example.tripper_2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class DocumentsActivity extends Fragment implements View.OnClickListener {

        private static final int[] ACTION_IMAGE_IDS = {
                R.id.i20_image,
                R.id.visa_image,
                R.id.i94_image,
                R.id.camera_image
        };
        private static final String TAG = "Activity 4";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView imageView = (ImageView) getView().findViewById(android.R.id.content);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.docs_fragment, container, false);
        for (int id : ACTION_IMAGE_IDS) {
            ImageView imageView = view.findViewById(id);
            imageView.setOnClickListener(this);
        }
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.i20_image){
            Snackbar snackbar = Snackbar
                    .make(view, R.string.i20_detail, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(id == R.id.visa_image){
            Snackbar snackbar = Snackbar
                    .make(view, R.string.visa_detail, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(id == R.id.i94_image){
            Snackbar snackbar = Snackbar
                    .make(view, R.string.i94_detail, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(id == R.id.camera_image){
            AlertDialog.Builder d = new AlertDialog.Builder(view.getContext());
            d.setTitle(R.string.camera_hint_text);
            d.setMessage(R.string.camera_hint_message);
            d.setPositiveButton(android.R.string.ok, null);
            d.show();
        }
        else
            Log.d(TAG, "Unknown ID: " + id);
    }
}