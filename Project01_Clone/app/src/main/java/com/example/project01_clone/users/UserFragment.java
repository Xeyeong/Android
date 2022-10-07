package com.example.project01_clone.users;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;


public class UserFragment extends Fragment {

    //1. Layout에 한 칸에 들어갈 정보 레이아웃을 만들기 ( 나중에 리사이클러뷰가 반복시켜줌 )

    //2. Adapter 만들기 -2.1: ViewHolder , -2.2: Adapter<ViewHolder> 상속

    //3. 리사이클러뷰와 어댑터 연결

    //4. 리사이클러뷰와 레이아웃 매니저 (방향) 연결

    // shift x 2 : 파일 검색
    // ctrl + b : 메소드를 사용중인곳으로 이동

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recv_user);
        ArrayList<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO(R.drawable.ic_baseline_chat_bubble_outline_24 , "이름" , "상태"));
        list.add(new UserDTO(R.drawable.ic_baseline_more_horiz_24 , "이름" , "상태"));
        list.add(new UserDTO(R.drawable.ic_baseline_people_alt_24 , "이름" , "상태"));
        list.add(new UserDTO(R.drawable.ic_launcher_background , "이름" , "상태"));
        list.add(new UserDTO(R.drawable.ic_baseline_people_outline_24 , "이름" , "상태"));
        list.add(new UserDTO(R.drawable.ic_launcher_background , "이름" , "상태"));
        list.add(new UserDTO(R.drawable.ic_baseline_people_outline_24 , "이름" , "상태"));

        UserAdapter adapter = new UserAdapter(inflater , getContext()); // 생성자를 사용 x
       // adapter.list = list;
        adapter.setList(list);
        //UserAdapter에 ArrayList<UserDTO> list 를 보낼수있을까?
        //보내기 .



        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );
        recyclerView.setLayoutManager(manager);
        // Fragment는 단독적으로 화면위에 떠있을수가없음.
        //무조건 Activity를 통해서 Activity안에 붙어있음.(현 : MainActivity)
        //==해당하는 규칙때문에 getContext를 하면 Activity로부터 권한을 얻어올수있음.

        // return타입이 주어진것은 무조건 해당하는 타입에 담을수있음.
        //Context context = getContext();

        // ↓ 어댑터에서 되게 만들어 보기. ↓
        //Intent intent = new Intent( getContext() , UserActivity.class);
        //startActivity(intent);


        return v;
    }
}