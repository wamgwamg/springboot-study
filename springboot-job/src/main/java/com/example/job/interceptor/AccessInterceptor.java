package com.example.job.interceptor;


import com.example.job.comm.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author
 * @date 2018-07-18 16:31:56
 */
@Component
@Slf4j
public class AccessInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String token = request.getParameter("token");
//        logger.info("===当前token："+ token + " === "+LocalDateTime.now());
//        if(StringUtils.isEmpty(token)) {
//            token = request.getHeader("token");
//        }
//        if(StringUtils.isNotEmpty(token)){
//            String uid = redisService.get(token);
//            if(StringUtils.isNotEmpty(uid)){
//                redisService.expire(token, 60*30);
//                logger.info("===当前登录人："+ uid + " ==="+LocalDateTime.now());
        String uuid = UUID.randomUUID().toString();
        MDC.put(CommonConstants.LOGIN_UID, uuid);
        log.info("拦截器获得uuid-->{}",uuid);
        return true;
//            }
//        }
//        throw new Exception("请重新登录");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(CommonConstants.LOGIN_UID);
    }
}
