package com.bwie.JingDong.adapter;

import android.support.annotation.Nullable;

import com.bwie.JingDong.bean.TestBean;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;

import java.util.List;

public class TestHomeAdapter extends MultipleItemRvAdapter<TestBean, BaseViewHolder> {


    public TestHomeAdapter(@Nullable List<TestBean> data) {
        super(data);
    }

    @Override
    protected int getViewType(TestBean testBean) {
        return 0;
    }

    @Override
    public void registerItemProvider() {

    }
}
