package com.example.job.entity;

import com.example.job.enums.ResultCode;



/**
 * @author : wangye
 * @date: 2020-11-04
 * @description:
 */
public class ResultVO<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String message;
    /**
     * 响应的具体数据
     */
    private T data;


    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }


    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO() {

    }
    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
