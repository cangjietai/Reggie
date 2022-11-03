package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: Solitude
 * @Data: 2022/10/24 23:27
 * @Description:
 * 员工实体
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 注意是username不是userName,对应的是数据库中的username
    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;// 身份证号码   数据库字段id_number  根据配置文件中的映射规则进行驼峰映射

    private Integer status;

    // createTime  对应数据库中的 create_time
    @TableField(fill = FieldFill.INSERT)   // 插入时填充字段
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)  // 插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)  // 插入时填充字段
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)  // 插入和更新时填充字段
    private Long updateUser;

}
