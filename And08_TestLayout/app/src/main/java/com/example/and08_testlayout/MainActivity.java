package com.example.and08_testlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2;
    ImageView imgv1, imgv2; //onCreate 메소드 안쪽에 setContentView가 되어야지만 해당하는 디자인 연결됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            btn1 = findViewById(R.id.btn1);
            btn2 = findViewById(R.id.btn2);
            imgv1 = findViewById(R.id.imgv1);
            imgv2 = findViewById(R.id.imgv2);



        btn1.setTag("1");
        btn2.setTag("1");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }
    // View<- Java Object(객체)를 상속받은 객체 ( 화면에 보이는 모든것들은 View의 자식 클래스이다 )
    // Object<- 자바에서 사용되는 대부분의 타입은 Object의 자식 클래스 이다.
    @Override
    public void onClick(View v) {
        //btn1과 btn2가 똑같은 onClick이라는 메소드가 실행됨 (각각의 버튼을 눌렀을때)
        if (v.getId() == R.id.btn1){
            if(v.getTag().equals("1")){
               imgv1.setImageResource(R.drawable.ic_launcher_foreground);
               v.setTag("2");
            }else{
                imgv1.setImageResource(R.drawable.ic_launcher_background);
                v.setTag("1");
            }
        }else if(v.getId() == R.id.btn2){

            imgv2.setImageResource(R.drawable.ic_launcher_background);
        }



    }
}










