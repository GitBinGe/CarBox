package com.bg.carbox.Functions;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bg.carbox.ContentPagerAdapter;
import com.bg.carbox.ContentViewPager;
import com.bg.carbox.R;
import com.bg.carbox.Views.PointsView;
import com.bg.library.UI.Activity.PresenterActivity;
import com.bg.library.Utils.Log.LogUtils;

public class FunctionActivity extends PresenterActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_page);
        int id = getIntent().getIntExtra("id", 0);
        ImageView iv = (ImageView) findViewById(R.id.bg);
        iv.setImageResource(id);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
        }
    }

}
