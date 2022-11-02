package com.example.lastproject.last;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient {
    private static final String BASEURL = "http://192.168.0.15/Last/";
    private static Retrofit retrofit;
    public static Retrofit getApiClient(){
        if(retrofit == null){ // 최초로 Retrofit 객체를 사용할때 초기화가 안되어있다면 그때 한번만 초기화되게 함
            retrofit  = new Retrofit.Builder()
                .baseUrl(BASEURL)// 스프링 미들웨어의 홈 주소를 의미함
                .addConverterFactory(ScalarsConverterFactory.create()) //Json String 형태 사용가능하게 함
                .build();

        }
        return retrofit;
    }
}
