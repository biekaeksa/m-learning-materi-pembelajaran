package com.biekaeksa.mlearning_materi_pembelajaran.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.ImageView;

import com.biekaeksa.mlearning_materi_pembelajaran.image.ImageLoader;
import com.biekaeksa.mlearning_materi_pembelajaran.util.NetworkUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NetworkUtils.class)
public class ImageLoaderUnitTest {
    @Mock
    private Context context;
    @Mock
    private ImageView imageView;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(ImageLoader.class);
        PowerMockito.mockStatic(Log.class);
        PowerMockito.mockStatic(NetworkUtils.class);
    }

    @Test
    public void testLoadImage() {
        String url = "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png";
        ImageLoader.load(context, url, imageView);
        verify(ImageLoader.class);
    }

    @Test
    public void testLoadImageErrorUrl() {
        String url = "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris";
        ImageLoader.load(context, url, imageView);
        PowerMockito.verifyStatic(Mockito.times(1));
        Log.e(Mockito.anyString(), Mockito.anyString());

    }

    @Test
    public void testLoadImageErrorConnection() {
        String url = "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris";
        ImageLoader.load(context, url, imageView);
        PowerMockito.verifyStatic(Mockito.times(1));
        Log.d(Mockito.anyString(), Mockito.anyString());

    }

    @Test
    public void testLoadImageWithCache() {
        ImageLoader.loadWithCache(context,
                "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                imageView);
        verify(ImageLoader.class);
    }

    @Test
    public void testLoadImageWithError() {
        ImageLoader.loadWithErrorDrawable(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                2, imageView);
        verify(ImageLoader.class);
    }

    @Test
    public void testLoadImageWithErrorCache() {
        ImageLoader.loadWithCache(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                3, imageView);
        verify(ImageLoader.class);
    }

}
