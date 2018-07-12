package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.mockito.internal.configuration.PowerMockitoInjectingAnnotationEngine;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
@PrepareForTest(VideoLoader.class)
public class VideoLoaderTest {

    @Mock
    private VideoView videoView;
    @Mock
    private AppCompatActivity activity;
    @Mock
    private YouTubePlayerView youTubePlayerView;
    @Mock
    private Intent intent;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.mock(VideoLoader.class);
    }

    @Test
    public void playVideo() {
//        VideoLoader videoLoader = new VideoLoader(activity);
//
//        try {
//            PowerMockito.whenNew(Intent.class)
//                    .withArguments(String.class).thenReturn(intent);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}