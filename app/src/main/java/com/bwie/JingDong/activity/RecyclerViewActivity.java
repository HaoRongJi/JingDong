package com.bwie.JingDong.activity;

import com.bwie.JingDong.R;
import com.bwie.JingDong.adapter.ProductAdapter;
import com.bwie.JingDong.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class RecyclerViewActivity extends BaseActivity {


    private XRecyclerView productXrv;
    private ProductAdapter productAdapter;

    @Override
    protected void initData() {
        /*productAdapter=new ProductAdapter(this,)
        productXrv.setAdapter();*/
    }

    @Override
    protected void ininView() {
        productXrv = findViewById(R.id.product_xrv);


    }

    @Override
    protected int initLayout() {
        return R.layout.activity_recycler_view;

    }
}
