package com.qf.csdn.home.ask.ui;

import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.csdn.R;
import com.qf.csdn.home.ask.adapter.AskRewardListviewItemAdapter;
import com.qf.csdn.home.ask.bean.AskAllQuestion;
import com.qf.csdn.home.ask.bean.AskRewardQuestion;
import com.qf.csdn.other.ui.BaseFragment;
import com.qf.csdn.other.utils.LogUtil;
import com.qf.csdn.other.utils.MyAppliction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiuTao008
 * on 2016/2/17.
 */
public class AskRewardFragment  extends BaseFragment{
    private PullToRefreshListView refreshAskReward;
    private List<AskRewardQuestion.DataEntity.DataEntityReward> entityRewardLis;
    private AskRewardListviewItemAdapter adapter;
    private int page = 1;

    @Override
    protected int getLayout() {
        return R.layout.fragment_ask_reward;
    }

    @Override
    protected void initViews() {
        entityRewardLis = new ArrayList<>();
        refreshAskReward = (PullToRefreshListView) root.findViewById(R.id.ask_reward_refresh_listview);
        setListview();
        setListener();
        adapter = new AskRewardListviewItemAdapter(getActivity(),entityRewardLis);
        refreshAskReward.setAdapter(adapter);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {
        getAskRewardJson();
    }


    /**
     * 设置下拉刷新和上拉加载监听
     */
    protected void setListener(){
        refreshAskReward.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉刷新时回调
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {


            }

            //上拉加载时回调
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getAskRewardJson();
            }
        });

    }

    /**
     *设置listview
     */
    protected void setListview(){
        //设置既有刷新头，也有加载尾
        refreshAskReward.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = refreshAskReward.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = refreshAskReward.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载");

    }

    protected void getAskRewardJson() {
        String url = "http://ms.csdn.net/api/ask/all_questions";
        final int is_reward = 1;

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        LogUtil.d("qfaskall", response);

                        Gson gson = new Gson();
                        AskRewardQuestion askRewardQuestion = gson.fromJson(response, AskRewardQuestion.class);
                        AskRewardQuestion.DataEntity data = askRewardQuestion.getData();
                        List<AskRewardQuestion.DataEntity.DataEntityReward> dataData = data.getData();
                        entityRewardLis.addAll(dataData);
                        adapter.notifyDataSetChanged();
                        refreshAskReward.onRefreshComplete();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("page",page+"");
                params.put("is_reward",is_reward+"");
                return params;
            }
        };
        MyAppliction.mRequestQueue.add(request);
        page++;

    }
}
