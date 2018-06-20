package com.cold.swipedelmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cold.swipedelmenu.recyclerview.RecyclerViewActivity;
import com.cold.swipedelmenu.refresh.RefreshActivity;
import com.cold.swipedelmenu.viewpager.ViewpagerActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = (TextView)findViewById(R.id.tv_test);
    }

    /**
     * Recyclerview
     * @param
     * @return
     */
    public void onRecyclerView(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, RecyclerViewActivity.class);
        startActivity(it);
    }

    /**
     * Refresh
     * @param
     * @return
     */
    public void onRefresh(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, RefreshActivity.class);
        startActivity(it);
    }

    /**
     * Viewpager
     * @param
     * @return
     */
    public void onViewpager(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, ViewpagerActivity.class);
        startActivity(it);
//        tvTest.setText(Html.fromHtml("你已成功加入帮会 <font color=\"#D6B118\">test111</font>"));
////                "<font face=\"verdana\" color=\"green\">This is some text!</font>"));
    }
}
