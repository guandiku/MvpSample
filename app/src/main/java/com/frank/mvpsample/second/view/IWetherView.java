package com.frank.mvpsample.second.view;

/**
 * Created by ly-zhaominglai on 2016/10/18.
 */

public interface IWetherView {

     void onInfoUpdate(String info);

     void showWaitingDialog();

     void dismissWaitingDialog();
}
