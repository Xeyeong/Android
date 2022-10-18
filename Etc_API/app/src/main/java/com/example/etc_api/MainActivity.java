package com.example.etc_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_glide1 , imgv_glide2;
    NidOAuthLoginButton btn_naver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Glide <= Android에서 이미지뷰에 url이나 여러가지 이미지파일을 붙일때 사용하는 API
        imgv_glide1 = findViewById(R.id.imgv_glide1);
        imgv_glide2 = findViewById(R.id.imgv_glide2);
        btn_naver = findViewById(R.id.btn_naver);
        //http://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg
        //https://cdn-bastani.stunning.kr/prod/portfolios/f9d84529-1c91-4d48-a5c5-4790db25a064/contents/d63fc54819cd3fb0c319021e2e7cd6bfee951e8ce2db9e948bd828f538272da6_v2.gif
        Glide.with(this)
                .load("http://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg")
                .into(imgv_glide1);

        Glide.with(this)
                .load("https://cdn-bastani.stunning.kr/prod/portfolios/f9d84529-1c91-4d48-a5c5-4790db25a064/contents/d63fc54819cd3fb0c319021e2e7cd6bfee951e8ce2db9e948bd828f538272da6_v2.gif")
                .into(imgv_glide2);


        NaverIdLoginSDK.INSTANCE.initialize(this
        ,"GWW8wixD4pMoKJc3JcZG"
        ,"XsEyOg7LHA"
        , "Etc_API");

        btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("로그", "onSuccess: ");
                NidOAuthLogin authLogin = new NidOAuthLogin();
                authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse res) {
                        Log.d("로그", "onSuccess: " + res.getProfile().getEmail());
                        Log.d("로그", "onSuccess: " + res.getProfile().getMobile());
                        Intent intent = new Intent(MainActivity.this,SubActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("로그", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("로그", "onError: ");
            }
        });
       // NaverIdLoginSDK.INSTANCE.logout();
    }


}