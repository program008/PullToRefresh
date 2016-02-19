package com.qf.csdn.other.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qf.csdn.R;


/**
 * 该抽象类为本运用所有fragment的父类
 * Created by LiuTao008
 * on 2016/1/30.
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 该页面最低层的布局
     */
    protected View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(getLayout(), container, false);
        return root;
    }


    /**
     * 该方法中调用的顺序一定不能乱放，这样可能会出现空指针异常
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();

        initEvents();

        initData();
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化视图
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


}