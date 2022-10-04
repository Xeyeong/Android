package com.example.and14_allview.listview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;

//1.상속을 받는다 ( 일반 클래스==>Adpater )
// 많은 어댑터 종류가 있지만 가장 기본적이고 많이 사용되는 어댑터 BaseAdapter
public class ListAdapter extends BaseAdapter {
    //※ 어댑터라는 클래스는 화면을 붙이는 기능인 LayoutInflater 사용 불가 ※
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public ListAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public ListAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //보여질 아이템의 갯수를 지정하는 곳( 0 아이템이 없음)
    // Collection , Array Size
    @Override
    public int getCount() {
        return list.size();
    } // 5

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //칸마다 보여질 데이터를 실제로 붙이는 처리를 하는부분.
    //LayoutInflater <- 칸마다 데이터 붙이기 처리를 해야함.
    //getCount횟수에 따라서 반복 실행 ↓
    @Override           // position 0~ count-1
    public View getView(int i, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_listview , parent , false);//붙이는 처리는 return이 되고나서
        ImageView imgv_profile = v.findViewById(R.id.imgv_profile);
        TextView tv_category = v.findViewById(R.id.tv_category);
        TextView tv_name = v.findViewById(R.id.tv_name);
        //각각의 위젯을 레이아웃 붙이는 처리하고 나서 나온 View를 이용해서 찾아주고 , 그다음 데이터바인딩처리
        //위젯<=>데이터 연결 : 데이터 바인딩.
        imgv_profile.setImageResource(list.get(i).getImgId());

        tv_category.setText(list.get(i).getCategory());
        tv_name.setText(list.get(i).getName());
        //나중에 알아서 처리함. 바로붙이기x
        return v;
    }
}
