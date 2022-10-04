package com.example.and14_allview.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.and14_allview.R;

public class GridAdapter extends BaseAdapter {
    LayoutInflater inflater;

    public GridAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 20; // => list.size()
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_gridview , parent,false);
        return v;
    }
}
