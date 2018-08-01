package com.biekaeksa.mlearning_materi_pembelajaran;

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
@PrepareForTest(ImageLoader.class)
public class ImageLoaderUnitTest {
    @Mock
    private Context context;
    @Mock
    private ImageView imageView;
    @Mock
    private Drawable drawable;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(ImageLoader.class);

    }

    @Test
    public void testLoadImage() {
        String url = "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png";
        ImageLoader.load(context, url, imageView);

        PowerMockito.verifyStatic();
        Log.d("Error : ", " No Internet");
    }

    @Test
    public void testLoadImageWithCache() {
        ImageLoader.loadWithCache(context,
                "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                imageView);

    }

    @Test
    public void testLoadImageWithError() {
        ImageLoader.loadWithErrorDrawable(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                drawable, imageView);
        verify(ImageLoader.class);
    }

    @Test
    public void testLoadImageWithErrorCache() {
        ImageLoader.loadWithCache(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                drawable, imageView);
        verify(ImageLoader.class);
    }

}
