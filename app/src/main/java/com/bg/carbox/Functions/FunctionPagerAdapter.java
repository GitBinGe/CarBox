package com.bg.carbox.Functions;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bg.carbox.R;
import com.bg.library.Utils.Log.LogUtils;

/**
 * Created by BinGe on 2018/1/31.
 */

public class FunctionPagerAdapter extends PagerAdapter implements View.OnClickListener{

    private int ids[] = new int[]{
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_hvac,
            R.drawable.selector_function_gauges,
            R.drawable.selector_function_windows,
            R.drawable.selector_function_switch,
            R.drawable.selector_function_lights,
            R.drawable.selector_function_sensor_inputs,
            R.drawable.selector_function_obd,
            R.drawable.selector_function_fan,
            R.drawable.selector_function_heat,
            R.drawable.selector_function_keyless,
            R.drawable.selector_function_remote,
            R.drawable.selector_function_wheel,
            R.drawable.selector_function_suspension,
            R.drawable.selector_function_ev,
            R.drawable.selector_function_communication,
    };

    private View[] views = new View[ids.length / 10 + 1];

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views[position];
        if (view == null) {
            view = LayoutInflater.from(container.getContext()).inflate(R.layout.function_page, null);
            views[position] = view;

            ViewGroup row1 = view.findViewById(R.id.row1);
            for (int i = 0; i < row1.getChildCount(); i++) {
                ImageView iv = (ImageView) row1.getChildAt(i);
                int pos = position * 10 + i;
                if (pos < ids.length) {
                    iv.setImageResource(ids[pos]);
                    iv.setOnClickListener(this);
                } else {
                    iv.setImageBitmap(null);
                    iv.setOnClickListener(null);
                }
            }
            ViewGroup row2 = view.findViewById(R.id.row2);
            for (int i = 0; i < row2.getChildCount(); i++) {
                ImageView iv = (ImageView) row2.getChildAt(i);
                int pos = position * 10 + i + row1.getChildCount();
                if (pos < ids.length) {
                    iv.setImageResource(ids[pos]);
                    iv.setOnClickListener(this);
                } else {
                    iv.setImageBitmap(null);
                    iv.setOnClickListener(null);
                }
            }

        }
        container.addView(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        LogUtils.d("view click");
    }
}
