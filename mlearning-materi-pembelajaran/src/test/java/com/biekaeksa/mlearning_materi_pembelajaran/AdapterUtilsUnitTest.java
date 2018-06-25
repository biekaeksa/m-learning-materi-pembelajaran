package com.biekaeksa.mlearning_materi_pembelajaran;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.biekaeksa.mlearning_materi_pembelajaran.adapterutils.AdapterUtils;
import com.biekaeksa.mlearning_materi_pembelajaran.image.ImageLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Test
    public void layoutInflater_isCorrect() {
        PowerMockito.mockStatic(AdapterUtils.class);
        PowerMockito.mock(LayoutInflater.class);
        when(AdapterUtils.setLayoutInflater(context, anyInt())).thenReturn(view);
        assertEquals(view, AdapterUtils.setLayoutInflater(context, anyInt()));
    }

//
//    @Test
//    public void clickItemCallbackT_isCorrect() {
//        String tes = "tes";
//        final String[] hasil = new String[1];
//
//
//        ExampleClass exampleClass = new ExampleClass();
//        hasil[0] = exampleClass.getItem();
//
//        assertEquals("tes", hasil[0]);
//    }
//
//    class ExampleClass implements AdapterUtils.ListenerItem<String> {
//        private String item;
//        @Override
//        public void clickItem(String s) {
//            setItem(s);
//        }
//
//        public String getItem() {
//            return item;
//        }
//
//        public void setItem(String item) {
//            this.item = item;
//        }
//    }

}