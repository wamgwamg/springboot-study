package com.example.job;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.job.dao")
/**去掉 DruidDataSourceAutoConfigure在DynamciDataSourceAutoConfiguration之前，其会注入一个DataSourceWrapper，
会在原生的spring.datasource下找url,username,password等。而我们动态数据源的配置路径是变化的。
 在启动类加 @SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
 或者在yml 添加


 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

}
