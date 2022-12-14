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
    RecyclerView recyclerView2;
    MainAdapter adapter;
    MainAdapter  adapter2;
    HomeContentAdapter adapter3;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<HomeContentDTO> list3 = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activity = HomeFragment.super.getActivity();
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.first_recv);
        recyclerView2 = v.findViewById(R.id.first_recv2);
        tab = v.findViewById(R.id.tab);



        list.add(R.drawable.story1);
        list.add(R.drawable.story2);
        list.add(R.drawable.story3);
        list.add(R.drawable.story4);
        list.add(R.drawable.story5);
        list.add(R.drawable.story6);
        list.add(R.drawable.story7);
        list.add(R.drawable.story8);
        list.add(R.drawable.story9);
        list.add(R.drawable.story10);
        list.add(R.drawable.story2);
        list.add(R.drawable.story3);
        list.add(R.drawable.story4);
        list.add(R.drawable.story5);
        list.add(R.drawable.story6);
        list.add(R.drawable.story7);
        list.add(R.drawable.story8);
        list.add(R.drawable.story9);
        list.add(R.drawable.story10);
        list.add(R.drawable.story2);
        list.add(R.drawable.story3);
        list.add(R.drawable.story4);
        list.add(R.drawable.story5);
        list.add(R.drawable.story6);
        list.add(R.drawable.story7);
        list.add(R.drawable.story8);
        list.add(R.drawable.story9);
        list.add(R.drawable.story10);

        list2.add(R.drawable.reels1);
        list2.add(R.drawable.reels2);
        list2.add(R.drawable.reels3);
        list2.add(R.drawable.reels4);
        list2.add(R.drawable.reels5);
        list2.add(R.drawable.reels6);
        list2.add(R.drawable.reels7);
        list2.add(R.drawable.reels8);
        list2.add(R.drawable.reels9);
        list2.add(R.drawable.reels10);
        list2.add(R.drawable.reels2);
        list2.add(R.drawable.reels3);
        list2.add(R.drawable.reels4);
        list2.add(R.drawable.reels5);
        list2.add(R.drawable.reels6);
        list2.add(R.drawable.reels7);
        list2.add(R.drawable.reels8);
        list2.add(R.drawable.reels9);
        list2.add(R.drawable.reels10);
        list2.add(R.drawable.reels2);
        list2.add(R.drawable.reels3);
        list2.add(R.drawable.reels4);
        list2.add(R.drawable.reels5);
        list2.add(R.drawable.reels6);
        list2.add(R.drawable.reels7);
        list2.add(R.drawable.reels8);
        list2.add(R.drawable.reels9);
        list2.add(R.drawable.reels10);

        list3.add(new HomeContentDTO(R.drawable.home_img1,R.drawable.home_img1_1,"fuck","fucking","fucking2"));
        list3.add(new HomeContentDTO(R.drawable.home_img1,R.drawable.home_img1_1,"fuck","fucking","fucking2"));
        list3.add(new HomeContentDTO(R.drawable.home_img1,R.drawable.home_img1_1,"fuck","fucking","fucking2"));
        list3.add(new HomeContentDTO(R.drawable.home_img1,R.drawable.home_img1_1,"fuck","fucking","fucking2"));

        adapter = new MainAdapter(inflater, list);
        adapter2 = new MainAdapter(inflater, list2);
        adapter3 = new HomeContentAdapter(inflater, list3);

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

        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView2.setLayoutManager(manager1);

        recyclerView2.setAdapter(adapter3);


        return v;
    }

}