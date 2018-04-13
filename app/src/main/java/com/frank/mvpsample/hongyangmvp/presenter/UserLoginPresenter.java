package com.frank.mvpsample.hongyangmvp.presenter;

import android.os.Handler;

import com.frank.mvpsample.hongyangmvp.model.bean.User;
import com.frank.mvpsample.hongyangmvp.model.bis.IUserBis;
import com.frank.mvpsample.hongyangmvp.model.bis.UserBis;
import com.frank.mvpsample.hongyangmvp.view.IUserLoginView;

/**
 * Created by White on 2018/3/23.
 *
 * 与User交互，通过业务逻辑
 *
 */

public class UserLoginPresenter {
    private IUserBis userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBis();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new UserBis.OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

}
