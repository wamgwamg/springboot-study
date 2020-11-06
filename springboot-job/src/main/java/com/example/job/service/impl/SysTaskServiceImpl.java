package com.example.job.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.job.dao.SysTaskMapper;
import com.example.job.entity.SysTask;
import org.springframework.stereotype.Service;

/**
 * @author : wangye
 * @date: 2020-10-09
 * @description:
 */
@Service
public class SysTaskServiceImpl extends ServiceImpl<SysTaskMapper, SysTask> implements IService<SysTask> {

}
