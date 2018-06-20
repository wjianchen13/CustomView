package com.cold.praise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PraiseBtnActivity extends AppCompatActivity {

    private PraiseBtnLayout praiseBtnLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praise_btn);
        praiseBtnLayout = (PraiseBtnLayout)findViewById(R.id.imgv_btn);
    }

    /**
     * 启动动画
     * @param
     * @return
     */
    public void onAnimation(View v) {
        praiseBtnLayout.startAnimation();
    }
}
