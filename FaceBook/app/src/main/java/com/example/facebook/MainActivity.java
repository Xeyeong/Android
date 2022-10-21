package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.tabs.TabLayout;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_nav;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = getSupportActionBar();
        btn_nav = findViewById(R.id.btn_nav);

        btn_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.first_tab){
                    bar.setTitle("홈");
                }else if(item.getItemId() == R.id.second_tab){
                    bar.setTitle("Watch");
                }else if(item.getItemId() == R.id.third_tab){
                    bar.setTitle("프로필");
                }else if(item.getItemId() == R.id.fourth_tab){
                    bar.setTitle("피드");
                }else if(item.getItemId() == R.id.five_tab){
                    bar.setTitle("알림");
                }else if(item.getItemId() == R.id.six_tab){
                    bar.setTitle("메뉴");
                }

                return false;
            }
        });

    }
}