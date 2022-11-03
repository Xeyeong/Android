package com.example.lastproject.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lastproject.R;

public class CusDeleteActivity extends AppCompatActivity {
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_delete);
        Intent intent = getIntent();
        CustomerVO vo = (CustomerVO) intent.getSerializableExtra("vo");

    cancel = findViewById(R.id.cancel);
    cancel.setOnClickListener();

    }
}