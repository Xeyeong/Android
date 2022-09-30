package com.example.and000;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView tv_name1, tv_name2, tv_name3, tv_name4;
    Button btn_order1, btn_order2, btn_order3, btn_order4;
    TextView tv_cnt1, tv_cnt2, tv_cnt3, tv_cnt4;
    TextView tv_money;
    EditText edt;
    Button btn_input, btn_output;
    int money = 0;

    //1.
    int drink1, drink2, drink3, drink4; // <= 변수이용해서 증감시킴
    //2.
    int[] drinksCnt = new int[4];
    ArrayList<Integer> list = new ArrayList<>();
    //3.
    HashMap<String, Integer> mapCnt = new HashMap<>();
    // DTO안에 수량을 저장할 변수를 따로 만들고 사용하기

    //위젯을 찾는 처리만 함
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_name1 = findViewById(R.id.tv_name1);
        tv_name2 = findViewById(R.id.tv_name2);

        tv_name3 = findViewById(R.id.tv_name3);
        tv_name4 = findViewById(R.id.tv_name4);

        tv_cnt1 = findViewById(R.id.cnt1);
        tv_cnt2 = findViewById(R.id.cnt2);
        tv_cnt3 = findViewById(R.id.cnt3);
        tv_cnt4 = findViewById(R.id.cnt4);

        btn_order1 = findViewById(R.id.btn_order1);
        btn_order2 = findViewById(R.id.btn_order2);
        btn_order3 = findViewById(R.id.btn_order3);
        btn_order4 = findViewById(R.id.btn_order4);

        tv_money = findViewById(R.id.tv_money);
        edt = findViewById(R.id.edt);

        btn_input = findViewById(R.id.btn_input);
        btn_output = findViewById(R.id.btn_output);

        btn_output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ()
            }
        });

    }

    protected void onStart() {
        super.onStart();

        tv_money.setText("잔액 " + money + " 원");
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 변수 = 에딧텍스트에 있는 숫자값을 넣는다.
                // 텍스트뷰에 있는 글씨를 변수를 이용해서 바꾼다.
                getInt(edt);

                if(getInt(edt)>0){
                    tv_money.setText("잔액 " + money + " 원");
                    money += getInt(edt);
                }else{

                }


                ArrayList<DrinkDTO> list = new ArrayList<>();
                list.add(new DrinkDTO("참이슬", 8000, 80, tv_name1, tv_cnt1, btn_order1));
                list.add(new DrinkDTO("진로", 10000, 80, tv_name2, tv_cnt2, btn_order2));
                list.add(new DrinkDTO("막걸리", 15000, 80, tv_name3, tv_cnt3, btn_order3));
                list.add(new DrinkDTO("카스", 220000, 80, tv_name4, tv_cnt4, btn_order4));

                test(list);
            }
        });


        // ArrayList <E>
        // 배열이랑 비슷 (=! 배열처럼 크기를 지정하고 사용하는게 아니라 더 편리함)
        // <E> 규칙 : 해당하는 타입에 담을수 있는 값("문자열", 숫자값, 생성자)
        //            해당하는 타입을 초기화한 변수
        // DrinkDTO dto = new DrinkDTO("콜라", 1, 2);
        // list.add(dto); list.add(new DrinkDTO("콜라", 1, 2);

    }

    // outPut 고정된 edt라는 에딧텍스트의 글자만 판별

    // edittext를 파라미터로 보내고 해당하는 에딧텍스트에 있는 값이 숫자인것을 판단해서 알고싶다.
    //
    public int getInt(EditText editText) {
        try {
            if (Integer.parseInt(editText.getText().toString()) > 0) {
                return Integer.parseInt(editText.getText().toString());
            }
        } catch (Exception e) {
            Log.d("오류", "getInt: " + e.getMessage());
        }
            return -1;
    }

    //메소드 정의 데이터타입과 변수이름 ( 해당하는 데이터가 필요하기때문에 받을 준비 )
    void test(ArrayList<DrinkDTO> list){
        for (int i = 0; i < list.size(); i++){
            final int idx = i;

            list.get(i).btn_order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(money < list.get(idx).getPrice()){
                        //현재 입력한 금액이 음료의 금액보다 작으면, 음료는 나올수가 없음.
                        Toast.makeText(MainActivity.this, "금액부족", Toast.LENGTH_SHORT).show();
                    }else{
                        list.get(idx).setCnt(list.get(idx).getCnt()-1);
                        money -= list.get(idx).getPrice();
                        tv_money.setText(" 잔액 : " + money + " 원 ");
                    }
                    if(list.get(idx).getCnt() <= 0){
                        list.get(idx).tv_cnt.setText("품절");
                        list.get(idx).btn_order.setEnabled(false);
                    }
                }
            });
            // dto1.
        }
    }

}





