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
public class ModifyNickNameActivity extends BaseActivity implements View.OnClickListener{

    private EditText nickname;
    private ImageView editdelect;

    @Override
    protected int getLayout() {
        return R.layout.activity_modify_nickname;
    }

    @Override
    protected void initViews() {
        setRightText("保存");
        setTitleText("修改昵称");
        nickname = (EditText) findViewById(R.id.my_modify_nickname_editText);
        editdelect = (ImageView) findViewById(R.id.my_modify_nickname_editdelect);

    }

    @Override
    protected void initEvents() {
        nickname.addTextChangedListener(textWatcher);
        editdelect.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        String nicknameData = nickname.getText().toString();
        Log.i("tag",nicknameData);

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
        if (v.getId()==R.id.my_modify_nickname_editdelect){
            nickname.setText("");
        }
    }
}
