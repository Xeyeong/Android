package com.example.and12_lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Mainfrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // View <= 프래그먼트에 있는 위젯을 찾아서 사용하기 위함. findViewById
        // View v = inflater.inflate
        // v.findViewById
        return inflater.inflate(R.layout.fragment_mainfrag, container, false);
        
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("수명주기", "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("수명주기", "onResume: ");
    }
}