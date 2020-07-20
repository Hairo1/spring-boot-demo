package com.hairo.springbootswagger2.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * AreaType 区域枚举
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AreaType implements Serializable {

    /**
     * 主城区
     */
    MainUrbanArea("主城区"),

    /**
     * 一般城区
     */
    GeneralUrbanArea("一般城区"),

    /**
     * 县城区
     */
    CountyUrbanArea("县城区"),

    /**
     * 乡镇
     */
    Township("乡镇"),

    /**
     * 乡村
     */
    Country("乡村"),

    /**
     * 其他区域
     */
    Else("其他区域"),

    /**
     * 未知区域
     */
    Unknown("未知区域");

    private String areaEnum;
}
