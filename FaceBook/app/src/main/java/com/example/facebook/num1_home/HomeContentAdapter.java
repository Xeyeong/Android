package com.example.facebook.num1_home;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class HomeContentAdapter extends RecyclerView.Adapter<HomeContentAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<HomeContentDTO> list;

    public HomeContentAdapter(LayoutInflater inflater, ArrayList<HomeContentDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_home, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int position) {
        h.img1.setImageResource(list.get(position).getImg1());
        h.Contentiv1.setImageResource(list.get(position).getContentiv1());
        h.tv1.setText(list.get(position).getTv1());
        h.tv2.setText(list.get(position).getTv2());
        h.tv3.setText(list.get(position).getTv3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img1, Contentiv1;
        TextView tv1, tv2, tv3;

        public ViewHolder(@NonNull View v) {

            super(v);
            img1 = v.findViewById(R.id.img1);
            Contentiv1 = v.findViewById(R.id.Contentiv1);
            tv1 = v.findViewById(R.id.tv1);
            tv2 = v.findViewById(R.id.tv2);
            tv3 = v.findViewById(R.id.tv3);

        }
    }
}
