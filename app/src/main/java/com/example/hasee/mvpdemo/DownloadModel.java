package com.example.hasee.mvpdemo;

import android.os.Message;
import android.provider.SyncStateContract;

/**
 * Model的具体实现类 Model的工作就是完成具体的业务操作，网络请求，持久化数据增删改查等任务。
 */
public class DownloadModel implements IDownloadModel{
    private IDowndownPresenter mIDowndownPresenter;

    public DownloadModel(IDowndownPresenter iDowndownPresenter){
        mIDowndownPresenter = iDowndownPresenter;
    }

    @Override
    public void download(String url) {
        //具体的网络逻辑
      //  HttpUtil.HttpGet(url, new DownloadCallback(mMyHandler));

    }
//将Http任务的结果返回到Handler当中，而在Handler中的实现又是由Presenter完成
    class MyHandler extends android.os.Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 300:
                    int percent = msg.arg1;
                    if (percent < 100){
                        mIDowndownPresenter.downloadProgress(percent);
                    }else {
                        mIDowndownPresenter.downloadSuccess(Constants.LOCAL_FILE_PATH));
                    }
                    break;

                case 404:
                    mIDowndownPresenter.downloadFail();
                    break;
                default:
                    break;
            }
        }
    }



}
