package com.bwie.JingDong.activity;

import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bwie.JingDong.R;
import com.bwie.JingDong.base.BaseActivity;
import com.bwie.JingDong.fragment.FirstFragment;
import com.bwie.JingDong.fragment.FivthFragment;
import com.bwie.JingDong.fragment.FourthFragment;
import com.bwie.JingDong.fragment.SecondFragment;
import com.bwie.JingDong.fragment.ThirdFragment;

public class FirstActivity extends BaseActivity {


    private FrameLayout frameLayout;
    private RadioGroup radioGroup;

    @Override
    protected void initData() {



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.rab1_btn:
                        setReplaceFragment(new FirstFragment());
                        break;

                    case R.id.rab2_btn:
                        setReplaceFragment(new SecondFragment());
                        break;

                    case R.id.rab3_btn:
                        setReplaceFragment(new ThirdFragment());
                        break;

                    case R.id.rab4_btn:
                        setReplaceFragment(new FourthFragment());
                        break;

                    case R.id.rab5_btn:
                        setReplaceFragment(new FivthFragment());
                        break;

                }
            }

        });

        radioGroup.check(R.id.rab1_btn);

    }

    @Override
    protected void ininView () {
        frameLayout = findViewById(R.id.frame_layout);
        radioGroup = findViewById(R.id.radio_group);
    }

    @Override
    protected int initLayout () {
        return R.layout.activity_first;
    }

    private void setReplaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

}

