package com.example.lastproject.emp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.example.lastproject.customer.CusAdapter;
import com.example.lastproject.customer.CusFragment;
import com.example.lastproject.last.CommonAskTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EmpFragment extends Fragment {
    RecyclerView recv_emp;
    EmpAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      View v = inflater.inflate(R.layout.fragment_emp, container, false);
        recv_emp = v.findViewById(R.id.recv_emp);

        emp_select();
        return v;
    }
    public void emp_select(){
        CommonAskTask askTask = new CommonAskTask("list.hr",getContext());
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                if(isResult){

                    ArrayList<EmployeeVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<EmployeeVO>>(){}.getType());

                    adapter = new EmpAdapter(getLayoutInflater(), list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recv_emp.setLayoutManager(manager);
                    recv_emp.setAdapter(adapter);
                }
            }
        });
    }

}