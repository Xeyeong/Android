package com.example.and14_allview.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.and14_allview.R;
import com.example.and14_allview.listview.ListDTO;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public GridAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }
    // 20건의 데이터를 보여주게 return 20 ;
    //=> 내가 가지고 있는 데이터의 건 수 만큼만 데이터가 보이게 처리. (
    @Override
    public int getCount() {
        return list.size(); // => list.size()
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_gridview , parent,false);
        return v;
    }
}
