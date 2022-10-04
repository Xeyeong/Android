package com.example.and14_allview.listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    // Fragment 비어있는것 추가 후 반드시 있어야 되는 부분 ↓

    //1. 칸마다 보여질 정보를 (Layout) 어떤식으로 보여줄지 미리 만들어 놓는다.(1칸 , 반복)
    // ex) 카카오톡 친구목록 , 친구 숫자에 따라서 아이템이 20~친구숫자만큼 가변적으로 변함.(==1칸)

    //2. Adapter
    // - 안드로이드 자체에서 사용자가 어떤 모양의 정보를 보여주는 화면 구성을 할지 전부다 미리 만들어놓을수가없음.
    //따라서 사용자가 만든 화면과 위젯을 연결해줄(브릿지) 어댑터
    // ( BaseAdapter - 가장 기본적인 형태의 어댑터 )

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_list, container, false);

        //1. ListDTO를 5개이상 저장해둔 ArrayList하나를 만들어보기.
        //2. 만든 ArrayList를 ListAdapter로 보내보기.
        ArrayList<ListDTO> list = new ArrayList<>(); // <= null x , size = 0;
        //ListDTO dto = new ListDTO(R.drawable.img1 , "종류" , "이름");
        //list.add(dto);
        list.add(new ListDTO(R.drawable.img1 , "종류1" , "이름1"));
        list.add(new ListDTO(R.drawable.img2 , "종류2" , "이름2"));
        list.add(new ListDTO(R.drawable.img3 , "종류3" , "이름3"));
        list.add(new ListDTO(R.drawable.img4 , "종류4" , "이름4"));
        list.add(new ListDTO(R.drawable.img5 , "종류5" , "이름5"));

       listView = view.findViewById(R.id.listview);

       ListAdapter adapter = new ListAdapter(inflater,list);//기본적으로 프래그먼트는 LayoutInflater를 무조건 가지고있음.
        listView.setAdapter(adapter);

       if(listView == null){
           Log.d("테스트", "onCreateView: ");
       }else{
           Log.d("테스트", "onCreateView: ");
       }
        return  view;
    }// onCreateView

    public boolean add(ListDTO e){

        return false;
    }




}