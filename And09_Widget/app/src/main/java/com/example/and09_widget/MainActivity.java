package com.example.and09_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    EditText edt;
    View v1;
    EditText edt2;
    Button btn;
    RadioButton man;
    RadioButton woman;
    RadioGroup grp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    tv = findViewById(R.id.tv1);
    tv.setOnClickListener(this);

    edt = findViewById(R.id.edt1);
    tv.setOnClickListener(this);

    v1 = findViewById(R.id.v1);
    v1.setOnClickListener(this);

    edt2 = findViewById(R.id.edt2);
    edt2.setOnClickListener(this);

    btn = findViewById(R.id.btn_check);
    btn.setOnClickListener(this);

    man = findViewById(R.id.rdo_man);
    woman = findViewById(R.id.rdo_woman);
    grp = findViewById(R.id.rdo_grp);
    grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Log.d("속성", "속성 살펴보기(디버그) : " + checkedId);
            //아이디를 리소스에 줬다면

            //리소스를 별도로 안주면 checkdId는 1~5, -1 자식 객체가 위치한 인덱스를 통해서
            //↓ 방식으로 하나씩 빼올수가 있음.
            //RadioButton temp_rdo = (RadioButton) group.getChildAt(0);

            // ※ 이방법을 권장 ※
            if(checkedId == R.id.rdo_test){
                Log.d("속성",  checkedId)
            }
            // 어떤 라디오 버튼이 클릭 되었는지에 따라서 5개의 라디오버튼에 대해
            // 로그 출력을 다르게 해보기
            // ex)아주 나쁨 => 로그( 1 + 아주나쁨 );
            // ex 중간 => 3 + "중간"
        }
    });

    man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //Radio버튼 rdo_man이라는 위젯의 체크 상태가 바뀌었을때 실행되는 메소드.
            Log.d("로그", "onCheckedChanged: " + isChecked);
            if(isChecked) {
                woman.setChecked(false);
            }
        }
    });
    woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Radio버튼 rdo_man이라는 위젯의 체크 상태가 바뀌었을때 실행되는 메소드.
                Log.d("로그", "onCheckedChanged: " + isChecked);
                if (isChecked){
                    man.setChecked(false);
                }
            }
        });
    }// 메소드 안에서 만든 어떻나 변수나 객체 등등은 전부 메소드 안에서만 사용이 가능하다.
    // return <- 메소드 안에서 어떻나 처리가 되고나서 결과가 필요할때

    //NullPointerException <- 위젯이 아직 디자인과 연결되어서 초기화가 안 된 상태 => 사용
    //↓

    int i;
    @Override
    public void onClick(View v) {
        //onclick안에 setText를 적어서?

        if (v.getId() == R.id.tv1) {
            tv.setText("oh");
        } else if (v.getId() == R.id.edt1) {
            edt.setText("와우");
        } else if (v.getId() == R.id.v1) {
            //View <- 기본적인 뷰 기능을 제외한, 목적성(글씨, 이미지, 스크롤)
            Log.d("view", "로그출력");
            v1.setBackgroundColor(Color.parseColor("#987777")); //★
        } else if (v.getId() == R.id.btn_check) {
            Log.d("로그", "버튼이 클릭 됨 :" + edt2.getText());
            // 숫자로 바꿈 == int ==> Integer ( Wrapper ) : 규칙 Integer.parseInt( String )
            // 개발자가 코딩을 하면서 유저에 의해 오류가 날것같은 부분을 try{} 블럭킹을 이용해서 지역을 만든다.
            try {
                int num = Integer.parseInt(edt2.getText()+""); //Edittable => String ↑
                Log.d("로그", "성공");
                if(num >= 0){
                    btn.setText("성공" + "(" + num + ")");
                }
            }catch(Exception e){
                // 실패했을때도 버튼에 실패라는 글씨와 함께 입력한 값이 찍히게 코딩해보기
                // ex) -1 <- 띄어쓰기 실패 (-1 )

                btn.setText("실패" + "(" + edt2.getText() + ")");
                Log.d("로그", "오류 : " + e.getMessage());
            }

        }
    }
}







