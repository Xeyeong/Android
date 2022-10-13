package com.example.middle00_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.middle00_retrofit.middle.CommonAskTask;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        CommonAskTask askTask = new CommonAskTask("andLogin",this);
        askTask.addParam("email","admin@naver.com");
        askTask.addParam("pw","admin1234");
        //ContentActivity에서 CommonAskTask를 실행했을때.
        // null이나 오류가 아니라 데이터가 찍히게 해보기.

        //askTask.execute();
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {

            }
        });


    }

    public class TestClass{
        public void onResult(){

        }
    }

}