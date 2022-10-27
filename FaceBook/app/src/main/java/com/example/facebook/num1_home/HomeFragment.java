package com.example.facebook.num1_home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.facebook.MainAdapter;
import com.example.facebook.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentActivity activity;
    TabLayout tab;
    RecyclerView recyclerView;
    MainAdapter adapter;
    MainAdapter  adapter2;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activity = HomeFragment.super.getActivity();
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = v.findViewById(R.id.first_recv);
        tab = v.findViewById(R.id.tab);


        list.add(R.drawable.story1);
        list.add(R.drawable.story2);
        list.add(R.drawable.story3);
        list.add(R.drawable.story4);

        list2.add(R.drawable.ic_baseline_home_24);


        adapter = new MainAdapter(inflater, list);
        adapter2 = new MainAdapter(inflater, list2);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0 ){
                    recyclerView.setAdapter(adapter);
                }else if(tab.getPosition() == 1){
                    recyclerView.setAdapter(adapter2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });









        return v;
    }

}