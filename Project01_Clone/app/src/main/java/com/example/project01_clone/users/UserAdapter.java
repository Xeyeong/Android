package com.example.project01_clone.users;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.MainActivity;
import com.example.project01_clone.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
// 모든 종류의 어댑터는 직접 화면을 붙일 권한이나 기능이 없음.
    // LayoutInflater ; 필수로 필요함.
    LayoutInflater inflater;
    ArrayList<UserDTO> list;
    Context context;
    public void setList(ArrayList<UserDTO> list) {
        this.list = list;
    }

    public UserAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_user,parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, @SuppressLint("RecyclerView") int i) {
        h.imgv.setImageResource(list.get(i).getImgRes());
        h.tv_msg.setText(list.get(i).getMsg());
        h.tv_name.setText(list.get(i).getName());

        h.imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , UserActivity.class);
                intent.putExtra("imgres" , list.get(i).getImgRes());
                intent.putExtra("name" , list.get(i).getName());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    // 위젯을 묶어놓은 DTO : 뷰홀더 자체가 내부에 위젯 갯수부터 모든것이 사용자가 임의로 만든것.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv ;
        TextView tv_name , tv_msg;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv = v.findViewById(R.id.imgv);
            tv_name = v.findViewById(R.id.tv_name);
            tv_msg = v.findViewById(R.id.tv_msg);
            // ViewHolder에서 디자인 연결을 해서 필드에 있는 모든 위젯들이 초기화됨(!=null)
            // 몇번째 칸인지 정확히 알수가없음.

        }
    }

}
