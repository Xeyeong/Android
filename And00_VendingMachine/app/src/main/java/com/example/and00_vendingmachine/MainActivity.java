package com.example.and00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{

    Button btn1,btn2,btn3,btn4,btn5,btn6;
    TextView text1,text2,text3,text4,text5;
    EditText et1;

    ArrayList<MainDTO> alist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);

        et1 = findViewById(R.id.et1);

        alist.add(new MainDTO("콜라",10,800));
        alist.add(new MainDTO("사이다",10,800));
        alist.add(new MainDTO("환타",10,700));
        alist.add(new MainDTO("데미소다",10,700));

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn5){

        }
        if(v.getId() == R.id.btn1){
            if (alist.get(0).getNum() > 0) {
                alist.get(0).setNum(alist.get(0).getNum()-1);
                text1.setText(alist.get(0).getNum()+"개 남음");
            }else{
                btn1.setText("매진");
            }
        } else if (v.getId() == R.id.btn2) {
            if (alist.get(1).getNum() > 0) {
            alist.get(1).setNum(alist.get(1).getNum()-1);
            text2.setText(alist.get(1).getNum()+"개 남음");
            }else{
                btn2.setText("매진");
            }
        }else if(v.getId() == R.id.btn3){
            if(alist.get(2).getNum() > 0){
            alist.get(2).setNum(alist.get(2).getNum()-1);
            text3.setText(alist.get(2).getNum()+"개 남음");
            }else{
                btn3.setText("매진");
            }
        }else if(v.getId() == R.id.btn4){
            if(alist.get(3).getNum() > 0){
            alist.get(3).setNum(alist.get(3).getNum()-1);
            text4.setText(alist.get(3).getNum()+"개 남음");
            }else{
                btn4.setText("매진");
            }

        }
    }
}