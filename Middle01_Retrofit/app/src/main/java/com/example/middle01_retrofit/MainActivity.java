package com.example.middle01_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.middle01_retrofit.middle.CommonAskTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommonAskTask askTask = new CommonAskTask("andLogin", this);
        askTask.addParam("email" , "admin@naver.com");
        askTask.addParam("pw" , "admin1234");
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("fhrm", "onResult: " + data + isResult);
            }
        });
         new CommonAskTask("list" , this).excuteAsk( (data, isResult) -> {
             Log.d("TAG", "onResult: " + isResult);
             Log.d("TAG", "onResult: " + data);
         });
    }
}//                Log.d("TAG", "onResult: ");