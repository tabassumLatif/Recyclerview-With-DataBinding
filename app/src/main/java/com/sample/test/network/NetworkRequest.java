package com.sample.test.network;

import android.content.Context;

import com.sample.test.viewmodel.NewsModel;

import java.util.ArrayList;
import java.util.List;

import static com.sample.test.utils.NetworkAvailable.isNetworkAvaliable;

public abstract class NetworkRequest {


    public static List<NewsModel> getNews(final Context context) {
        List<NewsModel> news = new ArrayList<>();
        if (isNetworkAvaliable(context)) {
            try {
                /*news = Ion.with(context)
                        .load(URL)
                        .as(new TypeToken<List<NewsModel>>() {
                        }).get();*/
                news = getLocalImages();
                if (isNull(news)) {
                    news = new ArrayList<>();
                }
                return news;
            } catch (Exception e) {
                news = new ArrayList<>();
            }
        }
        return news;
    }

    private static List<NewsModel> getLocalImages() {
        List<NewsModel> news = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            NewsModel newsModel = new NewsModel();
            newsModel.title = "Title " + index;
            newsModel.desc = "This is first title " + index;
            newsModel.image = "https://actondemo5.com/wp-content/uploads/2017/07/3.jpg";
            news.add(newsModel);
        }
        return news;
    }

    private static boolean isNull(Object object) {
        return object == null;
    }
}
