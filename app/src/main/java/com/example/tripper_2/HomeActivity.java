package com.example.tripper_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
*/

public class HomeActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    private ArrayList<Guide> guideArraylist;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialized();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), guideArraylist);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.homepage_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.logout:
                Intent LoginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(LoginIntent);
                break;
        }

        return false;
    }

    private void dataInitialized() {
        guideArraylist = new ArrayList<>();

        String[] textID = new String[]{
                getString(R.string.text1),
                getString(R.string.text2),
                getString(R.string.text3),
                getString(R.string.text4),
                getString(R.string.text1),
                getString(R.string.text2),
                getString(R.string.text7),
                getString(R.string.text8),
        };

        int[] imageResourceID = new int[]{
                R.drawable.rv_pic1,
                R.drawable.rv_pic1,
                R.drawable.homepage_background,
                R.drawable.rv_pic1,
                R.drawable.doc_visa,
                R.drawable.rv_pic8,
                R.drawable.rv_pic8,
                R.drawable.rv_pic8,
        };
        for (int i = 0; i < textID.length; i++) {
            Guide guides = new Guide(textID[i], imageResourceID[i]);
            guideArraylist.add(guides);
        }
    }
}
