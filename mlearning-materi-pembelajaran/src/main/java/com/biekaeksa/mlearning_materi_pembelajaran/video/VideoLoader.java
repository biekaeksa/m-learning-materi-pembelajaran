package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

/**
 * Created by Biekaeksa on 3/20/2018.
 */

public class VideoLoader {
    private String urlVideo;
    private VideoView videoView;
    private AppCompatActivity activity;

    public VideoLoader(String urlVideo, VideoView videoView, AppCompatActivity activity) {
        this.urlVideo = urlVideo;
        this.videoView = videoView;
        this.activity = activity;
    }


    public void playVideo(){
        FullScreenMediaController vidControl = new FullScreenMediaController(activity);
        if (activity.getIntent().getStringExtra("fullscreen") != null){
            if (activity.getIntent().getStringExtra("fullscreen").equals("y")){
                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                if (activity.getSupportActionBar() != null){
                    activity.getSupportActionBar().hide();
                }
            }else {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            }
        }
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
        Uri uriVideo = Uri.parse(urlVideo);
        videoView.setVideoURI(uriVideo);
        videoView.start();
    }



}
