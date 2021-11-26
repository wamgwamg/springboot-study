package com.example.job.controller;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.job.config.UserIdentManager;
import com.example.job.entity.ResultVO;
import com.example.job.entity.User;
import com.example.job.service.IUserService;
import com.example.job.utils.HttpCurl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResultVO addUser(@RequestBody User userList) {
        log.info("添加信息{}", userList.toString());
        boolean b = userService.save(userList);
        return new ResultVO("a");
    }

    @PostMapping("/getUser")
    public ResultVO getUser(String id) {
        User user = userService.getOne(new QueryWrapper<User>().eq("id", id));
        return new ResultVO(user);
    }

    @GetMapping("/a")
    public String gettest(String id) {
        HttpCurl.curl();
        System.out.println("Ddddddddd");
        return id;
    }

    @PostMapping("/b")
    public String gettest1(String id, int a) {
        HttpCurl.curl();
        System.out.println(id + "<--Ddddddddd-->" + a);
        return id;
    }


    /**
     * description:
     *   curl -i 'http://localhost/user/c' -d 'id=89'
     * @param
     * @return
     */
    @PostMapping("/c")
    public String gettest1(String id ) {
        Map<String, User> a = manager.a();
        HttpCurl.curl();
        return a.toString();
    }

    /**
    * description: curl -i 'http://localhost/user/d' -d 'id=8978'
    * @return
    * @param null
    */
    @PostMapping("/d")
    public String gettest2(String id) {
        Map map = new HashMap();
        map.put("number",id);
        String post = HttpUtil.post("http://127.0.0.1:8080/v2/passport/inner/setSearchMemberValue", map);
        System.out.println("&&&&"+post);
        HttpCurl.curl();
//        System.out.println(id + "<--Ddddddddd-->" + a);
        return id;
    }
}
