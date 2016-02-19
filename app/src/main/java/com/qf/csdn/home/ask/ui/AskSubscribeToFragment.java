package com.qf.csdn.home.ask.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseFragment;

/**
 * Created by LiuTao008
 * on 2016/2/17.
 */
public class AskSubscribeToFragment extends BaseFragment implements View.OnClickListener {
    private PullToRefreshListView refreshSubscribeTo;
    private ImageView addTagIv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_ask_subscribeto;
    }

    @Override
    protected void initViews() {
        refreshSubscribeTo = (PullToRefreshListView) root.findViewById(R.id.ask_subscribeto_refresh_listview);
        setListview();
        setListener();

        addTagIv = (ImageView) root.findViewById(R.id.ask_subscribeto_add_tag_iv);

    }

    @Override
    protected void initEvents() {

        addTagIv.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    /**
     * 设置下拉刷新和上拉加载监听
     */
    protected void setListener(){
        refreshSubscribeTo.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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
        refreshSubscribeTo.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = refreshSubscribeTo.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = refreshSubscribeTo.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载");

    }

    /**
     * 问答界面的订阅界面的点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ask_subscribeto_add_tag_iv:
                //点击添加订阅界面的标记tag
                Intent intent = new Intent(getActivity(),AskAddTagActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
