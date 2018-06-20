package com.cold.startview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class StartView extends RelativeLayout {
    protected Random random;
    protected PointF pointFStart, pointFEnd, pointFFirst, pointFSecond;
    private int mStartNum;
    private boolean isCancelAnim;
    private long mDuration = 2000;
    private List<ValueAnimator> mAnimatorList = new ArrayList<>();
    private Runnable mRun;

    public StartView(Context context) {
        super(context);
        initView();
    }

    public StartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public StartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        pointFStart = new PointF();
        pointFFirst = new PointF();
        pointFSecond = new PointF();
        pointFEnd = new PointF();

        random = new Random();
    }

    //添加星星
    public void addStart() {
        ImageView imageView = new ImageView(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setImageResource(R.drawable.yellow_start);
        float scale = random.nextFloat();
        if (scale >= 0.5f) {
            scale = 0.5f;
        } else if (scale <= 0.25f) {
            scale = 0.25f;
        }
        imageView.setScaleX(scale);
        imageView.setScaleY(scale);

        float alpha = random.nextFloat();
        if (alpha <= 0.2f) {
            alpha = 0.2f;
        }
        imageView.setAlpha(alpha);

        params.addRule(CENTER_VERTICAL);
        addView(imageView, params);
        moveStart(imageView);
    }

    //星星动画
    private void moveStart(final ImageView view) {
        PointF pointFFirst = this.pointFFirst;
        PointF pointFSecond = this.pointFSecond;
        PointF pointFStart = this.pointFStart;
        PointF pointFEnd = this.pointFEnd;

        ValueAnimator animator = ValueAnimator.ofObject(new BezierEvaluator(pointFFirst, pointFSecond), pointFStart, pointFEnd);
        mAnimatorList.add(animator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (isCancelAnim) {
                    return;
                }
                PointF value = (PointF) animation.getAnimatedValue();
                view.setX(value.x);
                view.setY(value.y);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                StartView.this.removeView(view);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                StartView.this.removeView(view);
            }
        });
        animator.setDuration(mDuration);
        animator.start();
    }

    //星星个数
    public void setStartNum(int startNum) {
        mStartNum = startNum;
    }

    //动画时间
    public void setDuration(long duration) {
        mDuration = duration;
    }

    public void startAnim() {
        isCancelAnim = false;
        startSlide();
    }

    //
    private void startSlide() {
        if (!isCancelAnim && mStartNum > 0) {
            mStartNum--;
            pointFStart = new PointF();
            pointFFirst = new PointF();
            pointFSecond = new PointF();
            pointFEnd = new PointF();

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yellow_start);
            //星星起始坐标
            pointFStart.x = 0;
            pointFStart.y = getMeasuredHeight() / 2 - bitmap.getHeight() / 2;
            //星星结束坐标
            pointFEnd.x = getMeasuredWidth();
            int type = random.nextInt(6);
            switch (type) {
                case 0://上
                case 1:
                    pointFFirst.x = random.nextFloat() * getMeasuredHeight() / 2;
                    pointFFirst.y = -random.nextFloat() * getMeasuredHeight() - getMeasuredHeight() / 2;
                    pointFSecond.x = random.nextFloat() * getMeasuredHeight() / 2 + getMeasuredHeight() / 2;
                    pointFSecond.y = random.nextFloat() * getMeasuredHeight() + getMeasuredHeight();
                    pointFEnd.y = random.nextFloat() * getMeasuredHeight();
                    break;
                case 2://中
                case 3:
                    pointFFirst.x = random.nextFloat() * getMeasuredHeight();
                    pointFFirst.y = random.nextFloat() * getMeasuredHeight();
                    pointFSecond.x = random.nextFloat() * getMeasuredHeight();
                    pointFSecond.y = -random.nextFloat() * getMeasuredHeight();
                    pointFEnd.y = random.nextFloat() * getMeasuredHeight();
                    break;
                case 4:
                case 5://下
                    pointFFirst.x = random.nextFloat() * getMeasuredHeight() / 2;
                    pointFFirst.y = random.nextFloat() * getMeasuredHeight() + getMeasuredHeight();
                    pointFSecond.x = random.nextFloat() * getMeasuredHeight() / 2 + getMeasuredHeight() / 2;
                    pointFSecond.y = -random.nextFloat() * getMeasuredHeight() - getMeasuredHeight() / 2;
                    pointFEnd.y = random.nextFloat() * getMeasuredHeight();
                    break;
                default:

                    break;
            }
            addStart();
            postDelayed(mRun = new Runnable() {
                @Override
                public void run() {
                    startSlide();
                }
            }, 80);
        }
    }

    public void cancelAnim() {
        isCancelAnim = true;
        mStartNum = 0;
        if (mAnimatorList != null && mAnimatorList.size() > 0) {
            for (int i = 0; i < mAnimatorList.size(); i++) {
                if (mAnimatorList.get(i) != null) {
                    mAnimatorList.get(i).cancel();
                }
            }
            mAnimatorList.clear();
        }
        removeAllViews();
        removeCallbacks(mRun);
        mRun = null;
    }
}
