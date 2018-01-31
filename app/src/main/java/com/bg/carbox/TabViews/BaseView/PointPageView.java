package com.bg.carbox.TabViews.BaseView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bg.carbox.R;
import com.bg.carbox.Views.PointsView;
import com.bg.library.Utils.Log.LogUtils;

/**
 * Created by BinGe on 2018/1/31.
 */

public class PointPageView extends FrameLayout implements  ViewPager.OnPageChangeListener {

    private PointsView mPointsView;

    private int position;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    public PointPageView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.main_page, this);

        mViewPager = new ViewPager(context);
        mAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(this);

        ViewGroup vg = findViewById(R.id.content);
        vg.addView(mViewPager);

    }

    public void setPages(int[] ids) {
        mAdapter.setIds(ids);
        setPointsView((PointsView) findViewById(R.id.points));
    }

    public void setPointsView(PointsView view) {
        mPointsView = view;
        mPointsView.setCount(mViewPager.getAdapter().getCount());
        mPointsView.setPosition(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mPointsView != null) {
            this.position = mViewPager.getScrollX() * 100 / (mViewPager.getWidth() * (mViewPager.getAdapter().getCount() - 1));
            LogUtils.d("position : "+ this.position);
            mPointsView.setPosition(this.position);
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

        private int[] ids = new int[]{};
        private View[] views = new View[ids.length];

        public void setIds(int[] ids) {
            this.ids = ids;
            this.views = new View[ids.length];
            notifyDataSetChanged();
        }

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
                LayoutParams params = new LayoutParams(
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
