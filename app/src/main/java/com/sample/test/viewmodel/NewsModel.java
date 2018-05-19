package com.sample.test.viewmodel;


import com.sample.test.model.News;

public class NewsModel {

    public String title;
    public String desc;
    public String image;


    public NewsModel() {
    }

    public NewsModel(News news) {
        this.title = news.title;
        this.desc = news.desc;
        this.image = news.image;
    }
}
