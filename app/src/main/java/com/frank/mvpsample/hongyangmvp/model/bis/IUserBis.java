package com.frank.mvpsample.hongyangmvp.model.bis;

/**
 * Created by White on 2018/3/23.
 */

public interface IUserBis {
    void login(String userName,String password,UserBis.OnLoginListener loginListener);
}
