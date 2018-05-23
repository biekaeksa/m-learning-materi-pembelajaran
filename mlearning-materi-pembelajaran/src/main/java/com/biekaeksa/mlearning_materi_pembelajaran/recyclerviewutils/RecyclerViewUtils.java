package com.biekaeksa.mlearning_materi_pembelajaran.recyclerviewutils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class RecyclerViewUtils {

    public static LinearLayoutManager setLayoutLinear(Context context){
        return new LinearLayoutManager(context){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

    public static LinearLayoutManager setLayoutHorizontal(Context context){
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

    public static GridLayoutManager setLayoutGrid(Context context, int countGrid){
        return new GridLayoutManager(context, countGrid){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }
}
