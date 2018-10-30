package com.example.hasee.mvpdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private ImageView mImageView;
    private Handler mHandler;
    private ProgressDialog progressDialog;
    private Button btnsuccess;
    private Button btnfail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

    }
    private void init(){
        mImageView = (ImageView)findViewById(R.id.image);
        btnsuccess = (Button)findViewById(R.id.btn_downsuccess);
        btnfail = (Button)findViewById(R.id.btn_downfail);
        mHandler = new Handler();
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressDialog.dismiss();
            }
        });

        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("下载文件");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        btnsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                //发送请求
            }
        });
        btnfail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                //请求
            }
        });

    }
    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 300:
                    int percent = msg.arg1;
                    if (percent < 100) {
                        progressDialog.setProgress(percent);
                    } else {
                        progressDialog.dismiss();
                        //
                        // 加载进来
                        // Glide.with(mContext).load(Constants.LOCAL_FILE_PATH).into(mImageView);
                    }
                    break;
                case 404:
                    progressDialog.dismiss();
                    Toast.makeText(mContext, "Download fail !", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
