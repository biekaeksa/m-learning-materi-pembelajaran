package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;

import com.biekaeksa.mlearning_materi_pembelajaran.R;

public class FullScreenMediaController extends MediaController {
    private ImageView imageFullScreen;
    private String isFullScreen;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public FullScreenMediaController(Context context) {
        super(context);
        this.context = context;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);

        imageFullScreen = new ImageView(super.getContext());

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL | Gravity.END;
        params.rightMargin = 90;
        params.bottomMargin = 40;
        addView(imageFullScreen, params);
        imageFullScreen.setImageResource(R.drawable.ic_image_fullscreen);
        imageFullScreen.setOnClickListener(view1 -> {
            if ("y".equals(isFullScreen)){
                appCompatActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                isFullScreen = "n";
                imageFullScreen.setImageResource(R.drawable.ic_image_fullscreen);
            }else {
                appCompatActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                appCompatActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                if (appCompatActivity.getSupportActionBar() != null) {
                    appCompatActivity.getSupportActionBar().hide();
                }
                isFullScreen = "y";
                imageFullScreen.setImageResource(R.drawable.ic_image_fullscreen_exit);
            }

        });
    }
}
