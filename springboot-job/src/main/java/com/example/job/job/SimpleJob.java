package com.example.job.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : wangye
 * @date: 2020-11-04
 * @description:   只需要在启动类上添加 @EnableScheduling 即可
 */
@Component
public class SimpleJob {

    private int count = 0;

    /**
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param
     * @return void
     **/
    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running " + (count++));
    }
}
