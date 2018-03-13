package com.cold.viewdrawprocedure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private CustomViewGroup mFlLayout;
    private CustomView cView;
    private Button btnTest;
    private String[] names = {"测试1", "测试2", "测试测试2", "测试测试测试2", "测试测试测试测试2"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cView = (CustomView) findViewById(R.id.cv_test);
        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout.LayoutParams rlytParams = (RelativeLayout.LayoutParams) cView.getLayoutParams();
                if(rlytParams != null) {
                    rlytParams.width = 300;
                    rlytParams.height = 200;
                    cView.setLayoutParams(rlytParams);
                }
            }
        });


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
