package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
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
    private ProgressDialog progressDialog;

    public VideoLoader(AppCompatActivity activity) {
        this.activity = activity;
    }


    public void playVideo(String urlVideo, VideoView videoView){
        Uri uriVideo = Uri.parse(urlVideo);
        videoView.setVideoURI(uriVideo);
        FullScreenMediaController vidControl = new FullScreenMediaController(activity);
        vidControl.setAppCompatActivity(activity);
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
        videoView.start();
        progressDialog = ProgressDialog.show(activity, "Please wait ....", "Retrieving video ...", false);
        videoView.setOnPreparedListener(mp -> progressDialog.dismiss());
    }

    public void playYoutubeVideo(YouTubePlayerView youTubePlayer, String idVideo){
        youTubePlayer.initialize(youTubePlayer1 -> youTubePlayer1.addListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady() {
                youTubePlayer1.loadVideo(idVideo, 0);
            }
        }), true);

    }



}
