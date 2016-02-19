package com.qf.csdn.other.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qf.csdn.R;

/**
 * Created by LiuTao008
 * on 2016/2/15.
 */
public abstract class ContentBaseActivity extends Activity{
    private ImageView ivLeft;
    private TextView tvTitle,writeComment,lookComment;
    private RelativeLayout dianzanUp,dianzanDown;
    protected LinearLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_content);
        //左边的返回按钮
        ivLeft = (ImageView) findViewById(R.id.base_titlebar_back_iv);
        //中间的标题
        tvTitle = (TextView) findViewById(R.id.base_titlebar_title_tv);
        //写评论
        writeComment = (TextView) findViewById(R.id.article_write_comment_tv);
        //看评论
        lookComment = (TextView) findViewById(R.id.article_look_comment_tv);

        //点赞
        dianzanUp = (RelativeLayout) findViewById(R.id.article_content_dianzan_up_rl);
        //踩
        dianzanDown = (RelativeLayout) findViewById(R.id.article_content_dianzan_down_rl);
        //子布局的容器
        llContent = (LinearLayout) findViewById(R.id.base_content_ll);


        setDefaultEvent();
        // 把子类里面的布局添加到title_bar下面的LinearLayout中
        getLayoutInflater().inflate(getLayout(), llContent);
        initViews();
        initEvents();
        initData();
    }

    /**
     * 获取布局
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化布局
     */
    protected abstract void initViews();

    /**
     * 初始化事件
     */
    protected abstract void initEvents();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置左边的返回图标的默认监听事件
     */
    private void setDefaultEvent(){
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void setTitleText(String title)
    {
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
    }

    protected void setTitleText(int stringId)
    {
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(stringId);
    }

}
