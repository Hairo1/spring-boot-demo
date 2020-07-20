package com.hairo.springbootswagger2.bean.enums;

import lombok.Getter;

/**
 * @author ： Hairo
 * @date : 2020/3/30 22:39
 * 优先级枚举(A-G)
 */
@Getter
public enum PriorityType {

    /**
     * 优先级1
     */
    A,

    /**
     * 优先级2
     */
    B,

    /**
     * 优先级3
     */
    C,

    /**
     * 优先级4
     */
    D,

    /**
     * 优先级5
     */
    E,

    /**
     * 优先级6
     */
    F,

    /**
     * 优先级7
     */
    G,

    /**
     * 未知优先级别
     */
    Unknown;

    private String priority;

}
