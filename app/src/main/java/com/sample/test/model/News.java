package com.sample.test.model;

import android.databinding.BaseObservable;

public class News extends BaseObservable {

    public String title;
    public String desc;
    public String image;


    public News(String title, String desc, String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
