package com.cold.audioview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cold.audioview.base.BaseActivity;
import com.cold.audioview.drawabletest.DrawableActivity;
import com.cold.audioview.test.TestActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 基础使用
     * @param
     * @return
     */
    public void onBase(View v) {
        Intent it1 = new Intent();
        it1.setClass(MainActivity.this, BaseActivity.class);
        startActivity(it1);
    }

    /**
     * 性能测试
     * @param
     * @return
     */
    public void onTest(View v) {
        Intent it1 = new Intent();
        it1.setClass(MainActivity.this, TestActivity.class);
        startActivity(it1);
    }

    /**
     * drawable性能测试，和上面实现方式不一样
     * @param
     * @return
     */
    public void onBtn(View v) {
        Intent it1 = new Intent();
        it1.setClass(MainActivity.this, DrawableActivity.class);
        startActivity(it1);
    }

}
