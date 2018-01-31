package com.bg.carbox;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bg.carbox.TabViews.ConditionsView;
import com.bg.carbox.TabViews.ControlView;
import com.bg.carbox.TabViews.EvView;
import com.bg.carbox.TabViews.HaveView;
import com.bg.carbox.TabViews.SettingsView;
import com.bg.carbox.TabViews.SuspensionView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by BinGe on 2018/1/31.
 */

public class ContentPagerAdapter extends PagerAdapter {

    private Class[] ViewClass = new Class[] {
            ConditionsView.class,
            ControlView.class,
            HaveView.class,
            EvView.class,
            SuspensionView.class,
            SettingsView.class,
    };

    private View[] views = new View[ViewClass.length];

    @Override
    public int getCount() {
        return views.length;
    }

    public View getPage(int position) {
        return views[position];
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views[position];
        if (view == null) {
            Class cls = ViewClass[position];
            try {
                Constructor constructor =  cls.getConstructor(Context.class);
                view = (View) constructor.newInstance(container.getContext());
                views[position] = view;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views[position]);
    }
}
