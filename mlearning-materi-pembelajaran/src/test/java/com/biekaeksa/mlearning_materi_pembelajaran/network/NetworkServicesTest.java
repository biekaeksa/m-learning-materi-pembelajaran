package com.biekaeksa.mlearning_materi_pembelajaran.network;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@PrepareForTest(NetworkServices.class)
public class NetworkServicesTest {
    @InjectMocks
    private NetworkServices<List<CourseModel>> networkServices;
    @Mock
    Callback<CourseModel> callback;
    @Captor


    private Observable<List<CourseModel>> observable;
    private String url;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        url = "http://comrades-api.azurewebsites.net/v2/";

    }

    @Test
    public void urlNetwork(){
        observable = networkServices.urlNetwork(url).create(APIService.class).getListVideo();
    }

    @Test
    public void subscribe() {
        urlNetwork();
        List<CourseModel> list = new ArrayList<>();

        networkServices.subscribe(observable, new Callback<List<CourseModel>>() {
            @Override
            public void onResponse(List<CourseModel> courseModels) {
                assertEquals(list, courseModels);
            }

            @Override
            public void onError(Throwable e) {
                fail(e.getMessage());
            }
        });
    }
}