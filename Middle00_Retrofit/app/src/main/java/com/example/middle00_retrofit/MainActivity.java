package com.example.middle00_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.middle00_retrofit.middle.ApiClient;
import com.example.middle00_retrofit.middle.ApiInterface;
import com.example.middle00_retrofit.middle.CommonVal;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btn , btn_login;
    EditText edt_email , edt_pw ;
    //Web (로그인 처리함) => Session
    //변수 ( 앱이 종료되기전까지 메모리에 유지되는 정보 )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btn = findViewById(R.id.btn);
        edt_email = findViewById(R.id.edt_email);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(v->{
            // 람다식
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class); //http통신을 위한 retrofit객체 초기화.
                                                                                             //ApiInterface 사용함.
            HashMap<String, Object> map = new HashMap<>();
            map.put("email" , edt_email.getText()+"");// 파라메터가 전송됨.
            map.put("pw" , edt_pw.getText()+"");// 파라메터가 전송됨.


            apiInterface.getData("andLogin" ,map ).enqueue(new Callback<String>() {//enqueue<= 실행부
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("로그", "onResponse: " + response.body());
                    // toJson => String으로 객체 전송할때 (Json)
                    // fromJson => String을 다시 원래 형태의 객체타입으로 바꿀때.
                    Gson gson = new Gson();
                    CommonVal.loginInfo = gson.fromJson(response.body() , AndMemberDTO.class);
                    if(CommonVal.loginInfo != null) {
                        Log.d("로그", "onResponse: " + CommonVal.loginInfo.getEmail());//null.getEmail();
                        Log.d("로그", "로그인 되었습니다.");//null.getEmail();
                        // ContentActivity로 이동.
                        // Activity 끼리 서로 통신을 위한 객체 Intent
                        Intent intent = new Intent(MainActivity.this,ContentActivity.class);
                        startActivity(intent);

                    }else{
                        Log.d("로그", "아이디 또는 비밀번호를 확인해주세요.");//null.getEmail();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });

        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("str" , "kym");// 파라메터가 전송됨.
                    apiInterface.getData("hanul302" , map).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.d("로그", "onResponse: " );
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("로그", "onResponse: ");
                        }
                    });


            }
        });

    }
}