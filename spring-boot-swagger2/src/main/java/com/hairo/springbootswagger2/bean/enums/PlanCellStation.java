package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ： Hairo
 * @date : 2020/5/13 21:50
 * 新建站状态
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum PlanCellStation implements Serializable {

    /**
     * 激活
     */
    Active("已激活"),

    /**
     * 重复
     */
    Duplicated("重复"),

    /**
     * 已配置
     */
    Configured("已配置"),

    /**
     * 创建
     */
    Created("创建");

    private String planCellStart;
}
