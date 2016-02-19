package com.qf.csdn.login.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.qf.csdn.R;
import com.qf.csdn.other.ui.HomeActivity;
import com.qf.csdn.other.utils.Contant;
import com.qf.csdn.other.utils.MD5Util;
import com.qf.csdn.other.utils.MyAppliction;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_user,edt_pwd;
    private Button btn_login;
    private String pwd;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        //登录
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

    }

    /**
     * 用户
     */
    private void userLogin() {
        name = edt_user.getText().toString();
        pwd = edt_pwd.getText().toString();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
            Toast.makeText(this,"用户名或密码不能为空~",Toast.LENGTH_SHORT).show();
        }else {
            //进行登录password=sn6p5WyM9gydR6HFhHCC9A%3D%3D&username=program008&
            MyAppliction.mRequestQueue.cancelAll("cancel");
            StringRequest request = new StringRequest(Request.Method.POST,
                    Contant.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("user",response);
                            //TODO 登录成功后将数据传到主页进行其他的网络请求
                            //跳转到主页面
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();

                            //下次不在登录
                            SharedPreferences sp = getSharedPreferences(Contant.LOGIN_SP_NAME, MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putBoolean(Contant.LOGIN_SP_FLAG,false).commit();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("user","error "+error.getMessage());
                        }
                    }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    pwd = MD5Util.encrypt(pwd);
                    Map<String,String> params = new HashMap<>();
                    params.put("username", name);
                    params.put("password", pwd);
                    return params;
                }
            };
            request.setTag("cancel");
            MyAppliction.mRequestQueue.add(request);

        }


    }


    /**
     * 初始化控件
     */
    private void initViews() {
        edt_user = (EditText) findViewById(R.id.login_edt_csdn_account);
        edt_pwd = (EditText) findViewById(R.id.login_edt_csdn_pwd);
        btn_login = (Button) findViewById(R.id.login_btn_login);
    }


}
