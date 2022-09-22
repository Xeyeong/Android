package com.example.and06_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 인터페이스 안에 있는 메소드들은 전부다 구현해야하는 강제성을 가지고 있음.
// ex) new Interface(){
// 무조건 만들어야하는 메소드 부분
//}
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
// 안드로이드에 들어가는 모든 리소스는 res 하위 경로에서 관리
    // 리소스 ( 이미지, 동영상, 글꼴, layout 등등)
    // 이미지 -> drawable
    // ※ res경로에서는 유효성검사를 함(파일명)
    //특수문자x, 대문자x, 숫자로 시작x



    @Override   // setContentView <= xml과 자바파일을 연결 시킨다. 액티비티(화면)가 처음 실행될때 한번 실행함.
                // 위젯들을 find로 찾아서 초기화 시키거나 이벤트연결..

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //디자인 파일(xml)에 만들어둔 위젯(객체)을 찾는 방법 findViewById<-메소드 이용
        // 태그 열렸을때 썻던 종류 < Button

        Button btn = findViewById(R.id.btn); //버튼 초기화 식 findViewById <return View(widget)
        Button btn2 = findViewById(R.id.btn2);
        // 버튼이 클릭 되는 시점을 자바코드에서 받아오려면 Interface ( View.OnclickListner )

        btn.setOnClickListener(this);
        FrameLayout
        //btn2 ArrayList
        ArrayList<ImageView> nextlist = new ArrayList<>();
        ImageView view = findViewById(R.id.img1);
        ImageView view1 = findViewById(R.id.img2);
        ImageView view2 = findViewById(R.id.img3);
        ImageView view3 = findViewById(R.id.img4);


        nextlist.add(findViewById(R.id.img1));
        nextlist.add(findViewById(R.id.img2));
        nextlist.add(findViewById(R.id.img3));
        nextlist.add(findViewById(R.id.img4));
        btn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn) {
                    if (Cnt == 0) {
                        Cnt = 3;
                    } else {
                        Cnt--;
                    }
                    Log.d("버튼", "버튼2" + Cnt);
                } else if (v.getId() == R.id.btn2) {
                    if (Cnt == 0) {
                        Cnt = 3;
                    } else {
                        Cnt++;
                    }
                    Log.d("버튼", "버튼2" + Cnt);
                }
                for (int i = 0; i < nextlist.size() ; i++) {
                    nextlist.get(i).setVisibility(View.GONE);
                }
                nextlist.get(Cnt).setVisibility(View.VISIBLE);


                if(Cnt==0){
                    //imgv1.setVisibility(VISIBLE);
                }
            }



            //<= 해당하는 이미지뷰가 가장 마지막에 있어서 맨위에 있음.

            ImageView img1 = findViewById(R.id.img1);
            ImageView img2 = findViewById(R.id.img2);
            ImageView img3 = findViewById(R.id.img3);
            ImageView img4 = findViewById(R.id.img4);
        //view3.setVisibility(View.GONE);  //GONE : 숨김
            //배열 규칙 어떤 데이터타입뒤에 [] <- 배열임, (데이터 타입으로만 담을 수 있음)

            ImageView[] arr = new ImageView[4];

            ArrayList<ImageView> list = new ArrayList<>();
        });

    }

    private int Cnt = 0; // class의 블럭킹이 닫히기 전가지는 무조건 메모리에 계속 있음.
    //ImageView view = findViewById(R.id.img1);
    //ImageView view1 = findViewById(R.id.img2);
    //ImageView view2 = findViewById(R.id.img3);
    //ImageView view3 = findViewById(R.id.img4);

    ArrayList<ImageView> list = new ArrayList<>();
    @Override
    public void onClick(View v) {

        list.add(findViewById(R.id.img1));
        list.add(findViewById(R.id.img2));
        list.add(findViewById(R.id.img3));
        list.add(findViewById(R.id.img4));

        if(Cnt == 4 )
            Cnt = 0;
        for (int i = 0; i < list.size(); i++ ){
            list.get(i).setVisibility(View.GONE);

        }
        list.get(Cnt).setVisibility(View.VISIBLE);  // 전역 변수 0
        // 리스트가 어떠한 사이즈 N을 가지면 INDEX(주소) N-1 까지만 쓸수있음.
        // 현) 4, 0 ~ 3
        Cnt++;


    }



}