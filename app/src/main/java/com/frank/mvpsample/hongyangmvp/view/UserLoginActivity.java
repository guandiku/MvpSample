package com.frank.mvpsample.hongyangmvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.Toast;

import com.frank.mvpsample.R;
import com.frank.mvpsample.hongyangmvp.model.bean.User;
import com.frank.mvpsample.hongyangmvp.presenter.UserLoginPresenter;

/**
 * Created by White on 2018/3/23.
 */

public class UserLoginActivity extends Activity implements IUserLoginView {

    private EditText mEtUsername, mEtPassword;
    private ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        mUserLoginPresenter = new UserLoginPresenter(this);
        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.editText);
        mEtPassword = (EditText) findViewById(R.id.editText2);
        mPbLoading = (ProgressBar) findViewById(R.id.progressBar);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });


    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUserName() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
