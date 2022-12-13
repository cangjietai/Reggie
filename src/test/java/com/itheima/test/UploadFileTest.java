package com.itheima.test;

import org.junit.jupiter.api.Test;

/**
 * @Author: Solitude
 * @Data: 2022/12/7 00:26
 * @Description:
 */
public class UploadFileTest {

    @Test
    public void test1() {
        String fileName = "vdewvdgevwi.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
