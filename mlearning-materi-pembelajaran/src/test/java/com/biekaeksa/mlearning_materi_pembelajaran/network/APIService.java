package com.biekaeksa.mlearning_materi_pembelajaran.network;

import org.mockito.internal.matchers.Any;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("video")
    Observable<List<CourseModel>> getListVideo();
}
