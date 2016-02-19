package com.qf.csdn.other.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qf.csdn.R;
import com.qf.csdn.login.activity.LoginActivity;
import com.qf.csdn.other.utils.Contant;

public class WelcomeActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private boolean isFristLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        sp = getSharedPreferences(Contant.LOGIN_SP_NAME, MODE_PRIVATE);
        isFristLogin = sp.getBoolean(Contant.LOGIN_SP_FLAG, true);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(isFristLogin){
                    SystemClock.sleep(2000);
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    //TODO 跳转到home页
                    Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                finish();
            }
        }, 1000); //延迟2秒跳转

    }
}
