package com.biekaeksa.mlearninglibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.biekaeksa.mlearning_materi_pembelajaran.adapterutils.AdapterUtils;


public class MainActivity extends AppCompatActivity implements AdapterUtils.ListenerItem<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void clickItem(String s) {

    }
}
