package com.qf.csdn.home.my.ui;

import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseActivity;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class HideSetActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_modify_hideset;
    }

    @Override
    protected void initViews() {

        setTitleText("隐私设置");
        setRightText("保存");
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }
}
