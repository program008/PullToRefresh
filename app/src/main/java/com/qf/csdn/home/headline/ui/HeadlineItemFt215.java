package com.qf.csdn.home.headline.ui;

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
import com.qf.csdn.home.headline.adapter.HeadlineItem215Adapter;
import com.qf.csdn.home.headline.bean.HeadlineListBean2;
import com.qf.csdn.other.ui.BaseFragment;
import com.qf.csdn.other.utils.MyAppliction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这是前端页到最后社区版务页的fragment,因为他们的布局基本是相同的,所有用一个
 * 相同的fragment,传入不同的值即可
 * Created by LiuTao008
 * on 2016/2/2.
 */
public class HeadlineItemFt215 extends BaseFragment implements PullToRefreshBase.OnRefreshListener2 {
    private int comid;
    private int page = 1;
    private String url = "http://ms.csdn.net/api/geek/comms_with_id";
    private PullToRefreshListView listView;
    private List<HeadlineListBean2.DataEntity> detaEntityList;
    private HeadlineItem215Adapter adapter;


    public HeadlineItemFt215() {

    }

    public HeadlineItemFt215(int comid) {
        this.comid = comid;
    }

    @Override
    protected int getLayout() {
        return R.layout.headline_ft215;
    }

    @Override
    protected void initViews() {

        detaEntityList = new ArrayList<>();
        listView = (PullToRefreshListView) root.findViewById(R.id.headline_item_ft215_listview);

        adapter = new HeadlineItem215Adapter(getActivity(),detaEntityList);
        listView.setAdapter(adapter);
        setRefreshView();
    }

    @Override
    protected void initEvents() {
        //设置下拉刷新上拉加载监听
        listView.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {

        //获取listview的数据
        getHeadlineItemBean215();


    }

    /**
     * 设置刷新的view样式
     */
    private void setRefreshView() {
        //设置既有刷新头，也有加载尾
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = listView.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新...");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新...");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = listView.getLoadingLayoutProxy(false, true);
        footLayout.setPullLabel("上拉加载更多...");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载更多...");
    }

    /**
     * 下拉刷新时回调
     *
     * @param refreshView
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

    }

    /**
     * 上拉加载时回调
     *
     * @param refreshView
     */
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }

    /**
     * 加载数据
     */
    public void getHeadlineItemBean215() {
        //应该根据不同的用户的登录返回的SessionId不同
        final String SessionId = "9o%2BQR9xHJtjugOOO6wrqCux5iZ2RJXfiwDg6McYrt6fiUVwajm1nWsnTucfWuVejY77fJPQ0R5Q%2BAN2M3oT%2BfA%3D%3D";
        MyAppliction.mRequestQueue.cancelAll("headlineitem");
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        HeadlineListBean2 headlineListBean2 = gson.fromJson(response, HeadlineListBean2.class);
                        List<HeadlineListBean2.DataEntity> dataEntities = headlineListBean2.getData();
                        detaEntityList.addAll(dataEntities);
                        adapter.notifyDataSetChanged();
                        listView.onRefreshComplete();


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
                params.put("Session",SessionId);
                params.put("comid",comid+"");
                params.put("page",page+"");
                return params;
            }
        };
        request.setTag("headlineitem");
        MyAppliction.mRequestQueue.add(request);


    }
}
