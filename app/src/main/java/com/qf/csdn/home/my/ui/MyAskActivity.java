package com.qf.csdn.home.my.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseActivity;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class MyAskActivity extends BaseActivity{
    private FrameLayout askFl;
    private Fragment[] fragments;
    private RadioButton rb1,rb2;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_ask;
    }

    @Override
    protected void initViews() {
        setTitleText("我的问答");
        showIvHome();
        showRgAsk();

        rb2 = (RadioButton) findViewById(R.id.base_titlebar_ask_tichude_rb);
        rb1 = (RadioButton) findViewById(R.id.base_titlebar_ask_tichude_rb);
        askFl = (FrameLayout) findViewById(R.id.my_ask_fl);
        initFragment();


    }

    private void initFragment() {
        fragments = new Fragment[]{new MyAsktcFragment(),new MyAskhdFragment()};
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i = 0; i <fragments.length ; i++) {
            Fragment fragment = fragments[i];
            transaction.add(R.id.my_ask_fl,fragment);
            transaction.hide(fragment);
        }
        transaction.show(fragments[0]);
        transaction.commit();


    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }

}
