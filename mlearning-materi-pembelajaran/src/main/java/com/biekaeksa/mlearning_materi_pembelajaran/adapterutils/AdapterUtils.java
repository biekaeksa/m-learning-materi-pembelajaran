package com.biekaeksa.mlearning_materi_pembelajaran.adapterutils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

public class AdapterUtils<T> extends RecyclerView.ViewHolder {
    private View view;
    private AdapterUtils.Listener listener;
    private AdapterUtils.ListenerItem<T> listenerItem;

    public AdapterUtils(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public static View setLayoutInflater(Context context, int layoutId){
        return LayoutInflater.from(context).inflate(layoutId, null);
    }

    public interface Listener{
        void clickItem(int position);
    }

    public interface ListenerItem<T>{
        void clickItem(T t);
    }

    public void clickItem(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickItem(getAdapterPosition());
            }
        });
    }

    public void clickItem(final T t){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerItem.clickItem(t);
            }
        });
    }


}
