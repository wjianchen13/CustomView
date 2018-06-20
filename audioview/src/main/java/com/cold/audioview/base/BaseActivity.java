package com.cold.audioview.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cold.audioview.R;
import com.cold.audioview.widget.AudioView;

public class BaseActivity extends AppCompatActivity {

    private AudioView audioView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        audioView = (AudioView) findViewById(R.id.av_test);
    }

    /**
     * 开始动画
     * @param
     * @return
     */
    public void onStart(View v) {
//        if (!audioView.isStart()) {
            //开始跳动
            audioView.start();
//        }
//        audioView.setVisibility(View.VISIBLE);
    }

    /**
     * 停止动画
     * @param
     * @return
     */
    public void onEnd(View v) {
//        if (audioView.isStart()) {
//            //结束跳动
//            audioView.stop();
//        }
        if(audioView.getVisibility() == View.VISIBLE) {
            audioView.setVisibility(View.GONE);
        } else if(audioView.getVisibility() == View.GONE) {
            audioView.setVisibility(View.VISIBLE);
        }

    }
}
