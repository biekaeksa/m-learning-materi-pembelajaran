package com.biekaeksa.mlearning_materi_pembelajaran.network;

public class CourseModel {private String judul;
    private String thumbnail;
    private int rating;
    private int jumlah_rating;
    private int jumlah_enroll;
    private String category;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getJumlah_rating() {
        return jumlah_rating;
    }

    public void setJumlah_rating(int jumlah_rating) {
        this.jumlah_rating = jumlah_rating;
    }

    public int getJumlah_enroll() {
        return jumlah_enroll;
    }

    public void setJumlah_enroll(int jumlah_enroll) {
        this.jumlah_enroll = jumlah_enroll;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
