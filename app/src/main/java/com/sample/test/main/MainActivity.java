package com.sample.test.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sample.test.R;
import com.sample.test.adapter.CustomAdapter;
import com.sample.test.viewmodel.NewsModel;

import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.sample.test.network.NetworkRequest.getNews;

public class MainActivity extends AppCompatActivity implements Observer<List<NewsModel>> {

    @BindView(R.id.recycle)
    RecyclerView recyclerView;
    private List<NewsModel> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getNewsFromNetwork();
    }

    private Observable<List<NewsModel>> getPageIndexObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends List<NewsModel>>>() {
            @Override
            public ObservableSource<? extends List<NewsModel>> call() {
                return Observable.just(getNews(MainActivity.this));
            }
        });
    }


    private void getNewsFromNetwork() {
        getPageIndexObservable().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<NewsModel> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        setNewsAdapter();
    }

    private void setNewsAdapter() {
        recyclerView.setAdapter(new CustomAdapter(newsList));
    }
}
