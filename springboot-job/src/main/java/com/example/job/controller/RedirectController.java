package com.example.job.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 拦截恶意路径的请求
 */
@RestController
@RequestMapping("/**")
@Slf4j
public class RedirectController {

    /**
     * 匹配这种请求  curl -i 'http://localhost/k' -d 'id=89'  ；curl -i 'http://localhost' -d 'id=89'
     */
    @RequestMapping("/*")
    public void redirectFirst(HttpServletResponse response) {
        log.info("redirectFirst");
        response.setStatus(404);
    }

    /**
     * 匹配这种请求  curl -i 'http://localhost/user/cd/k/k/l' -d 'id=89'
     */
    @RequestMapping("/**/*")
    public void redirectAll(HttpServletResponse response) {
        log.info("redirectAll");
        response.setStatus(404);


    }


}
