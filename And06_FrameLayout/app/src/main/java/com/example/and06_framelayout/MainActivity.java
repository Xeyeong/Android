package com.example.and06_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

// 인터페이스 안에 있는 메소드들은 전부다 구현해야하는 강제성을 가지고있음.
// ex) new Interface(){
// 무조건 만들어야하는 메소드 부분
//}
public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
// 안드로이드에 들어가는 모든 리소스는 res 하위 경로에서 관리함.
    // 리소스 (이미지 , 동영상 , 글꼴 , Layout 등등 )
    //이미지 -> drawble
    //※res경로에서는 유효성검사를 함(파일명)
    //특수문자 x , 대문자 x , 숫자로 시작 x

    //Button btn = findViewById(R.id.btn); <= 아직 xml파일이 로딩이 안되었기때문에 find를해도 null임.
    //ImageView imgv1;
    //ImageView imgv2;
    //ImageView imgv3;
    //ImageView imgv4;
    ArrayList<ImageView> imgList = new ArrayList<>();
    @Override // setContentView <= xml과 자바파일을 연결 시킨다. 액티비티(화면)가 처음 실행될때 한번 실행함.
              // 위젯들을 find로 찾아서 초기화시키거나 이벤트연결..
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 디자인 파일(xml)에 만들어둔 위젯(객체)을 찾는 방법 findViewById<-메소드 이용.
        // 태그 열렸을때 썼던 종류. <Button
        // 버튼 초기화 식 findViewById <- return View(widget);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        imgList.add(findViewById(R.id.imgv1));//?
        imgList.add(findViewById(R.id.imgv2));//?
        imgList.add(findViewById(R.id.imgv3));//?
        imgList.add(findViewById(R.id.imgv4));//?
        // imgv1 = findViewById(R.id.imgv1);
        // imgv2 = findViewById(R.id.imgv2);
        // imgv3 = findViewById(R.id.imgv3);
        // imgv4 = findViewById(R.id.imgv4);//<= 해당하는 이미지뷰가 가장 마지막에 있어서 맨위에 있음.

    }//onCreate

    int i = 0 ; // class의 블럭킹이 닫히기 전까지는 무조건 메모리에 계속 있음.

    @Override
    public void onClick(View v) {
        // R이라는 클래스에 btn1이라는 변수명을 가지고 int형으로 저장됨
        if(v.getId() == R.id.btn1){
           if(i==0) {
               i = 3;
           }else{
               i --;
           }
            Log.d("버튼", " 버튼 1" + i);
            // i . 0 : 3
            // i . 3 : 2
            // i . 2 : 1
            // i . 1 : 0

        }else if(v.getId() == R.id.btn2){
            if(i==3) {
                i = 0;
            }else{
                i ++;
            }
            Log.d("버튼", " 버튼 2" + i);
            // i . 0 : 1
            // i . 1 : 2
            // i . 2 : 3
            // i . 3 : 0
        }
        for (int i = 0; i < imgList.size() ; i++) {
            imgList.get(i).setVisibility(View.GONE);
        }
        imgList.get(i).setVisibility(View.VISIBLE);


        if(i==0){
            //imgv1.setVisibility(VISIBLE);
        }
//        if(i==3) i=0;
//        //imgList에 있는 모든 이미지뷰가 안보이게 만들기.
//        for (int i = 0; i < imgList.size() ; i++) {
//            imgList.get(i).setVisibility(View.GONE);
//        }
//        imgList.get(i).setVisibility(View.VISIBLE); // 전역 변수 0
//        // 리스트가 어떠한 사이즈 N을 가지면 INDEX(주소) N-1 까지만 쓸수있음.
//        // 현) 4 , 0~3
//        Log.d("버튼", " 클릭됨" + i);
//        i ++ ;
    }




    /*  void method1(ArrayList<Object> list){

     }
     void method2(String[] arr){

     }

     */
    /*void setOnclickListnerTest(TestOnclick l){

    }
    public interface TestOnclick{
        void onClick();
    }*/
//   public interface TestOnclick{
//       void testMethod();
//   }
}