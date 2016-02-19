package com.qf.csdn.home.my.ui;

import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.qf.csdn.R;
import com.qf.csdn.home.my.bean.MyBlogContent;
import com.qf.csdn.other.ui.ContentBaseActivity;
import com.qf.csdn.other.utils.MyAppliction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiuTao008
 * on 2016/2/15.
 */
public class MyBlogArticleContentActivity extends ContentBaseActivity{

    private String articleId;
    private ImageView userAvater;
    private TextView userName,createTime,contentTv,titleTv,viewcountTv;
    private MyBlogContent.DataEntity data;

    @Override
    protected int getLayout() {
        return R.layout.activity_myblog_article_content;
    }

    @Override
    protected void initViews() {
        setTitleText("详情");
        Intent intent = getIntent();
        articleId = intent.getStringExtra("articleId");
        userAvater = (ImageView) findViewById(R.id.article_content_user_avatar);
        userName = (TextView) findViewById(R.id.article_content_username);
        createTime = (TextView) findViewById(R.id.article_content_create_time);
        contentTv = (TextView) findViewById(R.id.article_content_tv);
        titleTv = (TextView) findViewById(R.id.article_content_title_tv);
        viewcountTv = (TextView) findViewById(R.id.article_content_view_count);


    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {
        //得到博客详情的数据
        getArticleContent();



    }

    public void getArticleContent() {
       String url = "http://ms.csdn.net/api/blog/get_blog_detail";
        final String SessionId = "SESSIONID-csdn-ST-2871-EzxtGHPb4KoQOa4PRfIm-passport.csdn.net";
        final String username = "program008";
        MyAppliction.mRequestQueue.cancelAll("articlecontent");
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                     Log.d("tag","内容详情 "+response);
                        Gson gson = new Gson();
                        MyBlogContent myBlogContent = gson.fromJson(response, MyBlogContent.class);
                        data = myBlogContent.getData();
                        //设置详情的内容
                        String avatar = data.getAvatar();
                        MyAppliction.mBitmapUtils.display(userAvater, avatar);

                        String username = data.getUsername();
                        userName.setText(username+"");
                        //2016-01-26 09:34:38
                        String create = data.getCreate();
                        createTime.setText(create + "");

                        String title = data.getTitle();
                        titleTv.setText(title + "");

                        int view_count = data.getView_count();
                        viewcountTv.setText("阅读量 " + view_count + "");

                        String content = data.getContent();
                        Spanned spanned = Html.fromHtml(content);
                        contentTv.setText(spanned.toString());


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
                params.put("SessionId",SessionId+"");
                params.put("articleId",articleId+"");
                return params;

            }
        };
        request.setTag("articlecontent");
        MyAppliction.mRequestQueue.add(request);
    }
}
