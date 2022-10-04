package com.example.and14_allview.gridview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and14_allview.R;

public class GridFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);

        ListView listview_grid = v.findViewById(R.id.listview_grid);//null무조건널임. v에 담아져있는 디자인 리소스에
                                                         //해당하는 ID가 없기때문에.
        GridAdapter adapter = new GridAdapter(inflater);
        listview_grid.setAdapter(adapter);
        return v;
    }
}