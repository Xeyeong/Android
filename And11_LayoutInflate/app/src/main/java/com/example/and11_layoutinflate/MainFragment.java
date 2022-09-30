package com.example.and11_layoutinflate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
//1. onCreateView 메소드를 제외한 모든 코드는 삭제 한다.(주석 등)
    //Activity(onCreate) == Fragment(onCreateView)
    // setContView(Layout) == inflater.inflate(Layout)
    // 디자인 연결      == 디자인 연결

    // 기능제한 Context가 분리되어있다.
    // inflater.inflate => return view타입.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Button btn = v.findViewById(R.id.btn_frag);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("프래그먼트", "onClick: ");
            }
        });
        return v;

    }
}