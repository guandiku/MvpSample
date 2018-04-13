package com.frank.mvpsample.mvp.view;

/**
 * Created by White on 2018/3/23.
 *
 * 执行各种UI操作，定义的方法主要是给Presenter中来调用的
 */

public interface IView {
    void showLoadingProgress(String message);
    void showData(String text);
}
