package com.qf.csdn.home.my.ui;

import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.qf.csdn.R;
import com.qf.csdn.home.my.bean.MyCollectCotent;
import com.qf.csdn.other.ui.ContentBaseActivity;
import com.qf.csdn.other.utils.MyAppliction;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiuTao008
 * on 2016/2/15.
 */
public class CollectArticleContentActivity extends ContentBaseActivity{

    private String articleId;
    private ImageView userAvater;
    private TextView userName,createTime,contentTv,titleTv,viewcountTv;
    @Override
    protected int getLayout() {
        return R.layout.activity_collect_article_content;
    }

    @Override
    protected void initViews() {
        setTitleText("详情");
        Intent intent = getIntent();
        articleId = intent.getStringExtra("articleId");
        Log.i("tag", "articleId  ---" + articleId);

        userAvater = (ImageView) findViewById(R.id.collect_article_content_user_avatar);
        userName = (TextView) findViewById(R.id.collect_article_content_username);
        createTime = (TextView) findViewById(R.id.collect_article_content_create_time);
        contentTv = (TextView) findViewById(R.id.collect_article_content_tv);
        titleTv = (TextView) findViewById(R.id.collect_article_content_title_tv);
        viewcountTv = (TextView) findViewById(R.id.collect_article_content_view_count);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {
        //得到博客详情的数据
        getCollectArticleContent();



    }

    private void getCollectArticleContent() {
       String url = "http://ms.csdn.net/api/v2/geek/detail";
        final String SessionId = "SESSIONID-csdn-ST-2871-EzxtGHPb4KoQOa4PRfIm-passport.csdn.net";
        MyAppliction.mRequestQueue.cancelAll("collectarticlecontent");
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                     Log.d("tag","内容详情 "+response);

                        Gson gson = new Gson();
                        MyCollectCotent myCollectCotent = gson.fromJson(response, MyCollectCotent.class);
                        MyCollectCotent.DataEntity data = myCollectCotent.getData();

                        if(data!=null){
                            //设置详情的内容
                            String avatar = data.getAvatar();
                            MyAppliction.mBitmapUtils.display(userAvater, avatar);

                            String nickname = data.getNickname();
                            userName.setText(nickname+"");

                            //2016-01-26 09:34:38
                            String created_time = data.getCreated_time();
                            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm");
                            Long value = Long.parseLong(created_time)*1000;
                            String create_date = sdf.format(value);
                            createTime.setText("分享于 "+create_date + "");


                            String title = data.getTitle();
                            titleTv.setText(title + "");

                            int view_count = data.getClick_num();
                            viewcountTv.setText("阅读量 " + view_count + "");

                            String content = data.getBody();
                            Spanned spanned = Html.fromHtml(content);
                            contentTv.setText(spanned.toString());
                        }else {
                            /*private ImageView userAvater;
                            private TextView userName,createTime,contentTv,titleTv,viewcountTv;*/

                            userAvater.setVisibility(View.INVISIBLE);
                            userName.setVisibility(View.INVISIBLE);
                            createTime.setVisibility(View.INVISIBLE);
                            contentTv.setVisibility(View.INVISIBLE);
                            viewcountTv.setVisibility(View.INVISIBLE);
                            titleTv.setText("抱歉！文章不存在");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("err","err "+ error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("SessionId",SessionId+"");
                params.put("id",articleId+"");
                return params;

            }
        };
        request.setTag("collectarticlecontent");
        MyAppliction.mRequestQueue.add(request);
    }
}
