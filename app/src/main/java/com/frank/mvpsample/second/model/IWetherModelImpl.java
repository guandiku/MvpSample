package com.frank.mvpsample.second.model;

import java.util.Random;

/**
 * Created by ly-zhaominglai on 2016/10/18.
 */

public class IWetherModelImpl implements IWetherModel {

    @Override
    public String getInfo() {
        Random r = new Random();
        int seed = r.nextInt(3);

        if(seed % 2 == 0){
            return "21度，晴转多云";
        }else{
            return "22度，晴";
        }
    }

    @Override
    public void setInfo(String info) {

    }
}
