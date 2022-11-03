package com.itheima.reggie.common;

/**
 * @Author: Solitude
 * @Data: 2022/11/4 00:13
 * @Description:
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }

}
