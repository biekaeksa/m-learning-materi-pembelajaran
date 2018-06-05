package com.biekaeksa.mlearning_materi_pembelajaran.network;

import android.content.Context;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServices<T> {
    public Retrofit urlNetwork(String url) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(15, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();


        return new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public void subscribe(Flowable<T> flowable, final Callback<T> callBack) {
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<T>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(T t) {
                        callBack.onResponse(t);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void subscribe(Observable<T> observable, final Callback<T> callback){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(T t) {
                        callback.onResponse(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
