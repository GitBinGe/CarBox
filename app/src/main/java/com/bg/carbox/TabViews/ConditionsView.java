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
import com.bg.carbox.Views.PointsView;
import com.bg.library.Base.os.SystemInfo;
import com.bg.library.Utils.Log.LogUtils;

/**
 * Created by BinGe on 2018/1/31.
 */

public class ConditionsView extends FrameLayout implements IPoint, ViewPager.OnPageChangeListener {

    private PointsView mPointsView;
    private int position;
    private ViewPager mViewPager;

    public ConditionsView(@NonNull Context context) {
        super(context);

        mViewPager = new ViewPager(context);
        mViewPager.setAdapter(new ViewPagerAdapter());
        mViewPager.addOnPageChangeListener(this);
        addView(mViewPager);

    }

    @Override
    public void setPointsView(PointsView view) {
        mPointsView = view;
        mPointsView.setCount(mViewPager.getAdapter().getCount());
        mPointsView.setPosition(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LogUtils.d("onPageScrolled : " + mViewPager.getScrollX());
        if (mPointsView != null) {
            position = mViewPager.getScrollX() * 100 / mViewPager.getWidth() * (mViewPager.getAdapter().getCount() - 1);
            mPointsView.setPosition(position);
        }
    }

    @Override
    public void onPageSelected(int position) {
        LogUtils.d("onPageSelected");

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        LogUtils.d("onPageScrollStateChanged");
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
//                image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                image.setImageResource(ids[position]);
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
