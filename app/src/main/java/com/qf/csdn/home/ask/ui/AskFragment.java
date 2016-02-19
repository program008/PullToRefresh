package com.qf.csdn.home.ask.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseFragment;
import com.qf.csdn.other.ui.HomeActivity;
import com.qf.csdn.other.utils.LogUtil;


/**
 * Created by LiuTao008
 * on 2016/1/30.
 */
public class AskFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ImageView searchIv;
    private RadioGroup radioGroupAsk;
    private Button askBtn;
    private Fragment[] fragments;

    @Override
    protected int getLayout() {
        return R.layout.fragment_ask;
    }

    @Override
    protected void initViews() {
        HomeActivity.hideHeadAdd();
        searchIv = HomeActivity.showHeadSearch();
        radioGroupAsk = HomeActivity.showAskHeadRg();
        HomeActivity.hideBbsHeadRg();
        HomeActivity.hideBlogHeadRg();
        HomeActivity.hideMyHeadLetter();
        HomeActivity.hideHeadTitle();

        askBtn = (Button) root.findViewById(R.id.ask_askbtn);

        //初始化fragment
        initFragment();


    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        fragments = new Fragment[]{ new AskAllFragment(), new AskRewardFragment(), new AskSubscribeToFragment()};
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ask_content_fl, fragments[0]);
        transaction.commit();


    }

    @Override
    protected void initEvents() {
        askBtn.setOnClickListener(this);
        radioGroupAsk.setOnCheckedChangeListener(this);

    }

    @Override
    protected void initData() {

    }

    /**
     * 问答界面的点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ask_askbtn:
                //提问

                break;
            default:
                break;
        }
    }

    /**
     * 问答界面头部radiogroup的点击事件，切换framelayou中的fragment
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        LogUtil.d("rag", checkedId + "---");


        switch (checkedId) {
            case R.id.home_ask_head_rb_all:
                showFrament(true,false,false);
                break;
            case R.id.home_ask_head_rb_xs:
                showFrament(false,true,false);
                break;
            case R.id.home_ask_head_rb_dy:
                showFrament(false,false,true);
                break;
            default:
                break;
        }
    }

    /**
     * 显示或隐藏framelayout中的fragment
     *
     * @param isAll
     * @param isReward
     * @param isSubscribeto
     */
    protected void showFrament(boolean isAll, boolean isReward, boolean isSubscribeto) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (isAll){
            transaction.replace(R.id.ask_content_fl,fragments[0]);
        }

        if (isReward){
            transaction.replace(R.id.ask_content_fl,fragments[1]);
        }
        if(isSubscribeto){
            transaction.replace(R.id.ask_content_fl,fragments[2]);
        }
        transaction.commit();
    }
}
