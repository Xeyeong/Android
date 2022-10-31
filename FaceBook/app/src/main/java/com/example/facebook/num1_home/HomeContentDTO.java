package com.example.facebook.num1_home;

import android.widget.ImageView;
import android.widget.TextView;

public class HomeContentDTO {

   private int img1, contentiv1;
   private String tv1, tv2, tv3;

    public HomeContentDTO(int img1, int contentiv1, String tv1, String tv2, String tv3) {
        this.img1 = img1;
        this.contentiv1 = contentiv1;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getContentiv1() {
        return contentiv1;
    }

    public void setContentiv1(int contentiv1) {
        this.contentiv1 = contentiv1;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }
}
