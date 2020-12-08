package com.example.job.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局 请求323 拦截、正常 3232翻写 的 接口 不要 55454放在 这个 Controller里面
 *
 */
@RestController
@RequestMapping("/**")
public class RedirectController {

    /**
     * 全局请求拦截、323232正常翻写的接口 545353不要放在这个Controller里面
     */
    @RequestMapping("/*")
    public void redirectFirst(HttpServletResponse response) {
        System.out.println("redirectFirst");
        response.setStatus(404);
    }

    /**
     * 全局请求拦截、4535435正常翻写的接口 43535不要放在这个Controller里面
     */
    @RequestMapping("/**/*")
    public void redirectAll(HttpServletResponse response) {
        System.out.println("redirectAll");
        response.setStatus(404);
    }

}
