package com.qf.csdn.home.my.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.qf.csdn.home.my.adapter.MycollectItemListAdapter;
import com.qf.csdn.home.my.bean.MyCollectItem;
import com.qf.csdn.other.ui.BaseActivity;
import com.qf.csdn.other.utils.MyAppliction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class MyCollectionActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    private PullToRefreshListView collectList;
    private List<MyCollectItem.DataEntity.DataEntityCollect> collectEntity;
    private MycollectItemListAdapter adapter;
    private  int pageno = 1;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void initViews() {
        setTitleText("我的收藏");
        collectEntity = new ArrayList<>();
        collectList = (PullToRefreshListView) findViewById(R.id.my_collect_list);
        setListview();
        setListener();

        adapter = new MycollectItemListAdapter(this,collectEntity);
        collectList.setAdapter(adapter);

    }

    @Override
    protected void initEvents() {

        collectList.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        //获取条目的数据
        getMyCollectItemData();
    }

    private void getMyCollectItemData() {
        String url = "http://ms.csdn.net/api/favorite/get_list_favorite";
        final String SessionId="SESSIONID-csdn-ST-2871-EzxtGHPb4KoQOa4PRfIm-passport.csdn.net";
        final String username = "program008";
        final int pagesize = 10;
        MyAppliction.mRequestQueue.cancelAll("myCollectItem2");
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("tag","收藏 "+response);
                        Gson gson = new Gson();
                        MyCollectItem myCollectItem = gson.fromJson(response, MyCollectItem.class);

                        MyCollectItem.DataEntity data = myCollectItem.getData();
                        List<MyCollectItem.DataEntity.DataEntityCollect> dataEntity = data.getData();
                        Log.d("tag","收藏数据   "+dataEntity);
                        collectEntity.addAll(dataEntity);
                        adapter.notifyDataSetChanged();
                        collectList.onRefreshComplete();

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
                params.put("SessionId",SessionId+"");
                params.put("username",username+"");
                params.put("pagesize",pagesize+"");
                params.put("pageno",pageno+"");
                return params;
            }
        };
        request.setTag("myCollectItem2");
        MyAppliction.mRequestQueue.add(request);
        pageno++;
    }
    /**
     * 设置下拉刷新和上拉加载监听
     */
    protected void setListener(){
        collectList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉刷新时回调
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {


            }

            //上拉加载时回调
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getMyCollectItemData();
                refreshView.onRefreshComplete();
            }
        });

    }

    /**
     *设置listview
     */
    protected void setListview(){
        //设置既有刷新头，也有加载尾
        collectList.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = collectList.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = collectList.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载");

    }

    /**
     * 我的收藏，条目的点击进入博客详情
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("tag","position "+position);
        MyCollectItem.DataEntity.DataEntityCollect dataEntityCollect = collectEntity.get(position-1);
        String articleId = dataEntityCollect.getId();
        Intent intent = new Intent(this,CollectArticleContentActivity.class);
        intent.putExtra("articleId",articleId+"");
        startActivity(intent);

    }
}
