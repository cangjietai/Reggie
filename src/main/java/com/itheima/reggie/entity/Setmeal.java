package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: Solitude
 * @Data: 2022/11/3 23:39
 * @Description:
 * 套餐
 */
@Data
public class Setmeal implements Serializable {

    private static final long serialVersionID = 1L;

    private Long id;

    // 分类id
    private Long categoryId;

    // 套餐名称
    private String name;

    // 套餐价格
    private BigDecimal price;

    // 状态：0,停用  1,启用
    private Integer status;

    // 编码
    private String code;

    // 描述信息
    private String description;

    // 图片
    private String image;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;




}
