package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.VideoView;

import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;


/**
 * Created by Biekaeksa on 3/20/2018.
 */

public class VideoLoader {
    private AppCompatActivity activity;

    public VideoLoader(AppCompatActivity activity) {
        this.activity = activity;
    }


    public void playVideo(String urlVideo, VideoView videoView){
        Uri uriVideo = Uri.parse(urlVideo);
        videoView.setVideoURI(uriVideo);
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
        videoView.start();
    }

    public void playYoutubeVideo(YouTubePlayerView youTubePlayer, String idVideo){
        youTubePlayer.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull final YouTubePlayer youTubePlayer) {
                youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        youTubePlayer.loadVideo(idVideo, 0);
                    }
                });
            }
        }, true);

    }





}
