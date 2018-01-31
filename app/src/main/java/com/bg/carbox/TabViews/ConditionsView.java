package com.bg.carbox.TabViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bg.carbox.R;
import com.bg.library.Base.os.SystemInfo;

/**
 * Created by BinGe on 2018/1/31.
 */

public class ConditionsView extends FrameLayout {

    private ViewPager mViewPager;

    public ConditionsView(@NonNull Context context) {
        super(context);
        mViewPager = new ViewPager(context);
        mViewPager.setAdapter(new ViewPagerAdapter());
        addView(mViewPager);
    }

    class ViewPagerAdapter extends PagerAdapter {

        private int[] ids = new int[]{R.mipmap.carbox_conditions_page1, R.mipmap.carbox_conditions_page2};
        private View[] views = new View[ids.length];

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
                FrameLayout root = new FrameLayout(container.getContext());
                ImageView image = new ImageView(container.getContext());
                int padding = SystemInfo.Screen.dip2px(5);
                image.setPadding(padding, padding, padding, padding);
                image.setBackgroundResource(ids[position]);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        Gravity.CENTER | Gravity.BOTTOM);
                root.addView(image, params);
                views[position] = root;
                view = root;
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views[position]);
        }

    }

}
