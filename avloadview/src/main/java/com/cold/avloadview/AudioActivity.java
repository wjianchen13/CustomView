package com.cold.avloadview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.cold.avloadview.widget.AVLoadingIndicatorView;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public class AudioActivity extends AppCompatActivity{

    private AVLoadingIndicatorView avi;
    private LinearLayout llytTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        String indicator=getIntent().getStringExtra("indicator");
        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator(indicator);

//        String indicator = "LineScaleIndicator";
//        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
//        avi.setIndicator(indicator);
//        llytTest = (LinearLayout)findViewById(R.id.llyt_test);
//        llytTest.setOnClickListener(null);
    }

    public void hideClick(View view) {
        avi.hide();
        // or avi.smoothToHide();
    }

    public void showClick(View view) {
        avi.show();
        // or avi.smoothToShow();
    }
}
