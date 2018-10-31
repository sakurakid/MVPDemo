package com.example.hasee.mvpdemo;

/**
 * 管家处理
 */
public class Main2Presenter {
    private static final String TAG = "Main2Presenter";

    private IMain2View mview; //View接口的对象

    public Main2Presenter(IMain2View view){
        this.mview = view;
    }
    //管家处理的逻辑
    public void login(String username,String password){
        if (username.isEmpty()||password.isEmpty()){
            mview.LoginFailed("账号密码不能为空");
        }else if (username.length() < 8||password.length() < 9){
            mview.LoginFailed("账号至少8位，密码至少9位");
        }else if(username.equals())
    }
}
