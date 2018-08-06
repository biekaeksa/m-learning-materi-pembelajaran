package com.biekaeksa.mlearning_materi_pembelajaran.network;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;


@PrepareForTest(NetworkServices.class)
public class NetworkServicesTest {

    @Mock
    private NetworkServices<List<CourseModel>> networkServices;
    @Mock
    private NetworkServices services;
    @Mock
    private Callback<List<CourseModel>> callback;

    private Observable<List<CourseModel>> observable;
    private String url;
    @Mock
    private List<CourseModel> response;
    private Retrofit rest;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        url = "http://comrades-api.azurewebsites.net/v2/";

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(15, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        rest = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Test
    public void urlNetwork() {
        Mockito.when(services.urlNetwork(url)).thenReturn(rest);
    }

    @Test
    public void subscribe() {
        observable = rest.create(APIService.class).getListVideo();
        networkServices.subscribe(observable, new Callback<List<CourseModel>>() {
            @Override
            public void onResponse(List<CourseModel> courseModels) {
                assertEquals(response, courseModels);
            }

            @Override
            public void onError(Throwable e) {
                fail(e.getMessage());
            }
        });

    }
}