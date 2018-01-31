package com.bg.carbox.TabViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bg.carbox.R;

/**
 * Created by BinGe on 2018/1/31.
 */

public class HaveView extends FrameLayout {
    public HaveView(@NonNull Context context) {
        super(context);

        ImageView image = new ImageView(context);
        image.setImageResource(R.mipmap.carbox_have_page1);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER | Gravity.BOTTOM);
        addView(image, params);

    }
}
