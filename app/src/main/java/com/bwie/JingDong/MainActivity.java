package com.bwie.JingDong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bwie.JingDong.base.BaseActivity;

public class MainActivity extends BaseActivity implements Animation.AnimationListener {


    private ImageView firstImg;

    @Override
    protected void initData() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setAnimationListener(this);
        firstImg.startAnimation(alphaAnimation);
    }

    @Override
    protected void ininView() {
        firstImg=findViewById(R.id.first_img);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        toMain();
    }

    private void toMain() {
        startActivity(new Intent(MainActivity.this,FirstActivity.class));
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
