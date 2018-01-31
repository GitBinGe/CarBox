package com.bg.carbox.Functions;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bg.carbox.R;

/**
 * Created by BinGe on 2018/1/31.
 */

public class FunctionPagerAdapter extends PagerAdapter {

    private int ids[] = new int[]{
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
            R.drawable.selector_function_bcn,
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


        }
        container.addView(view);
        return view;
    }
}
