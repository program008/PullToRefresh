package com.qf.csdn.home.my.ui;

import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseActivity;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class MyDownActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_my_down;
    }

    @Override
    protected void initViews() {
        setTitleText("我的下载");
        showIvSearch();

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }
}
