package com.example.and14_allview.kym_recview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class KymAdapter extends RecyclerView.Adapter<KymAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<KymDTO> list;

    public KymAdapter(LayoutInflater inflater, ArrayList<KymDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_melon,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_title.setImageResource(list.get(i).getImgRes());
        h.tv_rank.setText(list.get(i).getTv_rank());
        h.tv_singer.setText(list.get(i).getTv_singer());
        h.tv_title.setText(list.get(i).getTv_title());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_title ;
        TextView tv_rank , tv_title , tv_singer;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_title = v.findViewById(R.id.imgv_title);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_title = v.findViewById(R.id.tv_title);
            tv_singer = v.findViewById(R.id.tv_singer);
        }
    }
}
