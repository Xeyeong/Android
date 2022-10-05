package com.example.and14_allview.kym_recview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class KymRecvFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kym_recv, container, false);
        ArrayList<KymDTO> list = new ArrayList<>();
        list.add(new KymDTO(R.drawable.music1 , "새삥 (prod. ZICO) (Feat.호미들)" , "1","지코(ZICO)"));
        list.add(new KymDTO(R.drawable.music2 , "After LIKE" , "2","IVE (아이브)"));
        list.add(new KymDTO(R.drawable.music3 , "Shut Down" , "3","BLACK PINK"));
        list.add(new KymDTO(R.drawable.music4 , "Hype Boy" , "4","NewJeans"));
        list.add(new KymDTO(R.drawable.music4 , "Attention" , "5","NewJeans"));
        list.add(new KymDTO(R.drawable.music1 , "새삥 (prod. ZICO) (Feat.호미들)" , "1","지코(ZICO)"));
        list.add(new KymDTO(R.drawable.music2 , "After LIKE" , "2","IVE (아이브)"));
        list.add(new KymDTO(R.drawable.music3 , "Shut Down" , "3","BLACK PINK"));
        list.add(new KymDTO(R.drawable.music4 , "Hype Boy" , "4","NewJeans"));
        list.add(new KymDTO(R.drawable.music4 , "Attention" , "5","NewJeans"));

        RecyclerView recview = v.findViewById(R.id.recview);
        recview.setAdapter(new KymAdapter(inflater,list));
        recview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        return v;
    }
}