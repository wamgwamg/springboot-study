package com.example.job.comm.base;

import org.apache.commons.collections4.Put;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : wangye
 * @date: 2021-03-05
 * @description:
 */
public class PayApi extends BaseApi{


    @Override
    public void addCommonParam(Map<String, String> param){

    }

    public static void main(String[] args) {
        PayApi payApi = new PayApi();
        HashMap<String, String> map = new HashMap<>();
        map.put("xiao","打");
        payApi.urlApi(map);
    }
}
