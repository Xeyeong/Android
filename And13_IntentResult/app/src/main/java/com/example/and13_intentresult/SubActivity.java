package com.example.and13_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    // 안드로이드의 4대 컴포넌트 : 액티비티, ※ 컴포넌트들은 전부 Manifest에 기재 되어 있어야 한다.
    // Intent(인텐트) : 4가지 컴포넌트들간의 통신을 담당하고있는 객체(전달)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 메인액티비티 => ※인텐트※ => 서브액티비티
        Intent intent = getIntent(); //메인에서 보내준 인텐트 객체를 인스턴스화 시킴.(사용준비)
        String sKey = intent.getStringExtra("sKey");
        Toast.makeText(SubActivity.this, sKey, Toast.LENGTH_LONG).show();
        //                  화면에 현재 떠있는 액티비티, 값(출력), 보여주는 시간

        Intent i = getIntent();
        int iKey = intent.getIntExtra("iKey",-1);//100
        int tempInt = intent.getIntExtra("iKey33",-1);//-1

        LoginDTO loginDTO = (LoginDTO) intent.getSerializableExtra("dto");
        Log.d("로그", "onCreate: " + loginDTO.getId() + loginDTO.getPw());

        //int형 변수에는 null을 넣을수없기때문에 iKey값을 찾아서 해당하는 키를 사용하는
        //데이터가 없다면 return을 줄수가없음 따라서 기본으로 담을 값을 지정해둠.

        Toast.makeText(SubActivity.this, "" + iKey + "" + tempInt, Toast.LENGTH_SHORT).show();
        //               화면에 현재 떠있는 액티비티,     값(출력),                  보여주는시간
        String dto = intent.getStringExtra("id");

        ArrayList<LoginDTO> alist = (ArrayList<LoginDTO>) intent.getSerializableExtra("list");
        // alt + enter로 해당하는 타입으로 캐스팅
        Log.d("로그", "onCreate: " + alist.size());
    }
}