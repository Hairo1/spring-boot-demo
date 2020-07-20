package com.hairo.springbootmybatis_enum.code.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

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

    private String label;

    @JsonValue
    @Override
    public String toString() {
        return label;
    }

    @JsonCreator
    public static AreaType formLabel(String value) {
        return Arrays.stream(AreaType.values())
                .filter(e -> e.getLabel().equals(value))
                .findFirst()
                .orElse(AreaType.Unknown);
    }

}
