package com.example.facebook;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<Integer> list;


    public MainAdapter(LayoutInflater inflater, ArrayList<Integer> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(inflater.inflate(R.layout.item_story, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int p) {
        h.iv.setImageResource(list.get(p));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        public ViewHolder(@NonNull View v) {
            super(v);
            iv = v.findViewById(R.id.recy_story);
            //v.findViewById(R.id.recy_story);
        }
    }

}
