package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout center;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    center = findViewById(R.id.center);
    center.addTab(center.newTab().setText("스토리"));
    center.addTab(center.newTab().setText("릴스"));

    }
}