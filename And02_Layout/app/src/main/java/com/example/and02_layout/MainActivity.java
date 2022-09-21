package com.example.and02_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "메인액티비티";
    //-1.Activity : 안드로이드에서는 4가지의 큰 기능을 가진 컴포넌트들이 존재함.
    // Activity (컴포넌트) 종류중의 하나로 화면에 보이는 기능을 가지고 있다.
    // 액티비티 구별법 : Android기준으로 뒤로가기 버튼을 누를때 뒤로가지면 액티비티.

    // 액티비티에 어떤 위젯을 놓기위해서는 반드시 Layout이 필요하다 ※

    // Layout : Activity(화면)를 구현할때 어떤 방식으로 위젯을 정렬할지 (배치) 방법으로 정해놓은것.
    // ContraintLayout : 어떤 상대방을 기준으로 내위치를 지정하는 방식(배치)->마우스로 끌어다가 부모나
    //다른위젯을 어떠한 제약선으로 연결.

    //1.변수
    private String sVal = "KYM";
    public int iVal = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //<= 실제 xml파일과 자바코드를 연결해준다.
        // syso => logd※
        Log.d(TAG, "onCreate: ");
        Log.d(TAG, sVal);
        Log.d(TAG, iVal+"");// int + String = String
        //System.out.println("값 하나만 가능함.");
        // if문으로 sVal에 들어있는값이 나의 이니셜과 같다면
        //로그인되었습니다.<- 로그에 출력
        //그게 아니라면 로그인이 실패했습니다 <- 로그에 출력되게 프로그램 작성.
        if(sVal.equals("KYM")){
            Log.d(TAG, "로그인 되었습니다.");
        }else{
            Log.d(TAG, "실패!!");
        }

        // for 문
        // 1. 구구단 2단출력해보기
        for (int i = 1; i <10 ; i++) {
            Log.d(TAG, "2 X " + i + " = " + (i*2)  );
        }
        // 2. 구구단 2~9단 출력해보기. (로그)
        for (int i = 1; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
              Log.d(TAG, j +"X " + i + " = " + (i*j)  );
            }
        }
        // 생성자 메소드 public TestDTO(String field1 , int field2 , double field3);
        // 메소드 호출시 String field1 = "field1"     , int field2 = 12 , double field3 = 3.14;
        String field1 = "필드1";
        int field2 = 12;
        double field3 = 3.14;
        TestDTO dto = new TestDTO(field1 , field2 , field3);
       // TestDTO dto = new TestDTO("field1" , 12 ,3.14);
        Log.d(TAG, dto.getField1() +  "");
        Log.d(TAG, dto.getField2() +  "");
        Log.d(TAG, dto.getField3() +  "");

        TestDAO dao = new TestDAO();
        dao.testDisplay();
        //TestDAO.testDisplay();//static == logd

    }



}