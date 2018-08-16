package com.biekaeksa.mlearning_materi_pembelajaran.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.biekaeksa.mlearning_materi_pembelajaran.util.NetworkUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class ImageLoader {
    public static void load(Context context, String url, ImageView imageView) {
        if (NetworkUtils.isNetworkConnected(context)){
            Glide.with(context)
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e("Error ImageLoader ", " can't load url "+url);
                            return true;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(imageView);
        }else {
            Log.d("Error ImageLoader ", " No Internet Connection");
        }

    }

    public static void loadWithErrorDrawable(Context context, String url, int errorDrawable, ImageView imageView) {
        if (NetworkUtils.isNetworkConnected(context)){
            Glide.with(context)
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e("Error ImageLoader ", " can't load url"+url);
                            return true;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .apply(new RequestOptions().error(errorDrawable))
                    .into(imageView);
        }else {
            Log.d("Error ImageLoader ", " No Internet Connection");
        }

    }

    public static void loadWithCache(Context context, String url, ImageView imageView) {
        if (NetworkUtils.isNetworkConnected(context)){
            Glide.with(context)
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e("Error ImageLoader", " can't load url "+url);
                            return true;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                    .into(imageView);
        }else {
            Log.d("Error ", " No Internet Connection");
        }

    }

    public static void loadWithCache(Context context, String url, int errorDrawable, ImageView imageView) {
        if (NetworkUtils.isNetworkConnected(context)){
            Glide.with(context)
                    .load(url)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e("Error ImageLoader", " can't load url "+url);
                            return true;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .apply(new RequestOptions().error(errorDrawable))
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                    .into(imageView);
        }else {
            Log.d("Error ImageLoader ", " No Internet Connection");
        }

    }
}
