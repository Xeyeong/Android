package com.example.and14_allview.listview;

public class ListDTO {
    private int imgId;
    private String category , name ;

    public ListDTO(int imgId, String category, String name) {
        this.imgId = imgId;
        this.category = category;
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
