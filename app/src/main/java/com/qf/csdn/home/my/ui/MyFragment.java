package com.qf.csdn.home.my.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseFragment;
import com.qf.csdn.other.ui.HomeActivity;
import com.qf.csdn.other.utils.MyAppliction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * "我的"页面
 * Created by LiuTao008
 * on 2016/1/30.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener{

    private ImageView letter;
    private RelativeLayout rlHead,rlHeadline,rlBlog,rlAsk,rlBbs,rlDown,rlCollect,rlSetting;
    private TextView myBlogCount;

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initViews() {

        HomeActivity.setHeadTile("我的");
        HomeActivity.hideHeadAdd();
        HomeActivity.hideHeadSearch();
        HomeActivity.hideAskHeadRg();
        HomeActivity.hideBbsHeadRg();
        HomeActivity.hideBlogHeadRg();
        letter = HomeActivity.showMyHeadLetter();
        //获得条目点击控件
        rlHead = (RelativeLayout) root.findViewById(R.id.my_head_rl);
        rlHeadline = (RelativeLayout) root.findViewById(R.id.my_headline_rl);
        rlBlog = (RelativeLayout) root.findViewById(R.id.my_blog_rl);
        rlAsk = (RelativeLayout) root.findViewById(R.id.my_ask_rl);
        rlBbs = (RelativeLayout) root.findViewById(R.id.my_bbs_rl);
        rlDown = (RelativeLayout) root.findViewById(R.id.my_down_rl);
        rlCollect = (RelativeLayout) root.findViewById(R.id.my_collect_rl);
        rlSetting = (RelativeLayout) root.findViewById(R.id.my_setting_rl);


        myBlogCount = (TextView) root.findViewById(R.id.my_blog_number_tv);

    }

    @Override
    protected void initEvents() {
        rlHead.setOnClickListener(this);
        rlHeadline.setOnClickListener(this);
        rlBlog.setOnClickListener(this);
        rlAsk.setOnClickListener(this);
        rlBbs.setOnClickListener(this);
        rlDown.setOnClickListener(this);
        rlCollect.setOnClickListener(this);
        rlSetting.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        //显示我的博客的数目
        showBlogMyCount();

    }

    private void showBlogMyCount() {
        String url = "http://ms.csdn.net/api/geek/geeks_by_username";
        final String SessionId = "9o%2BQR9xHJtjugOOO6wrqCux5iZ2RJXfiwDg6McYrt6fiUVwajm1nWsnTucfWuVejY77fJPQ0R5Q%2BAN2M3oT%2BfA%3D%3D";
        final String username = "program008";
        MyAppliction.mRequestQueue.cancelAll("myBlogItem");
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("tag","我的博客的数目"+response);
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
                params.put("username",username+"");
                return params;
            }
        };
        request.setTag("myBlogItem");
        MyAppliction.mRequestQueue.add(request);
    }

    /**
     * 控件的点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        switch (id){
            case R.id.my_head_rl:
                intent = new Intent(getActivity(),MyHeadActivity.class);
                startActivity(intent);
                break;
            case R.id.my_headline_rl:

                intent = new Intent(getActivity(),MyHeadlineActivity.class);
                startActivity(intent);
                break;
            case R.id.my_blog_rl:
                intent = new Intent(getActivity(),MyBlogActivity.class);
                startActivity(intent);
                break;
            case R.id.my_ask_rl:
                intent = new Intent(getActivity(),MyAskActivity.class);
                startActivity(intent);
                break;
            case R.id.my_bbs_rl:
                intent = new Intent(getActivity(),MyBbsActivity.class);
                startActivity(intent);
                break;
            case R.id.my_down_rl:
                intent = new Intent(getActivity(),MyDownActivity.class);
                startActivity(intent);
                break;
            case R.id.my_collect_rl:
                intent = new Intent(getActivity(),MyCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.my_setting_rl:
                intent = new Intent(getActivity(),MySettingActivity.class);
                startActivity(intent);
                break;


        }
    }
}
