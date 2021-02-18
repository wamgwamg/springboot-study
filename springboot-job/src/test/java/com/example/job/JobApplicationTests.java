package com.example.job;

import com.example.job.config.ApiConfig;
import com.example.job.config.TestConfig;
import com.example.job.config.UserIdentManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class JobApplicationTests {

    @Resource
    TestConfig testConfig;

    @Autowired
    ApiConfig apiConfig;

    @Autowired
    UserIdentManager manager;

    @Test
    void contextLoads() {

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        c(a,b);
        System.out.println(a+"&&&&&"+b);
        d();
    }

    public static void c(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }

    public  void d(){
        System.out.println(testConfig.getEnvironment());//我是是分支master
//        apiConfig.appcontract
    }

}
