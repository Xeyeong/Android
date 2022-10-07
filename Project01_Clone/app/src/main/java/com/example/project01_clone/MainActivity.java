package com.example.project01_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project01_clone.users.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    BottomNavigationView btm_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();// 기본적으로 안드로이드는 Actionbar가 있음.해당하는 액션바
                                          //가져오기 ( 메모리에 있는 객체를 가져옴)
        actionBar.setTitle("친구");

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new UserFragment()).commit();

        btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // item ↑
                if(item.getItemId() == R.id.menu1){
                    actionBar.setTitle("친구");
                }else if(item.getItemId() == R.id.menu2){
                    actionBar.setTitle("채팅");
                }else if(item.getItemId() == R.id.menu3){
                    actionBar.setTitle("뷰");
                }else if(item.getItemId() == R.id.menu4){
                    actionBar.setTitle("쇼핑");
                }else if(item.getItemId() == R.id.menu5){
                    actionBar.setTitle("더보기");
                }

                return true;// false를 리턴하면 선택 된 것을 취소함./
            }
        });

    }

}