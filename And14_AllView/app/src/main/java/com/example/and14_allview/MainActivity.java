package com.example.and14_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.and14_allview.gridview.GridFragment;
import com.example.and14_allview.listview.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // package 추가 이름 listview
        // 패키지 안쪽에 ListFragment (이름) 추가 하기.
        // 메인 액티비티에서 해당하는 프래그먼트가 보이게 처리해보기.( 메인액티비티에 프래그먼트 붙이기 )
        // 메인은 붙일 공간을 마련 ( container ) - O
        // 프래그먼트를 코드를 이용해서 container 에 붙이기 처리를함(transaction)

        // View를 상속받은 모든 위젯은 Onclick이벤트를 걸수있음.
        //<= findViewById
        findViewById(R.id.btn_listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container , new ListFragment()).commit();
            }
        });
        findViewById(R.id.btn_gridview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.container , new GridFragment()).commit();
            }
        });

    }
}