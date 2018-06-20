package com.cold.startview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private StartView mStartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartView = (StartView) findViewById(R.id.startview);
        //贝塞尔曲线星星
        mStartView.setStartNum(65);
        mStartView.setDuration(3000);

        mStartView.startAnim();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStartView.cancelAnim();
    }
}
