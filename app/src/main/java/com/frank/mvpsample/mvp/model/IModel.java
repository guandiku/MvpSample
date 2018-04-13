package com.frank.mvpsample.mvp.model;

/**
 * Created by White on 2018/3/23.
 *
 * Model层接口---实现该接口的类负责实际的获取数据操作，如数据库读取，网络加载
 */

public interface IModel {

    void getDate(ModelImp.LoadDataCallBack callBack);

}
