package com.bwie.JingDong.presenter;

import android.text.TextUtils;

import com.bwie.JingDong.bean.LoginBean;
import com.bwie.JingDong.model.LoginModel;
import com.bwie.JingDong.utils.RegexValidateUtil;
import com.bwie.JingDong.view.ILoginView;

import java.util.HashMap;

public class LoginPresenter {

    private LoginModel loginModel;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.loginModel = new LoginModel();
        this.iLoginView = iLoginView;
    }

    public void login(String mobile, String pwd) {

        if (TextUtils.isEmpty(mobile)){

            iLoginView.mobileEmpty();
            return;
        }

        if (!RegexValidateUtil.checkCellphone(mobile)){

            iLoginView.mobileForm();
            return;

        }

        if (TextUtils.isEmpty(pwd)){

            iLoginView.pwdEmpty();
            return;
        }

        if (pwd.length()<6){

            iLoginView.pwdForm();
            return;
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile",mobile);
        hashMap.put("password",pwd);

        loginModel.login(hashMap, new LoginModel.LoginCallBack() {
            @Override
            public void success(LoginBean loginbean) {
                iLoginView.success(loginbean);
            }

            @Override
            public void failure(String errorMsg) {
                iLoginView.failure(errorMsg);
            }
        });

    }

}
