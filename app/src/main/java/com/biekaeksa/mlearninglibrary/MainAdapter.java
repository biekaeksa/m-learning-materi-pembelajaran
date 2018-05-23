package com.biekaeksa.mlearninglibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.biekaeksa.mlearning_materi_pembelajaran.adapterutils.AdapterUtils;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private Context context;
    private List<String> nama;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(AdapterUtils.setLayout(context, R.layout.activity_main));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View itemView) {
            super(itemView);
            AdapterUtils displayListString = new AdapterUtils(itemView);
            displayListString.clickItem();

        }
    }
}
