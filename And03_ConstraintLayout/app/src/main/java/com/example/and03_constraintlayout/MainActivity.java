package com.example.and03_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//ConstraintLayout(제약): 장점 마우스로 컴팩트 하게 간단하고 빠르게 디자인을 넣을수가있음.
    // 제약조건을 준 레이아웃(기준)이 이동하면 같이 이동이 된다.

    // 단점 : 제약조건을 준 레이아웃(기준)의 아이디가 변하면 오류가 발생한다.
    //        중간에 위젯을 끼워넣기가 힘듬.(제약조건)

    // 사용빈도가 낮으나 안드로이드에서 기본으로 제공을 하기때문에 사용법 정도는 간단하게 알기만하면 된다.

    //디자인(xml)에서 추가한 모든 위젯들은 사실 java 객체 이다.※
    //xml에 어떤 위젯을 추가하고 id를 부여하면 R이라는 클래스(Resources)에 모두 자동으로 올라감(==int)
    //해하는 위젯을 R클래스 로부터 찾아서 어떠한 처리를 모두한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("레이아웃", R.layout.activity_main + " ");
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.tv1); //Android에서 현재 화면에 있는 위젯을 찾는다.
        tv1.setText(" 바꾼 글씨 이름 ");
        TextView tv2 = findViewById(R.id.tv2);
        tv2.setText(" 바꾼 글씨 상태메세지 ");
        //tv2를 찾아서 글씨를 바꾼 글씨 상태메세지 <- 라고 바꿔보기.
        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        Button btn_sum = findViewById(R.id.btn_sum);
        Button btn_minus = findViewById(R.id.btn_minus);
        //글씨를 쓸때 => setText 자바코드로 글씨를 씀.
        //글씨를 가져올때=> getText 자바코드로 글씨를 가져옴.
        Log.d("레이아웃", edt1.getText()+"");
        Log.d("레이아웃", edt2.getText()+"");


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("레이아웃",
                        Integer.parseInt(edt1.getText()+"")-
                                Integer.parseInt(edt2.getText()+"")+""

                );
            }
        };

        btn_minus.setOnClickListener(listener);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Button이 핸드폰 화면에서 클릭됨을 감지함(os)
                // 여기부분 메소드를 그때 실행함.
                Log.d("레이아웃", "onClick: ");
                Log.d("레이아웃", edt1.getText()+"");
                Log.d("레이아웃", edt2.getText()+"");
                // log를 이용해서 edt1과 edt2의 합을 구하는 처리를 해보기.
                // ex) edt(10) , edt(20) = 30 로그에 찍히면 됨.
                Log.d("레이아웃", 10 + 20 + "");
                Log.d("레이아웃",
                        Integer.parseInt(edt1.getText()+"")+
                        Integer.parseInt(edt2.getText()+"")+""

                );
                // edt(editable)=> String => int


                // 안드로이드에서 기본적으로 옵저버 패턴을 사용하는 이유 ※
                // 버튼을 사용자가 클릭한 시점을 정확히 개발자는 판단할수가없음
                // Android Os가 인터페이스에서 익명의 메소드로 구현해서 넘겨놓은 부분을 실행해줌.
            }
        });

    /*    kymSetOnclickListner(new KymOnclickListner() {
            @Override
            public void onClick(String v) {
                // 인터페이스 구조를 활용해서 메소드를 미리 저장해둠.=> 실행 x
                Log.d("레이아웃", " KYM 여기 실행이됨??? ");

            }
        });*/
  /*      kymSetOnclickListner(new KymOnclickListner() {
            @Override
            public void onClick(String v) {
                Log.d("레이아웃", " 다른 처리 다른화면 ");
            }
        });*/
    }
    KymOnclickListner l ;
    public void kymSetOnclickListner(KymOnclickListner l){
        //l.onClick("실행됨");
        this.l = l;
    }


    public interface KymOnclickListner{
        public void onClick(String v);
    }

    // <input type="text" name="aa" id="aa" value="123456">
    //function aa (){
        // document.getElementById('aa')
        // val tag =  document.getElementById('aa') ;
    //}JS ==> AND : findViewById(R클래스명시.id.실제값);


}