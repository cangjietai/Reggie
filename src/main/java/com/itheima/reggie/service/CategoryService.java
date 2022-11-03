package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * @Author: Solitude
 * @Data: 2022/11/2 20:57
 * @Description:
 */
public interface CategoryService extends IService<Category> {

    void remove(Long id);

}
