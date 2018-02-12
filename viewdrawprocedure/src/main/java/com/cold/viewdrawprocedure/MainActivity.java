package com.cold.viewdrawprocedure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CustomViewGroup mFlLayout;
    private String[] names = {"测试1", "测试2", "测试测试2", "测试测试测试2", "测试测试测试测试2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mFlLayout = (CustomViewGroup) findViewById(R.id.fl_layout);
//        mFlLayout.setOrientation(LinearLayout.VERTICAL);
//
//        for (int i = 0; i < 5; i++){
//            TextView text = new TextView(this);
////            text.setBackgroundColor(Color.RED);
//            text.setText(names[i]);
//            mFlLayout.addView(text);
//        }
    }
}
