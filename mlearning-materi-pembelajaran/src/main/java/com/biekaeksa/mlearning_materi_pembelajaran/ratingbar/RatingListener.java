package com.biekaeksa.mlearning_materi_pembelajaran.ratingbar;

public interface RatingListener {
    void positiveButtonClicked(int rate, String comment);

    void negativeButtonClicked();

    void neutralButtonClicked();
}
