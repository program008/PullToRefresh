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
public class MyBbsActivity extends BaseActivity {

    private PullToRefreshListView refreshMyBbs;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_bbs;
    }

    @Override
    protected void initViews() {
        setTitleText("我的论坛");
        showIvHome();
        showRgBbs();
        rgBbs.getChildAt(0).setSelected(true);

        refreshMyBbs = (PullToRefreshListView) findViewById(R.id.my_bbs_refresh_listview);
        setListview();
        setListener();

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
        refreshMyBbs.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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
        refreshMyBbs.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = refreshMyBbs.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = refreshMyBbs.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载");

    }
}
