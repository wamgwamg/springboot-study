package com.example.job.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.job.entity.ResultVO;
import com.example.job.entity.User;
import com.example.job.service.IUserService;
import com.example.job.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : wangye
 * @date: 2020-11-05
 * @description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;


    @PostMapping("/addUser")
    public ResultVO addUser(@RequestBody User userList){
        log.info("添加信息{}",userList.toString());
        boolean b = userService.save(userList);
        return new ResultVO("a");
    }

    @PostMapping("/getUser")
    public ResultVO getUser(String id){
        User user = userService.getOne(new QueryWrapper<User>().eq("id", id));
        return new ResultVO(user);
    }
}
