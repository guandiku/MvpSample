package com.frank.mvpsample.hongyangmvp.model.bis;

import com.frank.mvpsample.hongyangmvp.model.bean.User;

/**
 * Created by White on 2018/3/23.
 */

public class UserBis implements IUserBis {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUserName(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }


    public interface OnLoginListener {
        void loginSuccess(User user);

        void loginFailed();
    }
}
