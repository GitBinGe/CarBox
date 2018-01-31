package com.bg.carbox.TabViews;

import android.content.Intent;
import android.view.View;

import com.bg.carbox.Functions.FunctionActivity;
import com.bg.carbox.Functions.FunctionPageActivity;
import com.bg.library.Utils.Log.LogUtils;
import com.bg.library.Utils.UI.ActivityUtils;

/**
 * Created by BinGe on 2018/1/31.
 */

public class FunctionButtonClick implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        LogUtils.d("FunctionButtonClick");
        ActivityUtils.presentationActivity(view.getContext(), FunctionPageActivity.class);
    }
}
