package com.qf.csdn.home.my.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseActivity;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class MyHeadActivity extends BaseActivity implements View.OnClickListener{

    private RelativeLayout rlModifyNickName, rlModifySkill, rlModifyName,
    rlModifyJob, rlModifyTrade, rlModifyJobLive, rlModifyEduLive,rlModifySetting;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_head;
    }

    @Override
    protected void initViews() {
        setTitleText("修改资料");
        rlModifyNickName = (RelativeLayout) findViewById(R.id.my_modify_nickname_rl);
        rlModifySkill = (RelativeLayout) findViewById(R.id.my_modify_skill_rl);
        rlModifyName = (RelativeLayout) findViewById(R.id.my_modify_name_rl);
        rlModifyJob = (RelativeLayout) findViewById(R.id.my_modify_job_rl);
        rlModifyTrade = (RelativeLayout) findViewById(R.id.my_modify_trade_rl);
        rlModifyJobLive = (RelativeLayout) findViewById(R.id.my_modify_joblive_rl);
        rlModifyEduLive = (RelativeLayout) findViewById(R.id.my_modify_edulive_rl);
        rlModifySetting = (RelativeLayout) findViewById(R.id.my_modify_hideset_rl);



    }

    @Override
    protected void initEvents() {

        rlModifyNickName.setOnClickListener(this);
        rlModifySkill.setOnClickListener(this);
        rlModifyName.setOnClickListener(this);
        rlModifyJob.setOnClickListener(this);
        rlModifyTrade.setOnClickListener(this);
        rlModifyJobLive.setOnClickListener(this);
        rlModifyEduLive.setOnClickListener(this);
        rlModifySetting.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    /**
     * 修改资料页面的点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {

        int id = v.getId();
        Intent intent = null;
        switch (id){
            case R.id.my_modify_nickname_rl:
                Log.i("tag","1");
                intent = new Intent(this,ModifyNickNameActivity.class);
                startActivity(intent);
                break;
            case R.id.my_modify_skill_rl:
                Log.i("tag", "2");
                intent = new Intent(this,ModifySkillActivity.class);
                startActivity(intent);

                break;
            case R.id.my_modify_name_rl:
                Log.i("tag", "3");
                intent = new Intent(this,ModifyNameActivity.class);
                startActivity(intent);
                break;
            case R.id.my_modify_job_rl:
                Log.i("tag","4");
                intent = new Intent(this,ModifyJobActivity.class);
                startActivity(intent);
                break;
            case R.id.my_modify_trade_rl:
                Log.i("tag","5");
                break;
            case R.id.my_modify_joblive_rl:
                Log.i("tag","6");
                intent = new Intent(this,AddJobLiveActivity.class);
                startActivity(intent);
                break;
            case R.id.my_modify_edulive_rl:
                Log.i("tag","7");
                intent = new Intent(this,AddEduLiveActivity.class);
                startActivity(intent);
                break;
            case R.id.my_modify_hideset_rl:
                Log.i("tag","8");
                intent = new Intent(this,HideSetActivity.class);
                startActivity(intent);
                break;
        }
    }
}
