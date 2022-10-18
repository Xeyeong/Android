package com.example.etc_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SubActivity extends AppCompatActivity implements OnMapReadyCallback {
//KeyHash : WniSo9u2Zw/lkLo2ooIy3H+J6co=
    NaverMap naverMap; // Adapter ( 화면에 보이게 하거나 모든 처리를 담당함)
    MapView map_view;   // RecyclerView같은 기능 ( 보이게만함 )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        map_view = findViewById(R.id.map_view);
        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("n6c8m31mn3"));

        map_view.getMapAsync(this);
    }




    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMaps) {
        naverMap = naverMaps;
        naverMap.setMapType(NaverMap.MapType.Hybrid);
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(35.1535583, 126.8879957))
                .animate(CameraAnimation.Easing);
        naverMap.moveCamera(cameraUpdate);
        List<Locations> l_list = new ArrayList<>();
        l_list.add(new Locations(35.1535583, 126.8879957));
        l_list.add(new Locations(35.152979, 126.886751));
        l_list.add(new Locations(35.152979, 126.886759));

        List<Marker> list = new ArrayList<>();
        for(int i = 0 ; i<l_list.size() ; i ++) {
            list.add(new Marker());
            list.get(i).setPosition(new LatLng(l_list.get(i).lat , l_list.get(i).lng));
            list.get(i).setMap(naverMap);
        }

       /* for(int i = 0 ; i<10 ; i ++){
            Marker marker = new Marker();
            marker.setPosition(new LatLng(35.1535583, 126.887975+i));
            marker.setMap(naverMap);
        }*/
    }
    public class Locations{
        double lat ,  lng;

        public Locations(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }
}