package com.example.job.utils;

import com.example.job.config.SpringWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author pasta
 * @date 2019-03-01
 */
@Slf4j
public class HttpCurl {


    public static void curl(){
        HttpServletRequest request = SpringWrapper.getRequest();
        StringBuffer url = request.getRequestURL();
        String parameter = parameter(request.getParameterMap());
        log.info("curl '{}' -d '{}'",url,parameter);
    }

    public static String parameter(Map<String, String[]> map){
        if (map==null || map.size()==0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        map.forEach((k,v)->buffer.append(k).append("=").append(v[0]).append("&"));

        return buffer.deleteCharAt(buffer.length()-1).toString();

    }
}
