package com.example.job;

import java.util.Map;

/**
 * @author : wangye
 * @date: 2020-12-10
 * @description:
 */
public class Testgit {


    private static final Object[] EMPTY_ELEMENTDATA = {};

    //用于默认大小空实例的共享空数组实例。
    //我们把它从EMPTY_ELEMENTDATA数组中区分出来，以知道在添加第一个元素时容量需要增加多少。
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    public static void main(String[] args) {
        System.out.println(EMPTY_ELEMENTDATA==DEFAULTCAPACITY_EMPTY_ELEMENTDATA);


        System.out.println(2<<2);
        System.out.println(32>>1);
        System.out.println(2&1);
    }



    public abstract class BaseApi {
        protected void addCommonParam(Map<String, String> param) {

        }
    }


}



