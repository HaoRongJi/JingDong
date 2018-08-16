package com.bwie.JingDong.fragment;


import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.bwie.JingDong.R;
import com.bwie.JingDong.adapter.TestHomeAdapter;
import com.bwie.JingDong.base.BaseFragment;
import com.bwie.JingDong.bean.TestBean;
import com.bwie.JingDong.utils.OKHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends BaseFragment {
    @Override
    public void initView(View mView) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first;
    }


    /*private LinearLayout mToolbar;
    private RecyclerView mRecyclerView;
    private List<TestBean> data;
    private int height;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    public void initView(View mView) {
        //mToolbar = mView.findViewById(R.id.toolbar);
        mRecyclerView = mView.findViewById(R.id.app_home_list);
    }

    *//**
     * 懒加载方法
     *//*
    @Override
    public void lazyLoad() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 6);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        String jsonData = OKHttpUtils.getInstance().postData();

        data = new Gson().fromJson(jsonData, new TypeToken<List<TestBean>>() {
        }.getType());
        TestHomeAdapter adapter = new TestHomeAdapter(data);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int type = data.get(position).getType();
                if (type == 1 || type == 3 || type == 2 || type == 5 || type == 6) {
                    return 6;
                } else if (type == 4) {
                    return 2;
                } else if (type == 7) {
                    return 3;
                }
                return 0;
            }
        });
        mRecyclerView.setAdapter(adapter);
        //adapter.setHeaderView(getHeaderView(mRecyclerView));
        adapter.setNewData(data);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy <= height) {
                    float alpha = (float) totalDy / height;
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getContext(), R.color.white), alpha));
                } else {
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getContext(), R.color.white), 1));
                }
            }
        });
    }*/



    /**
     * 轮播图banner的数据设置
     */

}
