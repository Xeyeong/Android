package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.facebook.num1_home.HomeFragment;
import com.example.facebook.num2_Watch.WatchFragment;
import com.example.facebook.num3_Profile.ProfileFragment;
import com.example.facebook.num4_Feed.FeedFragment;
import com.example.facebook.num5_Noti.NotiFiveFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_nav;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nav = findViewById(R.id.btm_menu);

        HomeFragment fragment = new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new HomeFragment()).commit();

        btn_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.first_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new HomeFragment()).commit();
                }else if(item.getItemId() == R.id.second_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new WatchFragment()).commit();
             }else if(item.getItemId() == R.id.third_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new ProfileFragment()).commit();
                }else if(item.getItemId() == R.id.fourth_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new FeedFragment()).commit();
                }else if(item.getItemId() == R.id.five_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new NotiFiveFragment()).commit();
                }/*else if(item.getItemId() == R.id.six_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new SecondFragment()).commit();
                }*/
                return true;
            }
        });

    }
}