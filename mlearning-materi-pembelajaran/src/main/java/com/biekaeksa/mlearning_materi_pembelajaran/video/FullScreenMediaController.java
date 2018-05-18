package com.biekaeksa.mlearning_materi_pembelajaran.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;

import com.biekaeksa.mlearning_materi_pembelajaran.R;

public class FullScreenMediaController extends MediaController {
    private ImageView imageFullScreen;
    private String isFullScreen;
    private Context context;

    public FullScreenMediaController(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);

        //image button for full screen to be added to media controller
        imageFullScreen = new ImageView(super.getContext());

        FrameLayout.LayoutParams params=
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL|Gravity.END;
        params.rightMargin = 90;
        params.bottomMargin = 40;
        addView(imageFullScreen, params);

        //fullscreen indicator from intent
        isFullScreen = ((Activity)getContext()).getIntent().getStringExtra("fullscreen");


        if ("y".equals(isFullScreen)){
            imageFullScreen.setImageResource(R.drawable.ic_image_fullscreen_exit);
        }else {
            imageFullScreen.setImageResource(R.drawable.ic_image_fullscreen);
        }

        imageFullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ((Activity)context).getClass());
                if("y".equals(isFullScreen)){
                    intent.putExtra("fullscreen", "n");
                }else {
                    intent.putExtra("fullscreen", "y");
                }
                context.startActivity(intent);
            }
        });
    }


}
