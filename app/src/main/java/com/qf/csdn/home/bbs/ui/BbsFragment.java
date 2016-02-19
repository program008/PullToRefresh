package com.qf.csdn.home.bbs.ui;

import android.widget.RadioGroup;

import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseFragment;
import com.qf.csdn.other.ui.HomeActivity;

/**
 * Created by LiuTao008
 * on 2016/1/30.
 */
public class BbsFragment extends BaseFragment {

    private RadioGroup rgBbs;

    @Override
    protected int getLayout() {
        return R.layout.fragment_bbs;
    }

    @Override
    protected void initViews() {
        HomeActivity.showHeadSearch();
        rgBbs = HomeActivity.showBbsHeadRg();
        HomeActivity.hideBlogHeadRg();
        HomeActivity.hideAskHeadRg();
        HomeActivity.hideMyHeadLetter();
        HomeActivity.hideHeadTitle();
        HomeActivity.hideHeadAdd();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }
}
