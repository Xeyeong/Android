package com.example.and02_layout;

public class TestDTO {
    private String field1;
    private int field2;
    private double field3;
    //constructor getter & setter 등 규칙을 가진 코드 자동완성
    // alt + insert

    //MainActivty for문 작업한거 밑에서 TestDTO생성하고
    //로그로 필드1,2,3을 출력해보기.

    //메소드 정의부
    public TestDTO(String field1, int field2, double field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public double getField3() {
        return field3;
    }

    public void setField3(double field3) {
        this.field3 = field3;
    }
}
