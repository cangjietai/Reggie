package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Author: Solitude
 * @Data: 2022/10/30 16:42
 * @Description:
 * 全局异常处理
 */
// 只要类上加了这两个注解，就会被该处理器进行处理
@ControllerAdvice(annotations = {RestController.class, Controller.class})
// 该方法需要返回json数据
@ResponseBody
// 方便输出日志
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error(ex.getMessage());
        // Duplicate entry 'zhangsan' for key 'idx_username'
        if(ex.getMessage().contains("Duplicate entry")) {
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在";
            return R.error(msg);
        }
        return R.error("未知错误");
    }

}
