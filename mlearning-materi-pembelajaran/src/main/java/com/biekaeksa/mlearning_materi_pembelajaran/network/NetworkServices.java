package com.biekaeksa.mlearning_materi_pembelajaran.network;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
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
    public static class Builder {
        private String url;
        private Observable<Object> observable;

        public Builder(String url, Observable<Object> observable) {
            this.url = url;
            this.observable = observable;
        }

        public Builder() {
        }

        private Retrofit create(String url) {
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


        private interface CallBack {
            void onSuccess(Object response);

            void onError(Throwable e);
        }


        public Builder observables(final Observable<Object> observable) {
            this.observable = observable;
            return this;
        }

        public void load(final CallBack callBack) {
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<Object>() {
                        @Override
                        public void onNext(Object o) {
                            callBack.onSuccess(o);
                        }

                        @Override
                        public void onError(Throwable e) {
                            callBack.onError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        }


    }


}
