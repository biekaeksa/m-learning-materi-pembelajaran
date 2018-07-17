package com.biekaeksa.mlearning_materi_pembelajaran.ratingbar;


import android.support.v4.app.FragmentActivity;

import com.biekaeksa.mlearning_materi_pembelajaran.R;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import java.util.Arrays;

public class RatingDialog implements RatingDialogListener {
    private FragmentActivity fragmentActivity;
    private String title;
    private String description;
    private int rating;
    private int starColor = 0;
    private int titleTextColor = 0;
    private String hint;
    private int descriptionTextColor = 0;
    private int hintTextColor = 0;
    private int commentTextColor = 0;
    private int commentBackgroundColor = 0;
    private RatingListener listener;
    private int rate;
    private String message;


    public RatingDialog(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    public String getMessage() {
        return message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStarColor(int starColor) {
        this.starColor = starColor;
    }

    public void setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }


    public void setDescriptionTextColor(int descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
    }

    public void setHintTextColor(int hintTextColor) {
        this.hintTextColor = hintTextColor;
    }

    public void setCommentTextColor(int commentTextColor) {
        this.commentTextColor = commentTextColor;
    }

    public void setCommentBackgroundColor(int commentBackgroundColor) {
        this.commentBackgroundColor = commentBackgroundColor;
    }

    private String getTitle() {
        return title;
    }

    private String getDescription() {
        return description;
    }

    private int getStarColor() {
        if (starColor == 0){
            starColor = R.color.starColor;
        }
        return starColor;
    }

    private int getTitleTextColor() {
        if (titleTextColor == 0){
            titleTextColor = R.color.titleTextColor;
        }
        return titleTextColor;
    }

    private String getHint() {
        if (hint == null){
            hint = "";
        }
        return hint;
    }


    private int getDescriptionTextColor() {
        if (descriptionTextColor == 0){
            descriptionTextColor = R.color.descriptionTextColor;
        }
        return descriptionTextColor;
    }

    private int getHintTextColor() {
        if (hintTextColor == 0){
            hintTextColor = R.color.hintTextColor;
        }
        return hintTextColor;
    }

    private int getCommentTextColor() {
        if (commentTextColor == 0){
            commentTextColor = R.color.commentTextColor;
        }
        return commentTextColor;
    }

    private int getCommentBackgroundColor() {
        if (commentBackgroundColor == 0){
            commentBackgroundColor = R.color.colorWhite;
        }
        return commentBackgroundColor;
    }


    public void showRatingDialog() {
        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNeutralButtonText("Later")
                .setNoteDescriptions(Arrays.asList("Very Bad", "Not good", "Quite ok", "Very Good", "Excellent !!!"))
                .setTitle(getTitle())
                .setDescription(getDescription())
                .setStarColor(getStarColor())
                .setDefaultRating(rating)
                .setNoteDescriptionTextColor(getStarColor())
                .setTitleTextColor(getTitleTextColor())
                .setDescriptionTextColor(getDescriptionTextColor())
                .setHint(getHint())
                .setHintTextColor(getHintTextColor())
                .setCommentTextColor(getCommentTextColor())
                .setCommentBackgroundColor(getCommentBackgroundColor())
                .setWindowAnimation(R.style.RatingDialogAnimation)
                .create(fragmentActivity)
                .show();
    }

    @Override
    public void onPositiveButtonClicked(int i, String s) {
        rate = i;
        message = s;
    }

    @Override
    public void onNegativeButtonClicked() {

    }

    @Override
    public void onNeutralButtonClicked() {

    }
}
