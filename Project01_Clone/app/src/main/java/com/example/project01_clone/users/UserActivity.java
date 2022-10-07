package com.example.project01_clone.users;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.project01_clone.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        Log.d("로그",getIntent().getIntExtra("imgres" , 0) +"");
        Log.d("로그", getIntent().getStringExtra("name" ));
    }
}