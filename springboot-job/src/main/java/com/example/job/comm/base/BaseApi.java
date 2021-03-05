package com.example.job.comm.base;

import java.util.Map;

/**
 * @author : wangye
 * @date: 2021-03-05
 * @description:
 */

public abstract class BaseApi {

   public void urlApi(Map<String, String> param){
        addCommonParam(param);
    }

    protected void addCommonParam(Map<String, String> param) {

    }
}