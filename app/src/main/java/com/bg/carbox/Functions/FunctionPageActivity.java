package com.bg.carbox.Functions;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bg.carbox.R;
import com.bg.carbox.Views.PointsView;
import com.bg.library.UI.Activity.PresenterActivity;

public class FunctionPageActivity extends PresenterActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private PointsView mPointsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        findViewById(R.id.close).setOnClickListener(this);

        mViewPager = (ViewPager) findViewById(R.id.function_pager);
        mViewPager.setAdapter(new FunctionPagerAdapter());
        mViewPager.addOnPageChangeListener(this);

        mPointsView = (PointsView) findViewById(R.id.points);
        mPointsView.setCount(mViewPager.getAdapter().getCount());
        mPointsView.setPosition(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int pos = mViewPager.getScrollX() * 100 / (mViewPager.getWidth() * (mViewPager.getAdapter().getCount() - 1));
        mPointsView.setPosition(pos);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
