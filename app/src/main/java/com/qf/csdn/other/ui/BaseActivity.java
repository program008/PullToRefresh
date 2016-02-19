package com.qf.csdn.other.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qf.csdn.R;

/**
 * 所有信息展示的activity的父类
 * Created by LiuTao008
 * on 2016/2/3.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ImageView ivLeft,ivSearch,ivHome;
    protected TextView tvTitle;
    protected TextView tvRight;
    protected RadioGroup rgBbs,rgRelation,rgAsk;
    protected LinearLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //左边的返回按钮
        ivLeft = (ImageView) findViewById(R.id.base_titlebar_back_iv);
        //中间的标题
        tvTitle = (TextView) findViewById(R.id.base_titlebar_title_tv);
        //右边的文本
        tvRight = (TextView) findViewById(R.id.base_titlebar_right_tv);
        //右边搜索按钮
        ivSearch = (ImageView) findViewById(R.id.base_titlebar_search_iv);
        //右边home按钮
        ivHome = (ImageView) findViewById(R.id.base_titlebar_home_iv);
        //我的论坛的rg
        rgBbs = (RadioGroup) findViewById(R.id.base_titlebar_bbs_rg);
        //我的问答的rg
        //rgAsk = (RadioGroup) findViewById(R.id.base_titlebar_ask_rg);
        rgAsk = (RadioGroup) findViewById(R.id.base_titlebar_ask_rg);
        //我的关系的rg
        rgRelation = (RadioGroup) findViewById(R.id.base_titlebar_relation_rg);
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

    protected void setRightText(String text)
    {
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(text);
    }

    protected void setRightText(int stringId)
    {
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(stringId);
    }

    protected void showIvSearch(){
        ivSearch.setVisibility(View.VISIBLE);
    }

    protected void showIvHome(){
        ivHome.setVisibility(View.VISIBLE);
    }
    protected void showRgBbs(){
        rgBbs.setVisibility(View.VISIBLE);
    }
    protected void showRgAsk(){
        rgAsk.setVisibility(View.VISIBLE);
    }
    protected void showRgRelation(){
        rgRelation.setVisibility(View.VISIBLE);
    }


}
