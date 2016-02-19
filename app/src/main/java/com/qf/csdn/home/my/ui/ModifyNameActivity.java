package com.qf.csdn.home.my.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.qf.csdn.R;
import com.qf.csdn.other.ui.BaseActivity;

/**
 * Created by LiuTao008
 * on 2016/2/5.
 */
public class ModifyNameActivity extends BaseActivity implements View.OnClickListener{
    private EditText nickname;
    private ImageView editdelect;
    @Override
    protected int getLayout() {
        return R.layout.activity_modify_name;
    }

    @Override
    protected void initViews() {
        setRightText("保存");
        setTitleText("修改名字");
        nickname = (EditText) findViewById(R.id.my_modify_name_editText);
        editdelect = (ImageView) findViewById(R.id.my_modify_name_editdelect);
    }

    @Override
    protected void initEvents() {
        nickname.addTextChangedListener(textWatcher);
        editdelect.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        // TODO: 2016/2/5 得到输入框的值后作保存
        String nameData = nickname.getText().toString();
        Log.i("tag", nameData);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!TextUtils.isEmpty(s)){
                editdelect.setVisibility(View.VISIBLE);
            }else {
                editdelect.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.my_modify_name_editdelect){
            nickname.setText("");
        }
    }
}
