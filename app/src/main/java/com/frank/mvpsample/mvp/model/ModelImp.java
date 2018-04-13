package com.frank.mvpsample.mvp.model;

/**
 * Created by White on 2018/3/23.
 * <p>
 * 实现IModel接口， 负责实际的数据获取操作(数据库读取，网络加载等)，然后通过自己的接口（LoadDataCallBack）反馈出去
 */

public class ModelImp implements IModel {
    @Override
    public void getDate(final ModelImp.LoadDataCallBack callBack) {

        //数据获取操作，如数据库查询，网络加载等
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟耗时操作
                    Thread.sleep(2000);
                    //获取到了数据
                    String data = "我是获取到的数据";
                    //将数据通过接口反馈出去
                    callBack.success(data);
                } catch (Exception e) {
                    e.printStackTrace();
                    callBack.failure();
                }
            }
        }).start();

    }


    public interface LoadDataCallBack {

        void success(String taskId);

        void failure();
    }
}
