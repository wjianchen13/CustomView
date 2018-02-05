package com.cold.circlecornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * name: CircleCornerProgressBar
 * desc: 圆形滚动进度条
 * author:
 * date: 2017-10-20 11:30
 * remark: 使用Xfermode设置叠加模式进行绘制
 */
public class CircleCornerProgressBar extends AppCompatImageView {

    /**
     * 当前进度
     */
    private float mProgress;

    /**
     * 画笔
     */
    private Paint mPaint;

    /**
     * 进度圆角半径
     */
    private float mRadius;

    /**
     * 背景颜色
     */
    private int mBgColor;

    /**
     * 进度条颜色
     */
    private int mPgColor;

    /**
     * 进度图层
     */
    private Bitmap progress;

    /**
     * constructor
     * @param
     * @return
     */
    public CircleCornerProgressBar(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    /**
     * 初始化常用画笔，获取属性
     * @param
     * @return
     */
    public CircleCornerProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        mPaint = new Paint();
        //设置抗锯齿效果
        mPaint.setAntiAlias(true);
        //设置画笔颜色
        mPaint.setColor(Color.BLACK);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircliCornerProgressBar,
                0, 0);
        mRadius = ta.getDimensionPixelSize(R.styleable.CircliCornerProgressBar_radius, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources()
                        .getDisplayMetrics()));
        mBgColor = ta.getColor(R.styleable.CircliCornerProgressBar_bgColor, 0xff00ff00);
        mPgColor = ta.getColor(R.styleable.CircliCornerProgressBar_pgColor, 0xff0000ff);
        ta.recycle();
    }

    /**
     * constructor
     * @param
     * @return
     */
    public CircleCornerProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int sc = canvas.saveLayer(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        RectF rectProgressBg = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        mPaint.setColor(mBgColor);
        canvas.drawRoundRect(rectProgressBg, mRadius, mRadius, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        if(progress == null) {
            progress = makeProgress(getMeasuredWidth(), getMeasuredHeight());
        }
        canvas.drawBitmap(progress, -getMeasuredWidth() + mProgress, 0, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }

    /**
     * 设置当前进度
     * @param
     * @return
     */
    public void setmProgress(float progress) {
        if(progress < 0) {
            progress = 0;
        }
        if(progress > 100) {
            progress = 100;
        }
        this.mProgress = progress * getMeasuredWidth() / 100;
        invalidate();
    }

    /**
     * dip转px
     * @param dip
     * @return
     */
    private int dipToPx(int dip){
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }

    /**
     * 创建进度
     * @param
     * @return
     */
    private Bitmap makeProgress(int width, int height) {
        Bitmap bm = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(mPgColor);
        c.drawRoundRect(new RectF(0, 0, width, height), mRadius, mRadius, p);
        return bm;
    }

}
