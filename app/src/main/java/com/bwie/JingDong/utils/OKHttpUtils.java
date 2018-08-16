package com.bwie.JingDong.utils;


import com.bwie.JingDong.view.RequestCallBack;

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

    private OkHttpClient okHttpClient;

    private static  OKHttpUtils okHttpUtils;

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

    private OKHttpUtils() {

        okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();

    }

    public void postData(String url, HashMap<String,String> hashMap, final RequestCallBack requestCallBack){

        FormBody.Builder formbody=new FormBody.Builder();

        if (hashMap!=null){

            for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
                formbody.add(stringStringEntry.getKey(),stringStringEntry.getValue());
            }

        }

        Request request=new Request.Builder()
                .url(url)
                .post(formbody.build())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (requestCallBack!=null){

                    requestCallBack.onFailure(call, e);

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
