package com.example.job.controller;

import cn.hutool.json.JSON;
import com.example.job.entity.ResultVO;
import com.example.job.enums.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : wangye
 * @date: 2020-11-04
 * @description:
 */
public class BaseController {
    /**
     * 统一异常处理
     * 打印异常信息e
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResultVO<String> exceptionHandler(ArithmeticException e) {
// 注意哦，这里传递的响应码枚举
        return new ResultVO(ResultCode.FAILED, e.getMessage());
    }



    @ExceptionHandler(IllegalArgumentException.class)
    public ResultVO<String> APIExceptionHandler(IllegalArgumentException e) {
// 注意哦，这里传递的响应码枚举

        return new ResultVO(ResultCode.VALIDATE_FAILED, e.getMessage());
    }

}
