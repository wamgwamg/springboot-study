package com.example.job.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : wangye
 * @date: 2020-12-09
 * @description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "application")
public class TestConfig {
    public String environment;



}
