package com.biekaeksa.mlearning_materi_pembelajaran.network;

import org.mockito.internal.matchers.Any;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("artikel")
    Observable<Any> getTest();
}
