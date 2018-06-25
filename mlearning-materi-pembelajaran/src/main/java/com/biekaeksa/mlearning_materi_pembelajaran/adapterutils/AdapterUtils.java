package com.biekaeksa.mlearning_materi_pembelajaran.adapterutils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class AdapterUtils<T> {
    private View view;
    private AdapterUtils.ListenerItem<T> listenerItem;

    public AdapterUtils(View itemView) {
        this.view = itemView;
    }

    public AdapterUtils() {
    }

    public static View setLayoutInflater(Context context, int layoutId) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }


    public interface ListenerItem<T> {
        void clickItem(T t);
    }

    public void clickItem(final T t) {
        listenerItem.clickItem(t);
    }

}
