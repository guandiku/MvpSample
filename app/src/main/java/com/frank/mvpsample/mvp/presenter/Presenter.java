package com.frank.mvpsample.mvp.presenter;

import com.frank.mvpsample.mvp.model.IModel;
import com.frank.mvpsample.mvp.model.ModelImp;
import com.frank.mvpsample.mvp.view.IView;

/**
 * Created by White on 2018/3/23.
 */

public class Presenter implements IPresenter, ModelImp.LoadDataCallBack {

    private IView iView;
    private ModelImp iModel;

    public Presenter(IView iView){
        this.iView=iView;
        iModel = new ModelImp();
    }

    @Override
    public void loadData() {
        iView.showLoadingProgress("数据加载中");
        iModel.getDate(this);
    }

    @Override
    public void success(String taskId) {
        iView.showData(taskId);
    }

    @Override
    public void failure() {

    }
}
