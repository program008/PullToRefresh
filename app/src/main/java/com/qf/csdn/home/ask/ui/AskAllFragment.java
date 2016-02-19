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
import com.qf.csdn.home.ask.adapter.AskAllListviewItemAdapter;
import com.qf.csdn.home.ask.bean.AskAllQuestion;
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
public class AskAllFragment extends BaseFragment {
    private PullToRefreshListView refreshAskAll;
    private Object askAllJson;
    private int page = 1;
    private List<AskAllQuestion.DataEntity.DataEntityAll> entityAlls;
    private AskAllListviewItemAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_ask_all;
    }

    @Override
    protected void initViews() {
        entityAlls = new ArrayList<>();
        refreshAskAll = (PullToRefreshListView) root.findViewById(R.id.ask_all_refresh_listview);
        setListview();
        setListener();
        adapter = new AskAllListviewItemAdapter(getActivity(),entityAlls);
        refreshAskAll.setAdapter(adapter);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

        getAskAllJson();
    }

    /**
     * 设置下拉刷新和上拉加载监听
     */
    protected void setListener(){
        refreshAskAll.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉刷新时回调
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {


            }

            //上拉加载时回调
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getAskAllJson();
            }
        });

    }

    /**
     *设置listview
     */
    protected void setListview(){
        //设置既有刷新头，也有加载尾
        refreshAskAll.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = refreshAskAll.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = refreshAskAll.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载");

    }

    protected void getAskAllJson() {
        String url = "http://ms.csdn.net/api/ask/all_questions";
        final int is_reward = 0;

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        LogUtil.d("qfaskall",response);

                        Gson gson = new Gson();
                        AskAllQuestion askAllQuestion = gson.fromJson(response, AskAllQuestion.class);
                        AskAllQuestion.DataEntity data = askAllQuestion.getData();
                        List<AskAllQuestion.DataEntity.DataEntityAll> dataData = data.getData();
                        entityAlls.addAll(dataData);
                        adapter.notifyDataSetChanged();
                        refreshAskAll.onRefreshComplete();

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
