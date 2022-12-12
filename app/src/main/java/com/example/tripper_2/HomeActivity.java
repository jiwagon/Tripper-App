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

    private Adapter recyclerViewAdapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        //Adapter recyclerViewAdapter = new Adapter(getContext(), R.layout.home_fragment);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
