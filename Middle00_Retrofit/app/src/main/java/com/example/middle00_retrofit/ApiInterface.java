package com.example.middle00_retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {
    // BaseUrl 외에 다른 맵핑들을 요청하기위한 설계도.
    // (localhost/middle <- BaseUrl + Mapping)
    // list.cu , list.hr ... 등등

    @FormUrlEncoded // String으로 맵핑을 받겠다.
    @POST
    Call<String> getData(@Url String url , @FieldMap HashMap<String,String> params);

}
