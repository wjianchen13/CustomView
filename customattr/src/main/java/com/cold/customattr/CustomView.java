package com.cold.customattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/2/5.
 */

public class CustomView extends View {

//    public static final class styleable {
//        public static final int[] Customize = {
//                R.attr.attr_one, R.attr.attr_two, R.attr.attr_three, R.attr.attr_four
//        };
//        public static final int Customize_attr_one = 0;
//        public static final int Customize_attr_two = 1;
//        public static final int Customize_attr_three = 2;
//        public static final int Customize_attr_four = 3;
//    }

    private static final String TAG = CustomView.class.getSimpleName();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.CustomizeStyle);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Customize, defStyle, R.style.DefaultCustomizeStyle);
        String one = a.getString(R.styleable.Customize_attr_one);
        String two = a.getString(R.styleable.Customize_attr_two);
        String three = a.getString(R.styleable.Customize_attr_three);
        String four = a.getString(R.styleable.Customize_attr_four);
        Log.i(TAG, "===========================> one:" + one);
        Log.i(TAG, "===========================> two:" + two);
        Log.i(TAG, "===========================> three:" + three);
        Log.i(TAG, "===========================> four:" + four);
        a.recycle();
    }
    

}
