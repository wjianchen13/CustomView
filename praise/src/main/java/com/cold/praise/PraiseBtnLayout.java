package com.cold.praise;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/17.
 */

public class PraiseBtnLayout extends FrameLayout{

    private Context mContext;
    private Drawable mDrawable;
    private Drawable mPraiseDrawable;

    private ImageView imgvNormalState;
    private ImageView imgvPraiseState;

    public PraiseBtnLayout(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public PraiseBtnLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context);
    }

    public PraiseBtnLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * init
     * @param
     * @return
     */
    private void init(Context context) {
        mDrawable = ContextCompat.getDrawable(context, R.drawable.ic_praise_normal);
        mPraiseDrawable = ContextCompat.getDrawable(context, R.drawable.ic_praise_pressed);
        imgvNormalState = new ImageView(context);
        imgvNormalState.setImageDrawable(mDrawable);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        imgvNormalState.setLayoutParams(layoutParams);
        addView(imgvNormalState);
        imgvPraiseState = new ImageView(context);
        imgvPraiseState.setImageDrawable(mPraiseDrawable);
        layoutParams = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        imgvPraiseState.setLayoutParams(layoutParams);
        imgvPraiseState.setScaleX(0);
        imgvPraiseState.setScaleY(0);
        addView(imgvPraiseState);
    }

    /**
     * 启动动画
     * @param
     * @return
     */
    public void startAnimation() {
        imgvPraiseState.setScaleX(0);
        imgvPraiseState.setScaleY(0);
        // 放大
        ObjectAnimator normalScaleX = ObjectAnimator.ofFloat(imgvNormalState, "scaleX", 1f, 0f).setDuration(200);
        ObjectAnimator normalScaleY = ObjectAnimator.ofFloat(imgvNormalState, "scaleY", 1f, 0f).setDuration(200);

        ObjectAnimator praiseScaleX = ObjectAnimator.ofFloat(imgvPraiseState, "scaleX", 0f, 1f).setDuration(200);
        praiseScaleX.setStartDelay(80);
        ObjectAnimator praiseScaleY = ObjectAnimator.ofFloat(imgvPraiseState, "scaleY", 0f, 1f).setDuration(200);
        praiseScaleY.setStartDelay(80);
        // 步骤2：创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();

        // 步骤3：根据需求组合动画
        animSet.play(normalScaleX).with(normalScaleY).with(praiseScaleX).with(praiseScaleY);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(getContext(), "end animation", Toast.LENGTH_SHORT).show();

            }
        });
        // 步骤4：启动动画
        animSet.start();
    }
}

