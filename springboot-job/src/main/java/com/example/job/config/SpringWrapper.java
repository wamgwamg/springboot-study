package com.example.job.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Component
public class SpringWrapper implements ServletContextListener {

    private static WebApplicationContext applicationContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public static ApplicationContext getApplicationContext() {

        return applicationContext;
    }


    public static <T> T getBean(Class<T> type) throws BeansException {

        return applicationContext.getBean(type);
    }

    public static Object getBean(String name) throws BeansException {

        return applicationContext.getBean(name);
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        return requestAttributes !=null ? requestAttributes.getRequest() : null;
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        return requestAttributes !=null ? requestAttributes.getResponse() : null;
    }

}
