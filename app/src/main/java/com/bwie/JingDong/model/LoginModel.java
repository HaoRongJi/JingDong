package com.bwie.JingDong.model;

import android.os.Handler;

import com.bwie.JingDong.bean.LoginBean;
import com.bwie.JingDong.common.Api;
import com.bwie.JingDong.utils.OKHttpUtils;
import com.bwie.JingDong.view.RequestCallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class LoginModel {

    Handler handler = new Handler();

    public void login(HashMap<String, String> hashMap, final LoginCallBack loginCallBack) {

        OKHttpUtils.getInstance().postData(Api.LOGIN_URL, hashMap, new RequestCallBack() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code()==200){

                    String result=null;

                    try {
                        result=response.body().string();

                        parseJsonResult(result,loginCallBack);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                if (loginCallBack!=null){

                    loginCallBack.failure("登录失败");

                }
            }
        });


    }

    private void parseJsonResult(String result, final LoginCallBack loginCallBack) {

        if (result!=null){

            final LoginBean loginBean=new Gson().fromJson(result,LoginBean.class);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (loginCallBack!=null){

                        loginCallBack.success(loginBean);

                    }
                }
            });

        }

    }

    public interface LoginCallBack{

        void success(LoginBean loginBean);
        void failure(String errorMsg);

    }

}
