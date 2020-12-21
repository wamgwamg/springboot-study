package com.example.job.config;

import com.example.job.interceptor.AccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : wangye
 * @date: 2020-12-21
 * @description:
 */

@Configuration
public class WebInterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
    }
}
