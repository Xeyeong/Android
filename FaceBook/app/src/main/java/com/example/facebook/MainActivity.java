package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.facebook.num1.FirstFragment;
import com.example.facebook.num2.SecondFragment;
import com.example.facebook.num3.ThirdFragment;
import com.example.facebook.num4.FourthFragment;
import com.example.facebook.num5.FiveFragment;
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

        FirstFragment fragment = new FirstFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new FirstFragment()).commit();

        btn_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.first_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new FirstFragment()).commit();
                }else if(item.getItemId() == R.id.second_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new SecondFragment()).commit();
             }else if(item.getItemId() == R.id.third_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new ThirdFragment()).commit();
                }else if(item.getItemId() == R.id.fourth_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new FourthFragment()).commit();
                }else if(item.getItemId() == R.id.five_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new FiveFragment()).commit();
                }/*else if(item.getItemId() == R.id.six_tab){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout,new SecondFragment()).commit();
                }*/
                return false;
            }
        });

    tab.addTab(mB);
    }
}