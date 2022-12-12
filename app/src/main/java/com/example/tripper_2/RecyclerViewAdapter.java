package com.example.tripper_2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Guide> guideArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Guide> guideArrayList) {
        this.context = context;
        this.guideArrayList = guideArrayList;
    }

    public RecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Guide guides = guideArrayList.get(position);
        holder.text.setText(guides.text);
        holder.image.setImageResource(guides.image);
    }

    @Override
    public int getItemCount() {
        return guideArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        //RelativeLayout back;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            //back = itemView.findViewById(R.id.back);
        }
    }
}
