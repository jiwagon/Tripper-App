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

public abstract class RecyclerViewAdapter extends RecyclerView.Adapter {
    Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new myAdapter(view);
    }

    //@Override
    public void onBindViewHolder(@NonNull myAdapter holder, int position) {
        if (position == 0) {
            holder.image.setImageResource(R.drawable.project_pic1);
            holder.back.setBackgroundColor(Color.parseColor("#E6E53935"));
            holder.text.setText("Top Bucket List Trips");
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class myAdapter extends RecyclerView.ViewHolder {
        ImageView image,image1;
        TextView text;
        RelativeLayout back;
        public myAdapter(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            text=itemView.findViewById(R.id.text);
            back=itemView.findViewById(R.id.back);
        }
    }
}
