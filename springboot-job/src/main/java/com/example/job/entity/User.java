package com.example.job.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

/**
 * @author : wangye
 * @date: 2020-11-05
 * @description:
 */
@Builder
@Data
public class User {
    private String userName;
    private String phone;
    private String email;
    private String idCard;

//    private String province;
//    private String city;
//    private String county;


}
