package com.cold.base;

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
     * Recyclerview
     * @param
     * @return
     */
    public void onBase(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, BaseActivity.class);
        startActivity(it);
    }

    /**
     * Refresh
     * @param
     * @return
     */
    public void onLoading(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, LoadingActivity.class);
        startActivity(it);
    }

}
