package com.biekaeksa.mlearning_materi_pembelajaran.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader {
    public static class Builder {
        private String url;
        private Drawable errorDrawable;
        private Context context;
        private Fragment fragment;
        private Activity activity;
        private View view;
        private ImageView imageView;
        private boolean cache = false;

        public Builder() {
        }

        public Builder(String url, Drawable errorDrawable, Context context, Fragment fragment, Activity activity, View view, ImageView imageView) {
            this.url = url;
            this.errorDrawable = errorDrawable;
            this.context = context;
            this.fragment = fragment;
            this.activity = activity;
            this.view = view;
            this.imageView = imageView;
        }

        public Builder with(View view) {
            this.view = view;
            return this;
        }

        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public Builder with(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Builder with(Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder cache(boolean cache) {
            this.cache = cache;
            return this;
        }

        public Builder error(Drawable errorDrawable) {
            this.errorDrawable = errorDrawable;
            return this;
        }

        public Builder to(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public void apply() {
            if (this.view != null || this.activity != null || this.context != null || this.fragment != null) {
                if (this.view != null) {
                    loadImage(this.view);
                } else if (this.activity != null) {
                    loadImage(this.activity);
                }else if (this.fragment != null){
                    loadImage(this.fragment);
                }else {
                    loadImage(this.context);
                }
            }
        }

        private void loadImage(Context context) {
            if (this.imageView != null && this.cache && this.errorDrawable != null) {
                Glide.with(context)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.cache ) {
                Glide.with(context)
                        .load(this.url)
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.errorDrawable != null) {
                Glide.with(context)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .into(this.imageView);
            } else {
                Glide.with(context)
                        .load(this.url)
                        .into(this.imageView);
            }
        }

        private void loadImage(Activity activity) {
            if (this.imageView != null && this.cache && this.errorDrawable != null) {
                Glide.with(activity)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.cache) {
                Glide.with(activity)
                        .load(this.url)
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.errorDrawable != null) {
                Glide.with(activity)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .into(this.imageView);
            } else {
                Glide.with(activity)
                        .load(this.url)
                        .into(this.imageView);
            }
        }

        private void loadImage(Fragment fragment) {
            if (this.imageView != null && this.cache && this.errorDrawable != null) {
                Glide.with(fragment)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.cache) {
                Glide.with(fragment)
                        .load(this.url)
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.errorDrawable != null) {
                Glide.with(fragment)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .into(this.imageView);
            } else {
                Glide.with(fragment)
                        .load(this.url)
                        .into(this.imageView);
            }
        }

        private void loadImage(View view) {
            if (this.imageView != null && this.cache && this.errorDrawable != null) {
                Glide.with(view)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.cache) {
                Glide.with(view)
                        .load(this.url)
                        .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                        .into(this.imageView);
            } else if (this.imageView != null && this.errorDrawable != null) {
                Glide.with(view)
                        .load(this.url)
                        .apply(new RequestOptions().error(this.errorDrawable))
                        .into(this.imageView);
            } else {
                Glide.with(view)
                        .load(this.url)
                        .into(this.imageView);
            }
        }
    }
}
