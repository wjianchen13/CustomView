package com.cold.audioview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.cold.audioview.R;

import java.util.Random;

/**
 * name: AudioView
 * desc: 音频条形图
 * author:
 * date: 2018-04-23 15:00
 * remark:
 */
public class AudioView extends View {

    private int random;
    private boolean isStart = true;
    private Random mRandom;

    private int mRect_t1;
    private int mRect_t2;
    private int mRect_t3;

    /**
     * 条形高度
     */
    private int mLinearWidth;

    /**
     * 条形间距
     */
    private int mLinearMargin;

    /**
     * 缩进
     */
    private int mPadding;

    private AudioHandler mHandler;
    private Paint mPaint;
    private int mHeight;
    private RectF r1;
    private RectF r2;
    private RectF r3;

    private class AudioHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x1234) {
                mRect_t1 = mRandom.nextInt(random);
                mRect_t2 = mRandom.nextInt(random);
                mRect_t3 = mRandom.nextInt(random);
                invalidate();
            }
        }
    }

    public AudioView(Context context) {
        this(context, null);
    }

    public AudioView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AudioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mHandler = new AudioHandler();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }

    /**
     * init state
     * @param
     * @return
     */
    private void init(Context context, AttributeSet attrs) {
        mRandom = new Random();
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        r1 = new RectF();
        r2 = new RectF();
        r3 = new RectF();
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AudioView, 0, 0);
        mLinearWidth = ta.getDimensionPixelSize(R.styleable.AudioView_linear_width, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources()
                        .getDisplayMetrics()));
        mLinearMargin = ta.getDimensionPixelSize(R.styleable.AudioView_linear_margin, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources()
                        .getDisplayMetrics()));
        mPadding = ta.getDimensionPixelSize(R.styleable.AudioView_linear_padding, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources()
                        .getDisplayMetrics()));
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        random = mHeight / 5;
    }

    public void start(){
        isStart = true;
        invalidate();
    }

    public void stop(){
        isStart = false;
        invalidate();
    }

    public boolean  isStart(){
        return isStart;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画柱状；动态图，就要改变柱状的top值
        r1.set((float)mPadding, mRect_t1 * 5, (float)(mPadding + mLinearWidth), (float)mHeight);
        r2.set((float)(mPadding + mLinearWidth + mLinearMargin), mRect_t2 * 5, (float)(mPadding + mLinearWidth + mLinearMargin + mLinearWidth), (float)mHeight);
        r3.set((float)(mPadding + mLinearWidth * 2 + mLinearMargin * 2), mRect_t3 * 5, (float)(mPadding + mLinearWidth * 3 + mLinearMargin * 2), (float)mHeight);
        canvas.drawRect(r1, mPaint);
        canvas.drawRect(r2, mPaint);
        canvas.drawRect(r3, mPaint);
        if (isStart) {
            mHandler.sendEmptyMessageDelayed(0x1234, 300);
        }
    }
}
