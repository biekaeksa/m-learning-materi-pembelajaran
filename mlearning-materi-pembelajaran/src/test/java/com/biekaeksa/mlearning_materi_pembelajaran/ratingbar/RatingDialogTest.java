package com.biekaeksa.mlearning_materi_pembelajaran.ratingbar;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@PrepareForTest(RatingDialog.class)
public class RatingDialogTest {
    @Mock
    RatingDialog ratingDialog;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showRatingDialog() {
        ratingDialog.setTitle("TES");
        ratingDialog.setRating(2);
        ratingDialog.setDescription("Class Android");
        ratingDialog.setHint("Comment");
        ratingDialog.showRatingDialog();

        verify(ratingDialog).setTitle("TES");
        verify(ratingDialog).setRating(2);
        verify(ratingDialog).setDescription("Class Android");
        verify(ratingDialog).setHint("Comment");
        verify(ratingDialog).showRatingDialog();
    }
}