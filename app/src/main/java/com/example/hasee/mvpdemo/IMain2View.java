package com.example.hasee.mvpdemo;

public interface IMain2View {
    /**
     * 登陆成功的 管家会处理这个
     */
    void Loginsuccess();

    /**
     * 登陆失败的
     * @param s   管家会处理这个
     */
    void LoginFailed(String s);
}
