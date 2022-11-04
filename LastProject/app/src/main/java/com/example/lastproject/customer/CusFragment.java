package com.example.lastproject.customer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.example.lastproject.last.CommonAskTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class CusFragment extends Fragment {
    RecyclerView recv_cus;
    CusAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cus, container, false);
        recv_cus = v.findViewById(R.id.recv_cus);
        // 실제 디자인 ( 모양 ) 데이터 갯수등 모든것들을 결정하는 것 ==> Adapter

        cus_select();
        return v;
    }

    // 레트로핏을 이용해서 데이터 가져오기(Spring)
    public void cus_select(){

        CommonAskTask askTask = new CommonAskTask("list.cu", getContext());
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                // 통신 완료 시 데이터를 가져온다.
                if(isResult){
                    Log.d("고객", "onResult: " + data);
                    ArrayList<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
                    Log.d("고객", "onResult: " + list.size());

                    adapter = new CusAdapter(getLayoutInflater(), list, (MainActivity) getActivity(), CusFragment.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recv_cus.setLayoutManager(manager);
                    recv_cus.setAdapter(adapter);
                }else{
                    Log.d("고객", "onResult:Fail " + data);

                }
            }
        });
    }

}