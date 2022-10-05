package com.example.and14_allview.recyclerview;


public class RecDTO {
//
//    ImageView imgv_profile , imgv_noti ;
//    TextView tv_name , tv_msg , tv_date;
    private int imgDrw ;
    private boolean isNoti ;
    private String name , msg , date;

    public RecDTO(int imgDrw, boolean isNoti, String name, String msg, String date) {
        this.imgDrw = imgDrw;
        this.isNoti = isNoti;
        this.name = name;
        this.msg = msg;
        this.date = date;
    }


    public int getImgDrw() {
        return imgDrw;
    }

    public void setImgDrw(int imgDrw) {
        this.imgDrw = imgDrw;
    }

    public boolean isNoti() {
        return isNoti;
    }

    public void setNoti(boolean noti) {
        isNoti = noti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
