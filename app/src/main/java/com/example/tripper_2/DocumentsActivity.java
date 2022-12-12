package com.example.tripper_2;

import android.os.Bundle;

import androidx.annotation.Nullable;
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
 * Use the {@link DocumentsActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DocumentsActivity extends Fragment implements View.OnClickListener {

        private static final int[] ACTION_IMAGE_IDS = {
                R.id.i20_image,
                R.id.visa_image,
                R.id.i94_image
        };
        private static final String TAG = "Activity 4";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView imageView = (ImageView) getView().findViewById(android.R.id.content);
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DocumentsActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment docs_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DocumentsActivity newInstance(String param1, String param2) {
        DocumentsActivity fragment = new DocumentsActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int id : ACTION_IMAGE_IDS) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.i20_image){
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), R.string.i20_detail, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(id == R.id.visa_image){
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), R.string.visa_detail, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(id == R.id.i94_image){
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), R.string.i94_detail, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else
            Log.d(TAG, "Unknown ID: " + id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.docs_fragment, container, false);
    }
}