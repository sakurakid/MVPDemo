package com.example.hasee.mvpdemo;

/**
 * Presenter 接口作为连接Model和View的中间桥梁，需要将二者连接起来
 */
public interface IDowndownPresenter {
    /**
     * 下载
     * @param url
     */
    void download(String url);

    /**
     * 下载成功
     * @param result
     */
    void downloadSuccess(String result);

    /**
     * 当前下载进度
     * @param progress
     */
    void downloadProgress(int progress);
    /**
     * 下载失败
     */
    void downloadFail();
}
