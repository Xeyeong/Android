package com.example.and13_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btn;
    Button btn_call;
    Button btn_web;
    Button btn_gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_new);
        btn_call = findViewById(R.id.btn_call);
        btn_web = findViewById(R.id.btn_web);
        btn_gps = findViewById(R.id.btn_gps);

        btn.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_web.setOnClickListener(this);
        btn_gps.setOnClickListener(this);

    }
    // Context <= 제일 넓은 범위에 AppicationContext.....
    // getSupportFragment ????
    // 기능 제한을 화면 단위에 따라서 또는 클래스 단위에 따라서 나눠놨음.

    // 개발자의 사용범위(바운더리) 안에서 제어가 가능한 인텐트 : 명시적 인텐트.
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_new) {

            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("sKey","메인액티비티에서 보낸정보");
            //현위치(액티비티), 갈 위치(class)
            //인트값 100을 서브액티비티로 보내서
            //출력해보기(토스트,로그)
            intent.putExtra("iKey",100);
            //DTO 타입 => loginDTO Type => serializable타입
            LoginDTO dto = new LoginDTO("id","pw");

            // LoginDTO 10개를 가진 ArrayList만들기


            ArrayList<LoginDTO> alist = new ArrayList<>();
            for(int i = 0; i <   10; i++){
                alist.add(new LoginDTO("aa" +i ,"bb"));
            }


            intent.putExtra("list", alist);

            intent.putExtra("dto", dto);


            startActivity(intent); // startActivity <- 프래그먼트나 일반클래스에서 실행 x

        }else if (v.getId() == R.id.btn_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/119"));
            startActivity(intent);
        }else if(v.getId() == R.id.btn_web){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
            startActivity(intent);
        }else if(v.getId() == R.id.btn_gps){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?q=" + 35.1535583 +"," + 126.8879957 + "&z" + 15));
            //35.1535583!4d126.8879957
            startActivity(intent);
        }
    }
}