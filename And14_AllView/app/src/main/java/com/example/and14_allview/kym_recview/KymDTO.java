package com.example.and14_allview.kym_recview;

public class KymDTO {

    private int imgRes ;
    private String tv_title , tv_rank , tv_singer;

    public KymDTO(int imgRes, String tv_title, String tv_rank, String tv_singer) {
        this.imgRes = imgRes;
        this.tv_title = tv_title;
        this.tv_rank = tv_rank;
        this.tv_singer = tv_singer;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_rank() {
        return tv_rank;
    }

    public void setTv_rank(String tv_rank) {
        this.tv_rank = tv_rank;
    }

    public String getTv_singer() {
        return tv_singer;
    }

    public void setTv_singer(String tv_singer) {
        this.tv_singer = tv_singer;
    }
}
