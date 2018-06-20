package com.cold.praise;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/17.
 */

public class PraiseLayout extends FrameLayout{

    private Context mContext;
    private Drawable mDrawable;
    private int mWidth;
    private int mHeight;

    private MotionEvent mLastDownEvent;
    private boolean doubleClick;
    private int duration = 1000;

    public PraiseLayout(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public PraiseLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context);
    }

    public PraiseLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * init
     * @param
     * @return
     */
    private void init(Context context) {
        mDrawable = ContextCompat.getDrawable(context, R.drawable.ic_praise);
//        ImageView image_heard = new ImageView(context);
//        image_heard.setImageDrawable(mDrawable);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        image_heard.setLayoutParams(layoutParams);
//        ImageViewInfo tag = new ImageViewInfo();
//        tag.setDefault = true;
//        image_heard.setTag(tag);
//        addView(image_heard);
    }


    /**
     * double click
     * @param
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mLastDownEvent != null && isDoubleTap(mLastDownEvent, event)) {
                    doubleClick = true;
                    Toast.makeText(mContext, "double click", Toast.LENGTH_SHORT).show();
                    onDouble(event);
                }
                if(doubleClick) {
                    doubleClick = false;
                    mLastDownEvent = null;
                } else {
                    mLastDownEvent = MotionEvent.obtain(event);
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * 判断是否是双击
     * @param
     * @return
     */
    private boolean isDoubleTap(MotionEvent lastEvent, MotionEvent currentEvent) {
        if (currentEvent.getEventTime() - lastEvent.getEventTime() > 500) {
            return false;
        }

        int deltaX = (int) lastEvent.getX() - (int) currentEvent.getX();
        int deltaY = (int) lastEvent.getY() - (int) currentEvent.getY();
        return deltaX * deltaX + deltaY * deltaY < 10000;
    }

    /**
     * 双击处理
     * @param
     * @return
     */
    private void onDouble(MotionEvent event) {
        Toast.makeText(mContext, "double click", Toast.LENGTH_SHORT).show();
        ImageView image_heard = new ImageView(mContext);
        image_heard.setImageDrawable(mDrawable);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        image_heard.setLayoutParams(layoutParams);
        ImageViewInfo tag = new ImageViewInfo();
        tag.pt.x = (int)event.getX();
        tag.pt.y = (int)event.getY();
        image_heard.setTag(tag);
        addView(image_heard);
        startAnimation(image_heard);
    }

    @TargetApi(21)
    public void startAnimation(final View view) {
        // 平移动画
//        ObjectAnimator translation = ObjectAnimator.ofFloat(view, "translationY", 0, -500).setDuration(duration);
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, view.X, view.Y,
                getPath(((ImageViewInfo)view.getTag()).pt.x, ((ImageViewInfo)view.getTag()).pt.y)).setDuration(duration);
        // 放大
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.3f, 1f).setDuration(duration / 5);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.3f, 1f).setDuration(duration / 5);
        // 透明度动画
        ObjectAnimator alpha1 = ObjectAnimator.ofFloat(view, "alpha", 0.2f, 1f).setDuration(duration / 5);
        ObjectAnimator alpha2 = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f).setDuration(duration / 5);
        alpha2.setStartDelay(duration / 5 * 3);

        // 步骤2：创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();

        // 步骤3：根据需求组合动画
        animSet.play(translation).with(scaleX).with(scaleY).with(alpha1);
        animSet.play(alpha2).after(alpha1);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(getContext(), "end animation", Toast.LENGTH_SHORT).show();
                if(view != null) {
                    removeView(view);
                }
            }
        });
        // 步骤4：启动动画
        animSet.start();
    }

    /**
     * 圆弧动画
     * @return
     */
    private Path getPath(int vx, int vy) {
        Path  path = new Path();
        int x = vx- 146;
        int y = vy - 138;
        path.moveTo(x, y);
        path.cubicTo(x - 150, y - 150, x + 150, y - 300, x, y - 450);
        return path;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //获取view的宽高测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //保存测量高度
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int childW = child.getMeasuredWidth();
            int childH = child.getMeasuredHeight();
            if(child.getTag() != null && child.getTag() instanceof ImageViewInfo) {
                ImageViewInfo info = (ImageViewInfo)child.getTag();
                if(info.setDefault) {
                    child.layout((mWidth - childW) / 2, (mHeight - childH) - 150, (mWidth - childW) / 2 + childW, mHeight - 150);
                } else {
                    child.layout(info.pt.x - childW / 2, info.pt.y - childH / 2, info.pt.x + childW / 2, info.pt.y + childH / 2);
                }
            } else {
                child.layout((mWidth - childW) / 2, (mHeight - childH) - 150, (mWidth - childW) / 2 + childW, mHeight - 150);
            }
        }
    }

    class ImageViewInfo {
        public boolean setDefault;
        public Point pt = new Point();
    }

}

