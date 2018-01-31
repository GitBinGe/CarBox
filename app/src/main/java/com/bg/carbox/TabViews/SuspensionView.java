package com.bg.carbox.TabViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bg.carbox.R;

/**
 * Created by BinGe on 2018/1/31.
 */

public class SuspensionView extends FrameLayout {
    public SuspensionView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.main_page, this);

        ImageView image = new ImageView(context);
        image.setImageResource(R.mipmap.carbox_suspensionl_page1);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER | Gravity.BOTTOM);

        ViewGroup vg = findViewById(R.id.content);
        vg.addView(image, params);

        TextView titleView = findViewById(R.id.title);
        titleView.setText("Suspension");
    }
}
