package com.example.job.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.job.entity.ResultVO;
import com.example.job.entity.SysTask;
import com.example.job.service.impl.SysTaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class JobController extends BaseController {

    @Autowired
    public SysTaskServiceImpl sysTaskService;


    @RequestMapping(method = RequestMethod.GET, path = "/getList")
    @DS("db0")
    public ResultVO getList(String id) {
        Assert.isTrue(StrUtil.isNotBlank(id),"参数不能为空");

        SysTask sysTask = sysTaskService.getOne(new QueryWrapper<SysTask>().eq("id", id));
        return new ResultVO(sysTask);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/getOne")
    @DS("db1")
    public ResultVO getOne(String id) {
        SysTask sysTask = sysTaskService.getOne(new QueryWrapper<SysTask>().eq("id", id));
        return new ResultVO(sysTask);
    }
}
