package com.bg.carbox;

import android.app.Application;

import com.bg.library.Library;

/**
 * Created by BinGe on 2018/1/31.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Library.initialize(this);
    }
}
