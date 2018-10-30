package com.example.hasee.mvpdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * View层的实现就是activity
 */
public class MVPActivity extends AppCompatActivity implements IDownloadView {
    private Context mContext;
    private ImageView mImageView;
    private ProgressDialog progressDialog;

    private DownloadPresenter mDownloadPresenter;
    private Button btnsuccess;
    private Button btnfail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //setView(R.layout.activity_main);
        init();
    }
    private void init(){
        mDownloadPresenter = new DownloadPresenter(this);
        mImageView = (ImageView)findViewById(R.id.image);
        btnsuccess = (Button)findViewById(R.id.btn_downsuccess);
        btnfail = (Button)findViewById(R.id.btn_downfail);
        btnsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDownloadPresenter.download(SyncStateContract.Constants);
            }
        });
        btnfail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDownloadPresenter.download(SyncStateContract.Constants.CONTENT_DIRECTORY);
            }
        });

        progressDialog = new ProgressDialog(mContext);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressDialog.dismiss();
            }
        });
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("下载文件");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show){
            progressDialog.show();
        }else {
            progressDialog.dismiss();
        }

    }

    @Override
    public void setProcessProgress(int progress) {
        progressDialog.setProgress(progress);
    }

    @Override
    public void setView(String result) {
        //加载图片

    }

    @Override
    public void showFailToast() {
        Toast.makeText(mContext,"Download fail",Toast.LENGTH_SHORT).show();

    }
}
