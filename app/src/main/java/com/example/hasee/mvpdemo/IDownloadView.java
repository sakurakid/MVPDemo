package com.example.hasee.mvpdemo;

/**
 * View 接口 处理具体的视图逻辑
 */
public interface IDownloadView {
    /**
     * 显示进度条
     * @param show
     */
    void showProgressBar(boolean show);

    /**
     * 显示进度条
     * @param progress
     */
    void setProcessProgress(int progress);

    /**
     * 根据数据显示view
     * @param result
     */
    void setView(String result);

    /**
     * 设置请求失败的view
     */
    void showFailToast();
}
