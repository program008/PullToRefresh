package com.qf.csdn.home.headline.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.csdn.R;
import com.qf.csdn.home.headline.adapter.HeadlineVpAdapter;
import com.qf.csdn.other.ui.BaseFragment;
import com.qf.csdn.other.ui.HomeActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LiuTao008
 * on 2016/1/30.
 */
public class HeadLineFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    private ImageView headSearch;
    private ImageView headAdd;
    private RadioGroup radioGroup;
    private RadioButton mrb0, mrb1, mrb2, mrb3, mrb4,
            mrb5, mrb6, mrb7, mrb8, mrb9,
            mrb10, mrb11, mrb12, mrb13, mrb14;
    private ImageView mImageBar;
    private HorizontalScrollView mHorizontalScrollView;
    private ViewPager mViewPager;
    private float mCurrentCheckedRadioLeft;
    private List<Fragment> vpList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_headline;
    }

    @Override
    protected void initViews() {
        //显示head头的控件
        HomeActivity.setHeadTile("头条");//设置标题
        headSearch = HomeActivity.showHeadSearch();//搜索的图标
        headAdd = HomeActivity.showHeadAdd();//添加的图标

        HomeActivity.hideBbsHeadRg();
        HomeActivity.hideBlogHeadRg();
        HomeActivity.hideAskHeadRg();
        HomeActivity.hideMyHeadLetter();


        //初始化导航菜单需要的控件
        radioGroup = (RadioGroup) root.findViewById(R.id.home_headline_guide_rg);
        mrb0 = (RadioButton) root.findViewById(R.id.home_headline_rb0);
        mrb1 = (RadioButton) root.findViewById(R.id.home_headline_rb1);
        mrb2 = (RadioButton) root.findViewById(R.id.home_headline_rb2);
        mrb3 = (RadioButton) root.findViewById(R.id.home_headline_rb3);
        mrb4 = (RadioButton) root.findViewById(R.id.home_headline_rb4);
        mrb5 = (RadioButton) root.findViewById(R.id.home_headline_rb5);
        mrb6 = (RadioButton) root.findViewById(R.id.home_headline_rb6);
        mrb7 = (RadioButton) root.findViewById(R.id.home_headline_rb7);
        mrb8 = (RadioButton) root.findViewById(R.id.home_headline_rb8);
        mrb9 = (RadioButton) root.findViewById(R.id.home_headline_rb9);
        mrb10 = (RadioButton) root.findViewById(R.id.home_headline_rb10);
        mrb11 = (RadioButton) root.findViewById(R.id.home_headline_rb11);
        mrb12 = (RadioButton) root.findViewById(R.id.home_headline_rb12);
        mrb13 = (RadioButton) root.findViewById(R.id.home_headline_rb13);
        mrb14 = (RadioButton) root.findViewById(R.id.home_headline_rb14);
        mrb0.setChecked(true);
       // mImageBar = (ImageView) root.findViewById(R.id.headline_imageBar);
        mHorizontalScrollView = (HorizontalScrollView) root.findViewById(R.id.horizontalScrollView);
        //初始化viewpager的控件
        mViewPager = (ViewPager) root.findViewById(R.id.home_headline_vp);
        //得到rb的宽度
        mCurrentCheckedRadioLeft= getCurrentCheckedRadioLeft();

    }

    @Override
    protected void initEvents() {

        radioGroup.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void initData() {
        vpList = new ArrayList<>();
        vpList.add(new HeadlineItemFt1());
        vpList.add(new HeadlineItemFt215(1));
        vpList.add(new HeadlineItemFt215(2));
        vpList.add(new HeadlineItemFt215(3));
        vpList.add(new HeadlineItemFt215(4));
        vpList.add(new HeadlineItemFt215(5));
        vpList.add(new HeadlineItemFt215(6));
        vpList.add(new HeadlineItemFt215(7));
        vpList.add(new HeadlineItemFt215(8));
        vpList.add(new HeadlineItemFt215(9));
        vpList.add(new HeadlineItemFt215(10));
        vpList.add(new HeadlineItemFt215(11));
        vpList.add(new HeadlineItemFt215(12));
        vpList.add(new HeadlineItemFt215(13));
        vpList.add(new HeadlineItemFt215(14));

        Log.i("tag", "vpList的大小" + vpList.size());

       /* HeadlineVpAdapter adapter = new HeadlineVpAdapter(getFragmentManager(),vpList);
        mViewPager.setAdapter(adapter);*/


    }

    /**
     * 获得当前被选中的RadioButton距离左侧的距离
     * @return
     */
    private float getCurrentCheckedRadioLeft(){

        if(mrb0.isChecked()){
            Log.i("tag",mrb0.getWidth()+"dp");
            return mrb0.getWidth();
        }else if(mrb1.isChecked()){
            Log.i("tag",mrb1.getWidth()+"dp");
            return mrb1.getWidth();
        }else if(mrb2.isChecked()){
            Log.i("tag",mrb2.getWidth()+"dp");
            return mrb2.getWidth();
        }else if(mrb3.isChecked()){
            Log.i("tag",mrb3.getWidth()+"dp");
            return mrb3.getWidth();
        }else if(mrb4.isChecked()){
            Log.i("tag",mrb4.getWidth()+"dp");
            return mrb4.getWidth();
        }else if(mrb5.isChecked()){
            Log.i("tag",mrb5.getWidth()+"dp");
            return mrb5.getWidth();
        }else if(mrb6.isChecked()){
            Log.i("tag",mrb6.getWidth()+"dp");
            return mrb6.getWidth();
        }else if(mrb7.isChecked()){
            Log.i("tag",mrb7.getWidth()+"dp");
            return mrb7.getWidth();
        }else if(mrb8.isChecked()){
            Log.i("tag",mrb8.getWidth()+"dp");
            return mrb8.getWidth();
        }else if(mrb9.isChecked()){
            Log.i("tag",mrb9.getWidth()+"dp");
            return mrb9.getWidth();
        }else if(mrb10.isChecked()){
            Log.i("tag",mrb10.getWidth()+"dp");
            return mrb10.getWidth();
        }else if(mrb11.isChecked()){
            Log.i("tag",mrb11.getWidth()+"dp");
            return mrb11.getWidth();
        }else if(mrb12.isChecked()){
            Log.i("tag",mrb12.getWidth()+"dp");
            return mrb12.getWidth();
        }else if(mrb13.isChecked()){
            Log.i("tag",mrb13.getWidth()+"dp");
            return mrb13.getWidth();
        }else if(mrb14.isChecked()){
            Log.i("tag",mrb14.getWidth()+"dp");
            return mrb14.getWidth();
        }
        return 0f;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.home_headline_rb0:
               mViewPager.setCurrentItem(0);
                break;
            case R.id.home_headline_rb1:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.home_headline_rb2:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.home_headline_rb3:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.home_headline_rb4:
                mViewPager.setCurrentItem(4);
                break;
            case R.id.home_headline_rb5:
                mViewPager.setCurrentItem(5);
                break;
            case R.id.home_headline_rb6:
                mViewPager.setCurrentItem(6);
                break;
            case R.id.home_headline_rb7:
                mViewPager.setCurrentItem(7);
                break;
            case R.id.home_headline_rb8:
                mViewPager.setCurrentItem(8);
                break;
            case R.id.home_headline_rb9:
                mViewPager.setCurrentItem(9);
                break;
            case R.id.home_headline_rb10:
                mViewPager.setCurrentItem(10);
                break;
            case R.id.home_headline_rb11:
                mViewPager.setCurrentItem(11);
                break;
            case R.id.home_headline_rb12:
                mViewPager.setCurrentItem(12);
                break;
            case R.id.home_headline_rb13:
                mViewPager.setCurrentItem(13);
                break;
            case R.id.home_headline_rb14:
                mViewPager.setCurrentItem(14);
                break;
        }

    }

    /**
     * headline页viewpager滚动的时候调用,一般使用onPageSelected()足够
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * headline页viewpager选中的时候调用
     * @param position
     */
    @Override
    public void onPageSelected(int position) {

        RadioButton childAt = (RadioButton) radioGroup.getChildAt(position);
        childAt.setChecked(true);
    }

    /**
     * headline页viewpager滚动状态改变的的时候调用,一般使用onPageSelected()足够
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
