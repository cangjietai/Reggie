package com.itheima.reggie.common;

/**
 * @Author: Solitude
 * @Data: 2022/11/2 00:52
 * @Description:
 * 基于ThreadLocal封装的工具类，用于保存和获取当前登录用户 的id
 * 工具方法通常用static修饰
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
