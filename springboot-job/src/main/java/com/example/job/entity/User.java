package com.example.job.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author : wangye
 * @date: 2020-11-05
 * @description:
 */
@Builder
@Data
@ToString
public class User {
    //用户
    private String userName;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //身份证号
    private String idCard;
    //备用字段
    private Integer a;


//    private String province;
//    private String city;
//    private String county;


}
