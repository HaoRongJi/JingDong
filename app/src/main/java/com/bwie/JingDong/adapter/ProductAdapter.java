package com.bwie.JingDong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.JingDong.R;
import com.bwie.JingDong.bean.ProductBean;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    public Context context;
    public List<ProductBean.Product> list;

    public ProductAdapter(Context context, List<ProductBean.Product> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 创建viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    /**
     * 绑定viewholder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }




    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
