package com.frank.mvpsample.hongyangmvp.view;

import com.frank.mvpsample.hongyangmvp.model.bean.User;

/**
 * Created by White on 2018/3/23.
 */

/**
 * 所有的方法都写在这个接口里
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
