package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Hairo
 * @since 2020-03-26 16:50:42
 * 省份
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Province {

    /**
     * 广东省
     */
    GuangDong("广东省"),

    /**
     * 未知
     */
    Unknown("未知");

    private String provinceEnum;
}
