package com.cold.avloadview.widget.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.cold.avloadview.widget.Indicator;

import java.util.ArrayList;

/**
 * Created by Jack on 2015/10/19.
 */
public class AudioScaleIndicator extends Indicator {

    public static final float SCALE = 1.0f;

    float[] scaleYFloats = new float[]{SCALE,
            SCALE,
            SCALE};

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float translateX = getWidth() / 7;
        float translateY = getHeight();
        for (int i = 0; i < 3; i ++) {
            canvas.save();
            canvas.translate((2 + i * 2) * translateX - translateX / 2, translateY);
            canvas.scale(SCALE, scaleYFloats[i]);
            RectF rectF = new RectF(-translateX / 2, -getHeight() / 1.2f, translateX / 2, getHeight() / 1.2f);
            canvas.drawRoundRect(rectF, 5, 5, paint);
            canvas.restore();
        }
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators= new ArrayList<>();
        long[] delays = new long[]{100, 200, 300};
        for (int i = 0; i < 3; i++) {
            final int index = i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(1, 0.1f, 1);
            scaleAnim.setDuration(600);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);
            addUpdateListener(scaleAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleYFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            animators.add(scaleAnim);
        }
        return animators;
    }

}