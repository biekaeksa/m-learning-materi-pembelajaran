package com.biekaeksa.mlearning_materi_pembelajaran.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader {

    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public static void loadWithErrorDrawable(Context context, String url, Drawable errorDrawable, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().error(errorDrawable))
                .into(imageView);
    }

    public static void loadWithCache(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(imageView);
    }

    public static void loadWithCache(Context context, String url, Drawable errorDrawable, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().error(errorDrawable))
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(imageView);
    }
}
