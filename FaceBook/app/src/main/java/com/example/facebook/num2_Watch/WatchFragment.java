package com.example.facebook.num2_Watch;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.facebook.R;

import java.util.ArrayList;


public class WatchFragment extends Fragment {

    RecyclerView watch_recv;
    BarAdapter adapter;
    ArrayList<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_watch, container, false);
        watch_recv = v.findViewById(R.id.watch_recv);

        list.add("회원님을 위한 추천");
        list.add("라이브");
        list.add("게임");
        list.add("팔로잉");
        list.add("저장됨");

        adapter = new BarAdapter(inflater, list);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        watch_recv.setLayoutManager(manager);

        watch_recv.setAdapter(adapter);


        return v;
    }
}