package com.example.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        btnSetText(btn1);
        btnSetText(btn2);
        btnSetText(btn3);
        btnSetText(btn4);
        // 메소드 ( 기능 ) : 호출 (Method Call) 했을때 어떤 기능들을 실행하고 결과값이 필요하면 결과값을 명시해주면 됨.
        // 어떤것이든 메소드의 파라메터가 될 수 있고 어떤것이든 return 할수있음.

        // 메소드가 리턴하는 타입이 주어지면 해당하는 타입의 변수라고 생각하면 편함.
        rtnBtn().setText("메소드로 리턴받은 버튼 글씨바꿈.");


        ViewHolder h = new ViewHolder();
        h.btn1.setText("zzzz");
        h.btn2.setText("zzzz");
        h.btn3.setText("zzzz");
        h.btn4.setText("zzzz");
    }

    void btnSetText(Button btn){
        btn.setText("글씨 메소드로 바꿈.");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "테스트", Toast.LENGTH_SHORT).show();
            }
        });
    }
    Button rtnBtn(){

        return findViewById(R.id.btn1);
    }

    // 데이터 묶어놓은 객체 == DTO , VO
    // 위젯을 묶어놓은 객체

    public class ViewHolder{
        Button btn1, btn2 , btn3 , btn4;
        // ItemView v 가 생성자에 있는 이유.
        // 위젯의 갯수가 ViewHolder마다 다르기 때문에 표준을 레이아웃을 붙이고나서 안에있는 모든것들이 들어있는 View 객체로 해놓음.
        public ViewHolder() {
           btn1 = findViewById(R.id.btn1);
           btn2 = findViewById(R.id.btn2);
           btn3 = findViewById(R.id.btn3);
           btn4 = findViewById(R.id.btn4);
        }
    }

    // DTO의 생성자 , 값.(String으로 된 값이 필요함)
    public class DTO {
        String val1, val2, val3, val4;

        public DTO(String val1, String val2, String val3, String val4) {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
            this.val4 = val4;
        }
    }

}