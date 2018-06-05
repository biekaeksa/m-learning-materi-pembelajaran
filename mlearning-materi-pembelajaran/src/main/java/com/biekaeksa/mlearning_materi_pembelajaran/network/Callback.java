package com.biekaeksa.mlearning_materi_pembelajaran.network;

public interface Callback<T> {
    void onResponse(T t);

    void onError(Throwable e);

}
