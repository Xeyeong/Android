package com.example.and14_allview.gridview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.and14_allview.R;
import com.example.and14_allview.listview.ListDTO;

import java.util.ArrayList;

public class GridFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);
        /* ListDTO형태를 6개 가지고있는 ArrayList만들어보기. */
        ArrayList<ListDTO> list = new ArrayList<>();// null=> 메모리 참조를 시작 ( new )
        list.add(new ListDTO(R.drawable.img1 , "category1" , "name1"));
        list.add(new ListDTO(R.drawable.img2 , "category2" , "name2"));
        list.add(new ListDTO(R.drawable.img3 , "category3" , "name3"));
        list.add(new ListDTO(R.drawable.img4 , "category4" , "name4"));
        list.add(new ListDTO(R.drawable.img5 , "category5" , "name5"));
        list.add(new ListDTO(R.drawable.img1 , "category" , "name"));

        //JAVA : A 클래스에서 B 클래스를 실행시켜야 하는데.
        // B클래스가 실행이 되려면 필요한 정보를 A클래스가 가지고있음.
        // A(data) => B(실행시 data 필요함)
        // 파라메터 ( A클래스에서 내용을 보내주고 , B클래스는 내용을 받을 그릇을 준비함)
        // 호출 시:  B(data) , B(Data data); 정의 + 호출 == 변수 초기화식

        GridView listview_grid = v.findViewById(R.id.listview_grid);//null무조건널임. v에 담아져있는 디자인 리소스에
                                                         //해당하는 ID가 없기때문에.
        GridAdapter adapter = new GridAdapter(inflater , list);
        listview_grid.setAdapter(adapter);
        return v;
    }
}