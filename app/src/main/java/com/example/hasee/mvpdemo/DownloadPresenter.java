package com.example.hasee.mvpdemo;

/**
 * Presenter 具体实现
 */
public class DownloadPresenter implements IDowndownPresenter{
    private IDownloadView mIDownloadView;
    private IDownloadModel mIDownloadModel;

    public DownloadPresenter(IDownloadView iDownloadView){
        mIDownloadView = iDownloadView;
        mIDownloadModel = new DownloadModel(this);
    }
    @Override
    public void download(String url) {
        mIDownloadView.showProgressBar(true);
        mIDownloadModel.download(url);

    }

    @Override
    public void downloadSuccess(String result) {
        mIDownloadView.showProgressBar(false);
        mIDownloadModel.download(result);

    }

    @Override
    public void downloadProgress(int progress) {
        mIDownloadView.setProcessProgress(progress);

    }

    @Override
    public void downloadFail() {
        mIDownloadView.showProgressBar(false);
        mIDownloadView.showFailToast();

    }
}
