package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Hairo
 * @since 2020-03-26 16:50:42
 * 小区站型范围
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CellType implements Serializable {

    /**
     * 未知
     */
    Unknown("未知覆盖范围"),

    /**
     * 室内
     */
    Indoor("室内"),

    /**
     * 宏站
     */
    MacroStation("宏站"),

    /**
     * 微小
     */
    Tiny("微小");


    /**
     * 站型
     */
    private String stationType;

}
