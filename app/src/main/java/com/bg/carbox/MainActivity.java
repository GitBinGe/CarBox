package com.bg.carbox;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.bg.library.UI.Activity.PresenterActivity;

public class MainActivity extends PresenterActivity implements View.OnClickListener{

    private ContentViewPager mContentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.conditions).setOnClickListener(this);
        findViewById(R.id.control).setOnClickListener(this);
        findViewById(R.id.have).setOnClickListener(this);
        findViewById(R.id.ev).setOnClickListener(this);
        findViewById(R.id.suspension).setOnClickListener(this);
        findViewById(R.id.settings).setOnClickListener(this);

        mContentPager = (ContentViewPager) findViewById(R.id.content_viewpager);
        mContentPager.setAdapter(new ContentPagerAdapter());
        mContentPager.setScanScroll(false);

        selected(findViewById(R.id.conditions));
    }

    @Override
    public void onClick(View view) {
        selected(view);
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
