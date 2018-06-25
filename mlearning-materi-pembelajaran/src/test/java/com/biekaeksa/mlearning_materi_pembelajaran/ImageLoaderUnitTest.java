package com.biekaeksa.mlearning_materi_pembelajaran;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.biekaeksa.mlearning_materi_pembelajaran.image.ImageLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    public void setup(){
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(ImageLoader.class);
    }

    @Test
    public void testLoadImage(){
        ImageLoader.load(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                imageView);
    }

    @Test
    public void testLoadImageWithCache(){
        ImageLoader.loadWithCache(context,
                "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                imageView);
    }

    @Test
    public void testLoadImageWithError(){
        ImageLoader.loadWithErrorDrawable(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                drawable, imageView);
    }

    @Test
    public void testLoadImageWithErrorCache(){
        ImageLoader.loadWithCache(context, "http://hindayani.com/wp-content/uploads/2014/05/Contoh-Introduction-Cara-Memperkenalkan-Diri-Dalam-Bahasa-Inggris.png",
                drawable, imageView);
    }

}
