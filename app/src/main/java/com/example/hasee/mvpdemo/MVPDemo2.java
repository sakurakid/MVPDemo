package com.example.hasee.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MVPDemo2 extends AppCompatActivity implements IMain2View,View.OnClickListener{
    private static final String TAG = "MVPDemo2";
    private static final String USENAME = "张三";
    private static final String PASSWORD = "233333";

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Main2Presenter main2Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo2);
    }
    private void init(){
        et_username = (EditText)findViewById(R.id.et_usename);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        //让管家去管理处理
        main2Presenter = new Main2Presenter(this);
    }

    @Override
    public void Loginsuccess() {
        Log.d(TAG,"管家说登陆成功");

    }

    @Override
    public void LoginFailed(String s) {
        Log.d(TAG,"登陆失败 原因是"+s);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                //然后让自己的管家去处理登陆事件
                main2Presenter.login(username,password);
                break;
        }
    }
}
