package com.biekaeksa.mlearning_materi_pembelajaran.network;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.Collections;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@PrepareForTest(NetworkServices.class)
public class NetworkServicesTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void urlNetwork() {

    }

    @Test
    public void subscribe() {

    }
}