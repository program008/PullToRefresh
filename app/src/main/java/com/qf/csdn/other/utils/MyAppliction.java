package com.qf.csdn.other.utils;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.BitmapUtils;

/**
 * Created by LiuTao008
 * on 2016/1/29.
 */
public class MyAppliction extends Application {
    public static RequestQueue mRequestQueue;
    public static BitmapUtils mBitmapUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        mBitmapUtils = new BitmapUtils(this);
    }
}
