package com.example.job.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : wangye
 * @date: 5/28/21
 * @description:
 */

@Data
@AllArgsConstructor
public class Person {

    //用户
    private String userName;
    //手机号
    private Integer phone;
    //邮箱
    private Double email;


}
