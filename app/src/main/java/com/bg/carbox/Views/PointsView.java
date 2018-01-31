package com.bg.carbox.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bg.library.Base.os.SystemInfo;

/**
 * Created by BinGe on 2018/1/31.
 */

public class PointsView extends View {

    private int count = 3;
    private int radius = 25;
    private Paint paint = new Paint();
    private float position = 50f;

    public PointsView(Context context) {
        this(context, null);
    }

    public PointsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setAntiAlias(true);
        count = 3;
        radius = SystemInfo.Screen.dip2px(radius);
    }


    public void setCount(int count) {
        this.count = count;
        requestLayout();
        invalidate();
        setVisibility(count > 0 ? View.VISIBLE : View.GONE);
    }

    /**
     * 0-99
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(radius * count, radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.RED);

        paint.setColor(Color.WHITE & 0x33ffffff);
        for (int i = 0; i < count; i++) {
            float x = radius * i + radius / 2;
            float y = radius / 2;
            canvas.drawCircle(x, y, radius / 4, paint);
        }

        float p = radius * (count - 1) *  position / 100f;
        float x = p + radius / 2;
        float y = radius / 2;
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, radius / 4, paint);

    }
}
