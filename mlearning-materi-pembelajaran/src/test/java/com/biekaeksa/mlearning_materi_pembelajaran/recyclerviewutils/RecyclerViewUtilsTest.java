package com.biekaeksa.mlearning_materi_pembelajaran.recyclerviewutils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

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
@PrepareForTest(RecyclerViewUtils.class)
public class RecyclerViewUtilsTest {
    @Mock
    private Context context;
    @Mock
    private LinearLayoutManager layoutManager;
    @Mock
    private GridLayoutManager gridLayoutManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(RecyclerViewUtils.class);
    }

    @Test
    public void setLayoutLinear() {
        when(RecyclerViewUtils.setLayoutLinear(context)).thenReturn(layoutManager);
        verify(RecyclerViewUtils.setLayoutLinear(context));
    }

    @Test
    public void setLayoutHorizontal() {
        when(RecyclerViewUtils.setLayoutHorizontal(context)).thenReturn(layoutManager);
        verify(RecyclerViewUtils.setLayoutHorizontal(context));
    }

    @Test
    public void setLayoutGrid() {
        when(RecyclerViewUtils.setLayoutGrid(context, 2)).thenReturn(gridLayoutManager);
        verify(RecyclerViewUtils.setLayoutGrid(context, 2));
    }
}