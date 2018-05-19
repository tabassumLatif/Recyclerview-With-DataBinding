package com.sample.test.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sample.test.databinding.NewsBinding;
import com.sample.test.listeners.ClickListener;
import com.sample.test.viewmodel.NewsModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NewsView> {


    private List<NewsModel> newsList;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<NewsModel> newsList) {
        this.newsList = newsList;
    }

    @Override
    public NewsView onCreateViewHolder(final ViewGroup parent, final int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        final NewsBinding newsBinding = NewsBinding.inflate(layoutInflater, parent, false);
        newsBinding.setPresenter(new ClickListener() {
            @Override
            public void onclickListener() {
                Log.d("click me ", "click me " + newsBinding.getNewsview().title);
                Toast.makeText(parent.getContext(), "" + newsBinding.getNewsview().title, Toast.LENGTH_LONG).show();
            }
        });

        return new NewsView(newsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsView holder, int position) {
        NewsModel newsModel = newsList.get(position);
        holder.bind(newsModel);
    }

    @Override
    public int getItemCount() {
        return newsList == null ? 0 : newsList.size();
    }

    public class NewsView extends RecyclerView.ViewHolder {

        private NewsBinding newsBinding;

        NewsView(NewsBinding newsBinding) {
            super(newsBinding.getRoot());
            this.newsBinding = newsBinding;
        }

        void bind(NewsModel newsModel) {
            this.newsBinding.setNewsview(newsModel);
        }

        public NewsBinding getNewsBinding() {
            return newsBinding;
        }

    }
}
