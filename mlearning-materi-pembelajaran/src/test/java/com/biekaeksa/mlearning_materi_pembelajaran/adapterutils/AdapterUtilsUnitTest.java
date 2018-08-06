package com.biekaeksa.mlearning_materi_pembelajaran.adapterutils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.biekaeksa.mlearning_materi_pembelajaran.adapterutils.AdapterUtils;
import com.biekaeksa.mlearning_materi_pembelajaran.image.ImageLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AdapterUtils.class)
public class AdapterUtilsUnitTest {
    @Mock
    private Context context;
    @Mock
    private View view;
    @Mock
    private AdapterUtils.ListenerItem<String> listenerItem;
    @Mock
    private
    AdapterUtils<String> adapterUtils;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(AdapterUtils.class);
    }

    @Test
    public void layoutInflater_isCorrect() {
        when(AdapterUtils.setLayoutInflater(context, 2)).thenReturn(view);
        assertEquals(view, AdapterUtils.setLayoutInflater(context,2));

        verify(AdapterUtils.class);
    }

    @Test
    public void clickItemCallbackT_isCorrect() {
        adapterUtils.clickItem("This Click Item");
        listenerItem.clickItem("This Click Item");

        verify(adapterUtils).clickItem("This Click Item");
        verify(listenerItem).clickItem("This Click Item");
    }



}