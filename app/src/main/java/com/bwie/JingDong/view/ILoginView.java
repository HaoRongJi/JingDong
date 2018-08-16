package com.bwie.JingDong.view;

import com.bwie.JingDong.bean.LoginBean;

public interface ILoginView {

    void mobileEmpty();//手机号为空
    void mobileForm();//手机号格式不正确
    void pwdEmpty();//密码为空
    void pwdForm();//密码格式不正确
    void success(LoginBean loginBean);//验证成功
    void failure(String errorMsg);//验证失败

}
