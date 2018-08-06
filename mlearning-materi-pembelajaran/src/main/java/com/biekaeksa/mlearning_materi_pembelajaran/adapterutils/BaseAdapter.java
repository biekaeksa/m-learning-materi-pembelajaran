package com.biekaeksa.mlearning_materi_pembelajaran.adapterutils;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, VH extends BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {
    private List<T> item;
    private Context context;

    public BaseAdapter(Context context) {
        this.context = context;
        item = new ArrayList<>();
    }

    @NonNull
    @Override
    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        T items = item.get(position);
        holder.onBind(items);
    }

    @Override
    public int getItemCount() {
        return item != null ? item.size() : 0;
    }

    public void setItem(List<T> item){
        if (item == null) throw new IllegalArgumentException("Cannot set null to item RecyclerView Item");
        this.item.clear();
        this.item.addAll(item);
        notifyDataSetChanged();
    }

    public T items(int position) {
        return this.item.get(position);
    }

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Cannot add `null` to Recyclerview");
        this.item.add(item);
        notifyItemInserted(this.item.size() - 1);
    }

    public void addAll(List<T> items) {
        if (items == null) throw new IllegalArgumentException("Cannot add `null` to Recyclerview");
        this.item.addAll(items);
        notifyItemRangeInserted(this.item.size() - items.size(), items.size());
    }

    public void clear() {
        this.item.clear();
        notifyDataSetChanged();
    }

    public void remove(T item) {
        int position = this.item.indexOf(item);
        if (position > -1) {
            this.item.remove(position);
            notifyItemRemoved(position);
        }
    }

    public boolean isAdapterEmpty() {
        return getItemCount() == 0;
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @NonNull
    protected View inflate(@LayoutRes final int layout){
        return LayoutInflater.from(context).inflate(layout, null);
    }


}
