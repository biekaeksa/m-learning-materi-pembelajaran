//package com.biekaeksa.mlearning_materi_pembelajaran;
//
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//public class YoutubeLoader implements YouTubePlayer.OnInitializedListener {
//    private YouTubePlayerView youTubePlayerView;
//    private String idVideo;
//    private String youtubeApiKey;
//    private final int RECOVERY_REQUEST = 1;
//
//    public YoutubeLoader(YouTubePlayerView youTubePlayerView, String idVideo, String youtubeApiKey) {
//        this.youTubePlayerView = youTubePlayerView;
//        this.idVideo = idVideo;
//        this.youtubeApiKey = youtubeApiKey;
//        inittializeYoutube();
//
//    }
//
//    private void inittializeYoutube() {
//        youTubePlayerView.initialize(youtubeApiKey, this);
//    }
//
//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//        youTubePlayer.cueVideo(idVideo);
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//    }
//
//}
//
