package com.example.job.entity;

/**
 * @author : wangye
 * @date: 2020-11-05
 * @description:
 */

public class Location {

    private String province;
    private String city;
    private String county;
    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setCounty(String county) {
        this.county = county;
    }
    public String getCounty() {
        return county;
    }

}