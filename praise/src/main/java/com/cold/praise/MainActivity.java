package com.cold.praise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 双击点赞动画
     * @param
     * @return
     */
    public void onDoublePraise(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, PraiseActivity.class);
        startActivity(it);
    }

    /**
     * 点赞按钮动画
     * @param
     * @return
     */
    public void onBtnPraise(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, PraiseBtnActivity.class);
        startActivity(it);
    }
}
