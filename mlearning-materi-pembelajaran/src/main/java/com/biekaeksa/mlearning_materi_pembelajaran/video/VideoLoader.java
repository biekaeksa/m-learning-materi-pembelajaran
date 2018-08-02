package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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


    public void playVideo(String urlVideo, VideoView videoView) {
        Uri uriVideo = Uri.parse(urlVideo);
        videoView.setVideoURI(uriVideo);
        FullScreenMediaController vidControl = new FullScreenMediaController(activity);
        vidControl.setAppCompatActivity(activity);
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
        videoView.start();

        ProgressBarHandler progressBarHandler = new ProgressBarHandler(activity);
        progressBarHandler.show();

        videoView.setOnPreparedListener(mp -> progressBarHandler.hide());
    }

    public void playYoutubeVideo(YouTubePlayerView youTubePlayer, String idVideo) {
        youTubePlayer.initialize(youTubePlayer1 -> youTubePlayer1.addListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady() {
                youTubePlayer1.loadVideo(idVideo, 0);
            }
        }), true);

    }

    private class ProgressBarHandler {
        private ProgressBar mProgressBar;
        private Context mContext;

        ProgressBarHandler(Context context) {
            mContext = context;

            ViewGroup layout = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();

            mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
            mProgressBar.setIndeterminate(true);

            RelativeLayout.LayoutParams params = new
                    RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            RelativeLayout rl = new RelativeLayout(context);

            rl.setGravity(Gravity.CENTER);
            rl.addView(mProgressBar);

            layout.addView(rl, params);

            hide();
        }

        void show() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        void hide() {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }


}
