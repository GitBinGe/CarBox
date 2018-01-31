package com.bg.carbox;

import android.graphics.Color;
import android.net.IpPrefix;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bg.carbox.TabViews.IPoint;
import com.bg.carbox.Views.PointsView;
import com.bg.library.UI.Activity.PresenterActivity;
import com.bg.library.UI.Activity.ThemeActivity;
import com.bg.library.Utils.Log.LogUtils;

public class MainActivity extends PresenterActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private PointsView mPointsView;
    private ContentViewPager mContentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPointsView = (PointsView) findViewById(R.id.points);

        findViewById(R.id.conditions).setOnClickListener(this);
        findViewById(R.id.control).setOnClickListener(this);
        findViewById(R.id.have).setOnClickListener(this);
        findViewById(R.id.ev).setOnClickListener(this);
        findViewById(R.id.suspension).setOnClickListener(this);
        findViewById(R.id.settings).setOnClickListener(this);

        mContentPager = (ContentViewPager) findViewById(R.id.content_viewpager);
        mContentPager.setAdapter(new ContentPagerAdapter());
        mContentPager.addOnPageChangeListener(this);
        mContentPager.setScanScroll(false);

        selected(findViewById(R.id.conditions));
    }

    @Override
    public void onClick(View view) {
        selected(view);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LogUtils.d("onPageScrolled");
        ContentPagerAdapter adapter = (ContentPagerAdapter) mContentPager.getAdapter();
        View page = adapter.getPage(position);
        if (page instanceof IPoint) {
            mPointsView.setVisibility(View.VISIBLE);
            IPoint point = (IPoint)page;
            point.setPointsView(mPointsView);
        } else {
            mPointsView.setVisibility(View.GONE);
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


    private void selected(View view) {
        changeTabStatus(view.getId());

        ViewGroup vg = (ViewGroup) findViewById(R.id.tabs);
        int position = vg.indexOfChild(view);
        mContentPager.setCurrentItem(position, false);


    }

    private void changeTabStatus(int id) {
        ViewGroup vg = (ViewGroup) findViewById(R.id.tabs);
        for (int i = 0; i < vg.getChildCount(); i++) {
            View tab = vg.getChildAt(i);
            if (tab.getId() == id) {
                tab.getBackground().setLevel(1);
            } else {
                tab.getBackground().setLevel(0);
            }
        }
    }



}
