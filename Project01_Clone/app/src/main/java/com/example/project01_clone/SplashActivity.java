package com.example.project01_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
// 1. 액티비티 메인이 맨 처음에 실행되는이유가 있음.. :
    //안드로이드 앱 (META-DATA) 실행 시 어떤 설정이나 권한등을 설정해놓은 xml파일.
    // => AndroidManifest.xml

// 2.Splash - 몇초정도 지연을 시켰다가 다음 화면인 메인 액티비티로 이동을 해야함.
    //Thread <- 자바 쓰레드
    //※ Handler <- 안드에서 사용하는 비동기 쓰레드 ※
    //RunOnUiThread <- 안드에서 사용하는 비동기 쓰레드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 두개의 파라메터 Runnable() , 3000을 입력받는 메소드 postDelayed를 오류코드없이 호출해보기.

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("현재 데이터 로딩중...");
        dialog.setMessage("로딩중....");
        dialog.show();//실제 보이게 만듬.

        //new Handler().postDelayed()
        //-내가 사용하려는 메소드의 파라메터가 Interface 타입인경우
        //1.바로 구현부를 작성하는 방법.=> new
        //2.implements로 상속 후 작성하는 방법.
        Log.d("로그", " 3초뒤? ");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();// show 반대 안보이게 하는 처리

                //3초 후 실행 되는 부분.
                Log.d("로그", " 3초뒤? ");
                //메인액티비티로 화면 이동해보기 => 현재 Activity => 다음 Activity
                Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(intent);
                finish();// 현재 액티비티를 닫는 처리(종료)
            }
        }  , 1000 * 3);



        View.OnClickListener kymOnclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3.여기가 실행이 됨.
            }
        };

        postDelayed(kymOnclick);//3
        postDelayed(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.여기가 실행이 됨.
            }
        });
        postDelayed(this);

    }
     void postDelayed(View.OnClickListener v) {

     }

    @Override
    public void onClick(View v) {
        //2.여기가 실행이됨
    }
}