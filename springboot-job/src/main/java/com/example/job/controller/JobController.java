package com.example.job.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.job.entity.SysTask;
import com.example.job.service.SysTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangye
 * @date: 2020-09-18
 * @description: 定时任务
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    public SysTaskServiceImpl sysTaskService;


    @RequestMapping(method = RequestMethod.GET, path = "/getList")
    public SysTask getList(String id) {

        return sysTaskService.getOne(new QueryWrapper<SysTask>().eq("id", id));
    }
}
