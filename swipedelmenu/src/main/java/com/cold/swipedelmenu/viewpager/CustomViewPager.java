package com.cold.swipedelmenu.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/6/1.
 */

public class CustomViewPager extends ViewPager {
//    private boolean enabled = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // 触摸事件不触发
//        if (this.enabled) {
//            return super.onTouchEvent(event);
//        }
//        return false;
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        // 不处理触摸拦截事件
//        if (this.enabled) {
//            return super.onInterceptTouchEvent(event);
//        }
//        return false;
//    }
//
//    @Override
//    public boolean canScrollHorizontally(int direction) {
//        return super.canScrollHorizontally(direction);
//    }

//    @Override
//    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
//        return true;
////        return super.canScroll(v, checkV, dx, x, y);
//    }

//    public void setPagingEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
}