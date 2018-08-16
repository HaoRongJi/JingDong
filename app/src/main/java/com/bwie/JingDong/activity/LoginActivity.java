package com.bwie.JingDong.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.JingDong.R;
import com.bwie.JingDong.base.BaseActivity;

import com.bwie.JingDong.bean.LoginBean;
import com.bwie.JingDong.presenter.LoginPresenter;
import com.bwie.JingDong.view.ILoginView;

public class LoginActivity extends BaseActivity implements ILoginView {


    private View backImg;
    private EditText usernameEt;
    private EditText passwordEt;
    private View loginBtn;
    private LoginPresenter presenter;

    @Override
    protected void initData() {

        presenter=new LoginPresenter(this);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(usernameEt.getText().toString(),passwordEt.getText().toString());
            }
        });


    }

    @Override
    protected void ininView() {
        backImg = findViewById(R.id.back_img);
        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    /*public void toRegisiter(View view) {
        startActivity(new Intent(this,RegisiterActivity.class));
    }*/

    @Override
    public void mobileEmpty() {
        Toast.makeText(this,"手机号不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mobileForm() {
        Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdEmpty() {
        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdForm() {
        Toast.makeText(this, "密码长度必须大于6位", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public void failure(String errorMsg) {
        Toast.makeText(this,"登录失败，请重试",Toast.LENGTH_SHORT).show();
    }

}
