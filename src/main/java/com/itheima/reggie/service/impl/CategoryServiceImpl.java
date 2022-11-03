package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.mapper.CategoryMapper;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Solitude
 * @Data: 2022/11/2 20:57
 * @Description:
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，在删除之前需要先进行判断
     * @param id
     * 代码讲解：
     * https://blog.csdn.net/weixin_41629964/article/details/122836988
     */
    @Override
    public void remove(Long id) {

        LambdaQueryWrapper<Dish> disLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加查询条件，根据CategoryId进行查询，具体的值是传入的id
        disLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(disLambdaQueryWrapper);
        // 查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if(count1 > 0) {
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联菜品，不能删除");
        }
        // 查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加查询条件，根据分类id进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if(count2 > 0) {
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联套餐，不能删除");
        }

        // 上述两种都没有关联则可以正常删除当前分类
        super.removeById(id);
    }
}
