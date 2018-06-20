
package com.cold.swipedelmenu.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cold.swipedelmenu.R;
import com.cold.swipedelmenu.bean.SwipeBean;
import com.cold.swipedelmenu.refresh.RefreshAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    private SmartRefreshLayout mSmartRefreshLayout;
    private RecyclerView mSmartRecyclerview;
    private List<SwipeBean> mDatas;
    protected View view;

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatas = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSmartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smart_refreshlayout);
        mSmartRefreshLayout.setEnableLoadmore(true);
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {

            }
        });
        initDatas();
        mSmartRecyclerview = (RecyclerView) view.findViewById(R.id.smart_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSmartRecyclerview.setLayoutManager(layoutManager);
        adapter = new RefreshAdapter(R.layout.item_message_main, mDatas);
        mSmartRecyclerview.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_refresh, null);
        return view;
    }

    private RefreshAdapter adapter;

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            mDatas.add(new SwipeBean("" + i));
        }
    }
}
