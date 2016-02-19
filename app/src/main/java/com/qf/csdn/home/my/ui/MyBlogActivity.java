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
import com.qf.csdn.home.my.adapter.MyblogItemAdapter;
import com.qf.csdn.home.my.bean.MyBlogItem;
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
public class MyBlogActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    private PullToRefreshListView refreshMyHBlog;
    private List<MyBlogItem.DataEntity> dataEntityList;
    private Object myBlogItemData;
    private MyblogItemAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_blog;
    }

    @Override
    protected void initViews() {
        setTitleText("我的博客");
        refreshMyHBlog = (PullToRefreshListView) findViewById(R.id.my_blog_refresh_listview);

        setListview();
        setListener();
        dataEntityList = new ArrayList<>();
        adapter = new MyblogItemAdapter(this,dataEntityList);
        refreshMyHBlog.setAdapter(adapter);


    }

    @Override
    protected void initEvents() {
        refreshMyHBlog.setOnItemClickListener(this);

    }

    @Override
    protected void initData() {
        //得到条目的数据
        getMyBlogItemData();

    }

    /**
     * 设置下拉刷新和上拉加载监听
     */
    protected void setListener(){
        refreshMyHBlog.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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
        refreshMyHBlog.setMode(PullToRefreshBase.Mode.BOTH);

        //第一个参数为true，得到刷新头部，设置头部提示文字
        ILoadingLayout headLayout = refreshMyHBlog.getLoadingLayoutProxy(true, false);
        headLayout.setPullLabel("下拉刷新");
        headLayout.setRefreshingLabel("正在刷新...");
        headLayout.setReleaseLabel("放开刷新");

        //第二个参数设置为true，得到加载尾部，设置尾部提示文字
        ILoadingLayout footLayout = refreshMyHBlog.getLoadingLayoutProxy(false,true);
        footLayout.setPullLabel("上拉加载");
        footLayout.setRefreshingLabel("正在加载...");
        footLayout.setReleaseLabel("放开加载");

    }

    private void getMyBlogItemData() {
        String url = "http://ms.csdn.net/api/blog/user_blog_list";
        final String username = "program008";
        final int pagesize = 16;
        final int page = 1;
        MyAppliction.mRequestQueue.cancelAll("myBlogItem2");
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        MyBlogItem myBlogItem = gson.fromJson(response, MyBlogItem.class);
                        List<MyBlogItem.DataEntity> data = myBlogItem.getData();
                        dataEntityList.addAll(data);
                        adapter.notifyDataSetChanged();
                        refreshMyHBlog.onRefreshComplete();

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
                params.put("username",username+"");
                params.put("pagesize",pagesize+"");
                params.put("page",page+"");
                return params;
            }
        };
        request.setTag("myBlogItem2");
        MyAppliction.mRequestQueue.add(request);
    }

    /**
     * 我的博客的条目点击监听事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyBlogItem.DataEntity data = dataEntityList.get(position-1);
        int articleId = data.getArticleId();
        Log.d("articleId",articleId+"");

        Intent intent = new Intent(this,MyBlogArticleContentActivity.class);
        intent.putExtra("articleId",articleId+"");
        startActivity(intent);
    }
}

