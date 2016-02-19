package com.qf.csdn.other.utils;

import android.util.Log;

/**
 * 日志管理器
 * isDebug控制是否打印日志：
 *                      true：打印日志
 *                      false：不打印日志
 * Created by LiuTao008
 * on 2016/2/17.
 */
public class LogUtil {
    private  static boolean isDebug = true;

    /**
     * 错误的日志
     * @param tag
     * @param msg
     */
    public static void e(String tag,String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }

    /**
     * 警告的日志
     * @param tag
     * @param msg
     */
    public static void w(String tag,String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }

    /**
     * 调试的日志
     * @param tag
     * @param msg
     */
    public static void d(String tag,String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }

    /**
     * 一般信息的日志
     * @param tag
     * @param msg
     */
    public static void i(String tag,String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
}
