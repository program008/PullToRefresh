package com.qf.csdn.other.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qf.csdn.R;
import com.qf.csdn.home.ask.ui.AskFragment;
import com.qf.csdn.home.bbs.ui.BbsFragment;
import com.qf.csdn.home.blog.ui.BlogFragment;
import com.qf.csdn.home.headline.ui.HeadLineFragment;
import com.qf.csdn.home.my.ui.MyFragment;
import com.qf.csdn.other.widget.CircleImageView;

/**
 * Created by LiuTao008
 * on 2016/1/29.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private TextView modelNight, modeDay;
    private ImageView headOpen;
    private static TextView headTitle;
    private static ImageView headSearch, headAdd;
    private static RadioGroup blogHeadRg, askHeadRg, bbsHeadRg;
    private static ImageView myHeadletter;
    private LinearLayout headlineDrawer;
    private LinearLayout blogDrawer;
    private LinearLayout askDrawer;
    private LinearLayout bbsDrawer;
    private LinearLayout myDrawer;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initHeadView();
        initDrawerLayout();
        //TODO 切换home页面的Fragment
        //初始化fragment，并将fragment添加到fragmentManager中
        initFragment();
    }

    /**
     * 初始化home页actionbar的控件
     */
    private void initHeadView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        headOpen = (ImageView) findViewById(R.id.home_head_iv_open);
        headOpen.setOnClickListener(this);

        headTitle = (TextView) findViewById(R.id.home_head_tv_title);
        headSearch = (ImageView) findViewById(R.id.home_head_iv_search);
        headAdd = (ImageView) findViewById(R.id.home_head_iv_add);
        blogHeadRg = (RadioGroup) findViewById(R.id.home_blog_head_rg);
        askHeadRg = (RadioGroup) findViewById(R.id.home_ask_head_rg);
        bbsHeadRg = (RadioGroup) findViewById(R.id.home_bbs_head_rg);
        myHeadletter = (ImageView) findViewById(R.id.home_my_head_iv_letter);

    }

    /**
     * 设置head的title
     *
     * @param titleName
     */
    public static void setHeadTile(String titleName) {
        headTitle.setVisibility(View.VISIBLE);
        headTitle.setText(titleName);
    }

    public static void hideHeadTitle() {
        headTitle.setVisibility(View.GONE);
    }

    /**
     * 显示head的搜索按钮
     *
     * @return
     */
    public static ImageView showHeadSearch() {
        if (headSearch == null) {
            Log.i("tag", "headSearch为空");
        }
        headSearch.setVisibility(View.VISIBLE);
        return headSearch;
    }

    /**
     * 隱藏head的搜索按钮
     *
     * @return
     */
    public static void hideHeadSearch() {
        headSearch.setVisibility(View.GONE);
    }

    /**
     * 显示head的添加按钮
     *
     * @return
     */
    public static ImageView showHeadAdd() {
        headAdd.setVisibility(View.VISIBLE);
        return headAdd;
    }

    /**
     * 隱藏head的添加按钮
     *
     * @return
     */
    public static void hideHeadAdd() {
        headAdd.setVisibility(View.GONE);
    }

    /**
     * 显示blog页头的rg
     *
     * @return
     */
    public static RadioGroup showBlogHeadRg() {
        blogHeadRg.setVisibility(View.VISIBLE);
        return blogHeadRg;
    }

    /**
     * 隱藏blog页头的rg
     *
     * @return
     */
    public static void hideBlogHeadRg() {
        blogHeadRg.setVisibility(View.GONE);

    }

    /**
     * 显示ask页头的rg
     *
     * @return
     */
    public static RadioGroup showAskHeadRg() {
        askHeadRg.setVisibility(View.VISIBLE);
        return askHeadRg;
    }

    /**
     * 隱藏ask页头的rg
     *
     * @return
     */
    public static void hideAskHeadRg() {
        askHeadRg.setVisibility(View.GONE);
    }

    /**
     * 显示bbs页头的rg
     *
     * @return
     */
    public static RadioGroup showBbsHeadRg() {
        bbsHeadRg.setVisibility(View.VISIBLE);
        return bbsHeadRg;
    }

    /**
     * 隱藏bbs页头的rg
     *
     * @return
     */
    public static void hideBbsHeadRg() {
        bbsHeadRg.setVisibility(View.GONE);
    }

    /**
     * 显示my页头的letter图标
     *
     * @return
     */
    public static ImageView showMyHeadLetter() {
        myHeadletter.setVisibility(View.VISIBLE);
        return myHeadletter;
    }

    /**
     * 隱藏my页头的letter图标
     *
     * @return
     */
    public static void hideMyHeadLetter() {
        myHeadletter.setVisibility(View.GONE);

    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        fragments = new Fragment[]{
                new HeadLineFragment(),
                new BlogFragment(),
                new AskFragment(),
                new BbsFragment(),
                new MyFragment()
        };
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.home_content_fl,fragments[0]);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * 初始化list的数据
     */
    private void initDrawerLayout() {
        //设置用户头像
        CircleImageView user_avater = (CircleImageView) findViewById(R.id.home_drawer_head_iv);
        user_avater.setImageUrl("http://avatar.csdn.net/7/0/4/1_program008.jpg");

        //给为尾部的按钮设置监听，做替换
        modelNight = (TextView) findViewById(R.id.home_drawer_btn_night);
        modeDay = (TextView) findViewById(R.id.home_drawer_btn_day);
        modelNight.setOnClickListener(this);
        modeDay.setOnClickListener(this);

        //抽屉条目
        headlineDrawer = (LinearLayout) findViewById(R.id.drawerLayout_item_headline_ll);
        blogDrawer = (LinearLayout) findViewById(R.id.drawerLayout_item_blog_ll);
        askDrawer = (LinearLayout) findViewById(R.id.drawerLayout_item_ask_ll);
        bbsDrawer = (LinearLayout) findViewById(R.id.drawerLayout_item_bbs_ll);
        myDrawer = (LinearLayout) findViewById(R.id.drawerLayout_item_my_ll);

        headlineDrawer.setOnClickListener(this);
        blogDrawer.setOnClickListener(this);
        askDrawer.setOnClickListener(this);
        bbsDrawer.setOnClickListener(this);
        myDrawer.setOnClickListener(this);

        //头条默认选中
        headlineDrawer.setSelected(true);


    }

   /* private void navigationListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getGroupId();
                switch (id) {
                    case R.id.home_menu_ask:
                        Toast.makeText(HomeActivity.this, "点点", Toast.LENGTH_LONG);
                        break;
                }
                return false;
            }
        });
    }*/

    //设置开发
   /* private void setToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                linearLayout,
                R.string.open,
                R.string.close
        );
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);
    }*/

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.home_drawer_btn_night:
                //TODO 切换到夜间模式
                modelNight.setVisibility(View.GONE);
                modeDay.setVisibility(View.VISIBLE);
                break;
            case R.id.home_drawer_btn_day:
                //TODO 切换到日间模式
                modeDay.setVisibility(View.GONE);
                modelNight.setVisibility(View.VISIBLE);
                break;
            case R.id.home_head_iv_open:
                openLeftMenu();
                break;
            case R.id.drawerLayout_item_headline_ll:
                setDrawerItemSelected(true,false,false,false,false);
                showFragment(true,false,false,false,false);
                break;
            case R.id.drawerLayout_item_blog_ll:
                setDrawerItemSelected(false,true,false,false,false);
                showFragment(false, true, false, false, false);
                break;
            case R.id.drawerLayout_item_ask_ll:
                setDrawerItemSelected(false,false,true,false,false);
                showFragment(false, false, true, false, false);
                break;
            case R.id.drawerLayout_item_bbs_ll:
                setDrawerItemSelected(false,false,false,true,false);
                showFragment(false, false, false, true, false);
                break;
            case R.id.drawerLayout_item_my_ll:
                setDrawerItemSelected(false,false,false,false,true);
                showFragment(false, false, false, false, true);
                break;
            default:
                break;
        }
    }

    /**
     * 设置打开抽屉
     */
    public void openLeftMenu() {
        drawerLayout.openDrawer(Gravity.LEFT);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                Gravity.LEFT);
    }

    /**
     * 设置抽屉的条目被选中
     * @param isHeadline
     * @param isBlog
     * @param isAsk
     * @param isBbs
     * @param isMy
     */
    private void setDrawerItemSelected(boolean isHeadline,boolean isBlog,boolean isAsk,boolean isBbs,boolean isMy){
        headlineDrawer.setSelected(isHeadline);
        blogDrawer.setSelected(isBlog);
        askDrawer.setSelected(isAsk);
        bbsDrawer.setSelected(isBbs);
        myDrawer.setSelected(isMy);
    }

    /**
     * 显示隐藏对应的fragment
     */
    private void showFragment(boolean isHeadline,boolean isBlog,boolean isAsk,boolean isBbs,boolean isMy){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (isHeadline){
           transaction.replace(R.id.home_content_fl, fragments[0]);
        }

        if (isBlog){
            transaction.replace(R.id.home_content_fl, fragments[1]);
        }

        if (isAsk){
            transaction.replace(R.id.home_content_fl, fragments[2]);
        }

        if (isBbs){
            transaction.replace(R.id.home_content_fl, fragments[3]);
        }

        if (isMy){
            transaction.replace(R.id.home_content_fl, fragments[4]);
        }
        transaction.commit();
    }





}
