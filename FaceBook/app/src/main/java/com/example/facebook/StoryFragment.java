package com.example.facebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class StoryFragment extends Fragment {
    RecyclerView story_recv;
    TabLayout center;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        story_recv.findViewById(R.id.story_recv);
        MainAdapter adapter = new MainAdapter(inflater);
        story_recv.setAdapter(adapter);

        //스토리 릴스
        center.findViewById(R.id.center);
        center.addTab(center.newTab().setText("스토리"));
        center.addTab(center.newTab().setText("릴스"));

        View v = inflater.inflate(R.layout.fragment_story_reels, container, false);
        return v;
    }
}