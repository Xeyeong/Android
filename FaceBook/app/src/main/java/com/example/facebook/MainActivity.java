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

import com.example.facebook.first.FirstFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.tabs.TabLayout;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nav = findViewById(R.id.btm_menu);
        FirstFragment fragment = new FirstFragment();

        btn_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.first_tab){
                   getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new FirstFragment()).commit();
                }else if(item.getItemId() == R.id.second_tab){
/*
                }else if(item.getItemId() == R.id.third_tab){

                }else if(item.getItemId() == R.id.fourth_tab){

                }else if(item.getItemId() == R.id.five_tab){

                }else if(item.getItemId() == R.id.six_tab){
                    */
                }
                return false;
            }
        });
    }
}