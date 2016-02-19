package com.qf.csdn.home.my.ui;

import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseActivity;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class MyHeadlineActivity extends BaseActivity {
    private PullToRefreshListView refreshMyHeadline;
    @Override
    protected int getLayout() {
        return R.layout.activity_my_headline;
    }

    @Override
    protected void initViews() {
       //refreshMyHeadline
//
        setTitleText("我的头条");
        refreshMyHeadline = (PullToRefreshListView) findViewById(R.id.my_headline_refresh_listview);
        setListener();
        setListview();

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }

    /**
     * 设置下拉刷新和上拉加载监听
     */
    protected void setListener(){
        refreshMyHeadline.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉刷新时回调
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {


            }

            //上拉加载时回调
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });

    }

    /**
     *设置listview
     */
    protected void setListview(){
        //设置既有刷新头，也有加载尾
        refreshMyHeadline.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = refreshMyHeadline.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新...");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新...");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = refreshMyHeadline.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载...");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载...");

    }
}
