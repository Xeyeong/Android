package com.example.lastproject.customer;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.example.lastproject.last.CommonAskTask;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CusAdapter extends RecyclerView.Adapter<CusAdapter.vh> {
    // LayoutInflater <= 화면을 칸마다 붙이기 위한 객체.
    LayoutInflater inflater;
    ArrayList<CustomerVO> list;
    MainActivity activity;
    CusFragment fragment;

    public CusAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, MainActivity activity, CusFragment fragment) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_cus_recv, parent, false);
        // item ( 칸마다 보여줄 정보 Layout )
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vh h, int i) {
        h.tv_name.setText(list.get(i).getName());
        h.tv_tel.setText(list.get(i).getPhone());

        // 인터페이스를 매번 new로 생성해서 넘기면 코드가 조금 길어져서 헷갈릴수있음
        // => class implements이용해서 구현 메소드를 가져옴. this
        final int a = i;
        h.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(h.tv_name.getContext(), CusDetailActivity.class);
                intent.putExtra("isEnable", false);
                intent.putExtra("vo", list.get(a)); //직렬화가 안된 필드가 여러개있는 객체는 통신시에 보낼 수 없음.
                h.tv_name.getContext().startActivity(intent);
            }
        });
        h.btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(h.tv_name.getContext(), CusDetailActivity.class);
                intent.putExtra("isEnable", true);
                intent.putExtra("vo", list.get(a)); //직렬화가 안된 필드가 여러개있는 객체는 통신시에 보낼 수 없음.
                h.tv_name.getContext().startActivity(intent);
            }
        });
        h.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //삭제 로직 ( 화면 x ) And = spring 요청 == > CommonAsk
                CommonAskTask askTask = new CommonAskTask("delete.cu", activity);
                askTask.addParam("id", 10);
                askTask.addParam("vo", new Gson().toJson(list.get(a)));
                askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
                    @Override
                    public void onResult(String data, boolean isResult) {
                       fragment.cus_select();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class vh extends RecyclerView.ViewHolder{
        TextView tv_name, tv_tel;
        Button btn_detail, btn_modify, btn_delete;

        public vh(@NonNull View v) {
            super(v);
            tv_name = v.findViewById(R.id.tv_name);
            tv_tel = v.findViewById(R.id.tv_tel);
            btn_detail = v.findViewById(R.id.btn_detail);
            btn_modify = v.findViewById(R.id.btn_modify);
            btn_delete = v.findViewById(R.id.btn_delete);

        }

    }
}
