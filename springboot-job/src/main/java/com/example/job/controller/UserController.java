package com.example.job.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.job.config.SpringWrapper;
import com.example.job.config.UserIdentManager;
import com.example.job.entity.ResultVO;
import com.example.job.entity.User;
import com.example.job.service.IUserService;
import com.example.job.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    @Autowired
    private UserIdentManager manager;


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

    @GetMapping("/a")
    public String gettest(String id){
        HttpUtil.curl();
        System.out.println("Ddddddddd");
        return id;
    }
    @PostMapping("/b")
    public String gettest1(String id,int a){
        HttpUtil.curl();
        System.out.println(id+"<--Ddddddddd-->"+a);
        return id;
    }




    @PostMapping("/c")
    public String gettest1(){
        Map<String, User> a = manager.a();
        HttpUtil.curl();
        return a.toString();
    }
}
