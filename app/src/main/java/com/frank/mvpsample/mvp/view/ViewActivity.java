package com.frank.mvpsample.mvp.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frank.mvpsample.R;
import com.frank.mvpsample.mvp.presenter.Presenter;

import java.lang.ref.WeakReference;

/**
 * Created by White on 2018/3/23.
 */

public class ViewActivity extends AppCompatActivity implements IView {

    private Button mButton;
    private TextView mTextView;
    private MyHandler myHandler = new MyHandler(ViewActivity.this);
    private Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mButton = (Button) findViewById(R.id.btn);
        mTextView = (TextView) findViewById(R.id.tv);
        presenter = new Presenter(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadData();
            }
        });


    }

    @Override
    public void showLoadingProgress(final String message) {
        myHandler.post(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(message);
            }
        });
    }

    @Override
    public void showData(final String text) {
        myHandler.post(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(text);
            }
        });
    }

    private class MyHandler extends Handler {

        //弱引用，防止内存泄露
        //android四种引用方式：https://blog.csdn.net/qq_20280683/article/details/77897876
        WeakReference<ViewActivity> weakReference;

        MyHandler(ViewActivity viewActivity) {
            this.weakReference = new WeakReference<>(viewActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    weakReference.get().mTextView.setText(msg.what);
            }
        }
    }
}
