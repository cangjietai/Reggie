package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Solitude
 * @Data: 2022/10/24 23:36
 * @Description:
 * 继承mybatisplus的BaseMapper,实现了常见的增删改查方法
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
