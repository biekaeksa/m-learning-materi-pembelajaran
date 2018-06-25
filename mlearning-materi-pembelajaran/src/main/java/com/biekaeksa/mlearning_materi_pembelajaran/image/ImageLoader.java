package com.biekaeksa.mlearning_materi_pembelajaran.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader {
    /**
     * Method untuk menampilkan gambar
     * @param context untuk memberikan akses atas application state
     * @param imageView imageview yang akan menampilkan gambar
     * @param url url yang digunakan untuk load gambar
     */
    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    /**
     * Method untuk menampilkan gambar dengan menampilkan gambar error apabila gagal load gambar
     * @param context untuk memberikan akses atas application state
     * @param url url yang digunakan untuk load gambar
     * @param errorDrawable placeholder untuk menggantikan gambar apabila gagal diload
     * @param imageView imageview yang akan menampilkan gambar
     */
    public static void loadWithErrorDrawable(Context context, String url, Drawable errorDrawable, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().error(errorDrawable))
                .into(imageView);
    }

    /**
     * Method untuk menampilkan gambar dengan cache agar tiap scrolling tidak load gambar lagi
     * @param context untuk memberikan atas application state
     * @param url url yang digunakan untuk load gambar
     * @param imageView imageview yang akan menampilkan gambar
     */
    public static void loadWithCache(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(imageView);
    }

    /**
     * Method untuk menampilkan gambar dengan cache dan error placeholder
     * @param context untuk memberikan atas application state
     * @param url url yang digunakan untuk load gambar
     * @param errorDrawable placeholder yang digunakan apabila gagal load gambar
     * @param imageView digunakan untuk menampilkan gambar
     */
    public static void loadWithCache(Context context, String url, Drawable errorDrawable, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().error(errorDrawable))
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(imageView);
    }
}
