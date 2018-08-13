package com.bwie.JingDong.bean;

import java.util.List;

public class ProductBean {

    public String msg;
    public String code;
    public List<ProductBean.Product> data;

    public  class  Product{

        String title;
        String image;

    }
}
