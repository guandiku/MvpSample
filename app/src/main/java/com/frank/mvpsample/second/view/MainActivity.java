package com.frank.mvpsample.second.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frank.mvpsample.R;
import com.frank.mvpsample.second.presenter.WetherPresenter;

public class MainActivity extends AppCompatActivity implements IWetherView{
    private static final String TAG = "MainActivity";

    WetherPresenter mPresenter;
    private TextView mTvInfo;
    private Button mButton;
    private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new WetherPresenter(this);

        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mButton = (Button) findViewById(R.id.btn_request);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.requestWetherInfo();
            }
        });

        mPresenter.requestWetherInfo();
    }

    @Override
    public void onInfoUpdate(final String info) {
        Log.d(TAG, "onInfoUpdate: "+info);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvInfo.setText(info);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mDialog != null && mDialog.isShowing()){
                    mDialog.dismiss();
                }

                mDialog = ProgressDialog.show(MainActivity.this,"","正在获取中...");
            }
        });

    }

    @Override
    public void dismissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mDialog != null && mDialog.isShowing()){
                    mDialog.dismiss();
                }
            }
        });

    }
}
