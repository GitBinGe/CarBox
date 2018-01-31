package com.bg.carbox.TabViews;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bg.carbox.R;
import com.bg.carbox.TabViews.BaseView.PointPageView;

/**
 * Created by BinGe on 2018/1/31.
 */

public class ConditionsView extends PointPageView {


    public ConditionsView(@NonNull Context context) {
        super(context);
        setPages(new int[]{R.mipmap.carbox_conditions_page1, R.mipmap.carbox_conditions_page2});
    }


}
