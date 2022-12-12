package com.example.tripper_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
*/

public class HomeActivity extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Guide> guideArraylist;
    private int[] imageResourceID;
    private String[] textID;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialized();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), guideArraylist);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void dataInitialized() {
        guideArraylist = new ArrayList<>();

        textID = new String[] {
                getString(R.string.text1),
                getString(R.string.text2),
                getString(R.string.text3),
                getString(R.string.text4),
        };

        imageResourceID = new int[] {
                R.drawable.project_pic1,
                R.drawable.blooddonate,
                R.drawable.homepage_background,
                R.drawable.doc_visa,
        };
        for (int i = 0; i < textID.length; i++) {
            Guide guides = new Guide(textID[i], imageResourceID[i]);
            guideArraylist.add(guides);
        }
    }
}
