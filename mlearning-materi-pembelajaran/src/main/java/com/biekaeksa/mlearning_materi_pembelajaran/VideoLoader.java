package com.biekaeksa.mlearning_materi_pembelajaran;

import android.content.Context;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Biekaeksa on 3/20/2018.
 */

public class VideoLoader {
    private String urlVideo;
    private VideoView videoView;
    private Context context;

    public VideoLoader(String urlVideo, VideoView videoView, Context context) {
        this.urlVideo = urlVideo;
        this.videoView = videoView;
        this.context = context;
    }

    public void playbackControls(){
        MediaController vidControl = new MediaController(context);
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
    }

    public void playVideo(){
        Uri uriVideo = Uri.parse(urlVideo);
        videoView.setVideoURI(uriVideo);
        videoView.start();

        playbackControls();
    }

}
