package com.example.and000;

import android.widget.Button;
import android.widget.TextView;

public class DrinkDTO {
    // 음료명 , 음료 가격 , 음료 갯수.

    // 각각의 데이터들을 따로 변수를 여러개 만들어서 관리하는것보다
    //하나의 객체에 대한 변수들을 클래스 아래 모아놓고 사용하면 데이터 관리가 높고 정합성이좋음.

    // ex) 음료종류4 : cola_name , cola_price , cola_cnt
    //              ..2_name ........................
    // btn1. cola_price<- cola_cnt

    private String name ;
    private int price , cnt;
    TextView tv_name, tv_cnt;
    Button btn_order;


    //신규 + 신규 : tv + Button까지 하나로 묶어서 관리하기 편하게 만든다.

    public DrinkDTO(String name, int price, int cnt, TextView tv_name, TextView tv_cnt, Button btn_order) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
        this.tv_name = tv_name;
        this.tv_cnt = tv_cnt;
        this.btn_order = btn_order;

        tv_name.setText(name + price + "원");
        tv_cnt.setText(cnt + "개 남음");
        btn_order.setText(name + "주문");
    }

    public DrinkDTO(String name, int price, int cnt, TextView tv_name, TextView tv_cnt) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
        this.tv_name = tv_name;
        this.tv_cnt = tv_cnt;
        
        tv_name.setText(name + price + "원");
        tv_cnt.setText(cnt + "개 남음");
    }
    //신규 DTO : 기존DTO + 화면에 보이는 위젯까지 묶어서 가지고있음.


    //기존 DTO : 데이터 이름, 가격, 수량의 정보만 있는 DTO
    public DrinkDTO(String name, int price, int cnt) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
        this.tv_cnt.setText(cnt+"개 남음");
    }
}
