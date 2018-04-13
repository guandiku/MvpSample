package com.frank.mvpsample.second.model;

/**
 * Created by ly-zhaominglai on 2016/10/18.
 */

public interface IWetherModel {

    //提供数据
     String getInfo();

    //存储数据
     void setInfo(String info);
}
