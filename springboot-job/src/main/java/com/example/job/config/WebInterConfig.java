package com.example.job.config;

import com.example.job.interceptor.AccessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author : wangye
 * @date: 2020-12-21
 * @description:
 */

@Configuration
public class WebInterConfig implements WebMvcConfigurer {

    private static List<String> urls = Arrays.asList("http://localhost","http://www.wangye.com");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
    }

    /**
     * 通过过滤器实现CORS拦截，对拦截器也是有效
     */
    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了 写* 表示在所有的域名下都可以跨域访问
//        config.addAllowedOrigin("*");
        // urls  表示只能在指定的域名下，进行访问，例如只能以下两个页面下 按F12 选中控制台执行脚本
        config.setAllowedOrigins(urls);
         // 允许任何头
        config.addAllowedHeader("*");
         // 允许任何方法（post、get等）
//        config.addAllowedMethod("*");
        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        //3) 允许的请求方式  单独写
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");

        //3) 允许的请求方式  允许所有的
//        config.addAllowedMethod("*");

        // 5)配置有效时长
        config.setMaxAge(3600*24L);

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }






}
