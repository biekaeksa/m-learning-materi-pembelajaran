package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.VideoView;

import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(Log.class)
public class VideoLoaderTest {
    @Mock
    private VideoLoader videoLoader;
    @Mock
    private VideoView videoView;
    @Mock
    private AppCompatActivity activity;
    @Mock
    private YouTubePlayerView youTubePlayerView;


    private String url;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(Log.class);
        url = "https://www.tes.com/video.mp4";
    }

    @Test
    public void playVideoErrorUrl() {
        String errorUrl = "https://www.tes.com/video";
        videoLoader.playVideo(errorUrl, videoView);
        PowerMockito.verifyStatic(Mockito.times(1));
        Log.d("Error Video", "Video Url is wrong");
    }

    @Test
    public void playVideoSuccess() {
        videoLoader.playVideo(url, videoView);
        Mockito.verify(videoLoader).playVideo(url, videoView);
    }


    @Test
    public void playYoutubeVideoSuccess() {
        videoLoader.playYoutubeVideo(youTubePlayerView, "Xq_rsB8sbmI");
        Mockito.verify(videoLoader).playYoutubeVideo(youTubePlayerView, "Xq_rsB8sbmI");
    }

    @Test
    public void playYoutubeVideoErrorId() {
        videoLoader.playYoutubeVideo(youTubePlayerView, "1asd");
        PowerMockito.verifyStatic(Mockito.times(1));
        Log.d("Error Youtube Video", "Video Youtube Not Found");
    }


}