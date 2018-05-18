package com.biekaeksa.mlearning_materi_pembelajaran.network;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServices {
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

    public static class Builder<T> {
        private Flowable<T> flowable;

        public Builder(Flowable<T> flowable) {
            this.flowable = flowable;
        }

        public Builder() {
        }


        private interface CallBack<T> {
            void onSuccess(T response);

            void onError(Throwable e);
        }


        public Builder setFlowables(final Flowable<T> flowable) {
            this.flowable = flowable;
            return this;
        }

        public void load(final CallBack<T> callBack) {
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new FlowableSubscriber<T>() {
                        @Override
                        public void onSubscribe(Subscription s) {

                        }

                        @Override
                        public void onNext(T t) {
                            callBack.onSuccess(t);
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


    }


}
