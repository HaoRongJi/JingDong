package com.bwie.JingDong.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OKHttpUtils {


    private static OKHttpUtils okHttpUtils = new OKHttpUtils();
    private OkHttpClient okHttpClient;

    public static OKHttpUtils getInstance() {

        if (okHttpUtils==null){

            synchronized (OKHttpUtils.class){

                if (okHttpUtils==null){

                    okHttpUtils=new OKHttpUtils();

                }

            }

        }

        return okHttpUtils;

    }

    //构造方法私有，不能被调用者调用，仅供自己使用
    private OKHttpUtils() {
        okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public void getData(String url, HashMap<String,String> hashMap, final RequestCallBack requestCallBack){

        StringBuilder builder=new StringBuilder();
        String allUrl="";

        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            builder.append("?").append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue()).append("&");
        }

        allUrl=url+builder.toString().substring(0,builder.length()-1);

        Request request=new Request.Builder()
                .url(allUrl)
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败
                if (requestCallBack!=null){

                    requestCallBack.failure(call,e);

                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功
                if (requestCallBack!=null){

                    requestCallBack.onResponse(call,response);

                }

            }
        });

    }

    public void postData(String url, HashMap<String,String> hashMap, final RequestCallBack requestCallBack){

        FormBody.Builder formBody=new FormBody.Builder();

        if (hashMap!=null&&hashMap.size()>0){

            for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
                formBody.add(stringStringEntry.getKey(),stringStringEntry.getValue());
            }

        }

        //构造Request

        Request request=new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();


        //创建异步请求

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (requestCallBack!=null){

                    requestCallBack.failure(call, e);

                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (requestCallBack!=null){

                    requestCallBack.onResponse(call, response);

                }
            }
        });

    }

}
