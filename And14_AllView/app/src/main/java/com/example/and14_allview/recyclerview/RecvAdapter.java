package com.example.and14_allview.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and14_allview.R;

import java.util.ArrayList;


// 2. extends 먼저 뷰홀더를 만들어놔야지 상속받기가 편함.
public class RecvAdapter extends RecyclerView.Adapter<RecvAdapter.RecHolder> {

    //※ 3. ViewHolder ( 현 : RecHolder ) 를 생성해서 return 해줘야하는 부분.
    //  3.1. View타입을 리턴하고 어떤 레이아웃을 붙이는 처리를 해주는것. LayoutInflater ※
    LayoutInflater inflater;
    ArrayList<RecDTO> list;

    public RecvAdapter(LayoutInflater inflater, ArrayList<RecDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ViewHolder 생성해서 리턴해보기.
        View v = inflater.inflate(R.layout.item_recv , parent , false);
        return new RecHolder(v);//?
    }

    // 데이터 연동 부분.
    @Override
    public void onBindViewHolder(@NonNull RecHolder h, int i) {
        h.tv_name.setText(list.get(i).getName());
        h.imgv_profile.setImageResource(list.get(i).getImgDrw());
        h.tv_date.setText(list.get(i).getDate());
        h.tv_msg.setText(list.get(i).getMsg());

        if(list.get(i).isNoti()){
            h.imgv_noti.setVisibility(View.VISIBLE);
        }else{
            h.imgv_noti.setVisibility(View.INVISIBLE);
        }
        // DTO랑 사용법 똑같음 ( =! 안에 들어있는것이 일반 변수타입이아라 안드로이드 위젯)
    }

    // 나중에 DB 연동이나 , ArrayList수동으로 넣은경우 임의의값을 사용하면 오류가 발생함.

    // 몇개의 내용이 보여질지를 정의한메소드 ( 0 아이템 없음 , 0보다 크면 해당하는 숫자만큼의 칸이 생긴다.)
    @Override
    public int getItemCount() {
        return list.size();
    }


    //1. ViewHolder <== Inner Class로 존재해야 만드는게 편함.(※필수※)
    //==> widget을 여러개 묶어놓은 DTO

    public class RecHolder extends RecyclerView.ViewHolder {
        // Field Widget(View)== TextView , ImageView , EditText
        // ==> 한칸에 들어갈정보를 미리 만들어놓았는데 해당하는 칸에 있는 위젯들..
        ImageView imgv_profile , imgv_noti ;
        TextView tv_name , tv_msg , tv_date;
        public RecHolder(@NonNull View v) {
            super(v);
            imgv_profile = v.findViewById(R.id.imgv_profile); //null => 참조
            imgv_noti = v.findViewById(R.id.imgv_noti); //null => 참조
            tv_name = v.findViewById(R.id.tv_name); //null => 참조
            tv_msg = v.findViewById(R.id.tv_msg); //null => 참조
            tv_date = v.findViewById(R.id.tv_date); //null => 참조

            tv_name.setText("찾음......");

        }
    }

}
