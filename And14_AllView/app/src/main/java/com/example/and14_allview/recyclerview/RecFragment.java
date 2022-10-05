package com.example.and14_allview.recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class RecFragment extends Fragment {
    RecyclerView recview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rec, container, false);
        recview = v.findViewById(R.id.recview);

        ArrayList<RecDTO> list = new ArrayList<>();
        list.add(new RecDTO(R.drawable.img1 , false , "name1" , "msg1" , "오후 4:44"));
        list.add(new RecDTO(R.drawable.img2 , true , "name2" , "msg2" , "오후 4:45"));
        list.add(new RecDTO(R.drawable.img3 , false , "name3" , "msg3" , "오후 4:46"));
        list.add(new RecDTO(R.drawable.img4 , true , "name4" , "msg4" , "오후 4:47"));
        list.add(new RecDTO(R.drawable.img5 , false , "name5" , "msg5" , "오후 4:48"));




        RecvAdapter adapter = new RecvAdapter(inflater , list);
        /* ListView랑 다르게 가로 세로 모드가 모두 되기 때문에 방향 지정을 해줘야함.*/
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
            getContext()  , RecyclerView.VERTICAL , false
        );



        recview.setAdapter(adapter);
        recview.setLayoutManager(manager);
        // getContext( 현재 화면에 떠있는 객체가 무엇인지 그리고 방향지정을 할때
        // 해당하는 기능을 사용할수있는 상태의 클래스에서 작업을 하고있는지를 판단함 )
        // MainActivity로 부터 해당하는 기능을 조금 얻어온다.

        // VERTICAL , HORIZONTAL 가로인지 세로인지를 지정.

        // 반대로 맨마지막 데이터를 처음에 보여줄지 지정 .(==x , 디비에서 order by )


        return v;
    }
}