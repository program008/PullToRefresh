package com.qf.csdn.home.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Created by LiuTao008
 * on 2016/2/2.
 */
public class HeadlineVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> vpList;
    public HeadlineVpAdapter(FragmentManager fm) {
        super(fm);
    }

    public HeadlineVpAdapter(FragmentManager fm, List<Fragment> vpList) {
        super(fm);
        this.vpList = vpList;
    }

    @Override
    public Fragment getItem(int position) {
        return vpList.get(position);
    }

    @Override
    public int getCount() {
        return vpList.size();
    }
}
