package com.hairo.springbootmybatis_enum.code.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

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
     * 宏站
     */
    MacroStation("宏站"),

    /**
     * 室内
     */
    Indoor("室内"),

    /**
     * 微小
     */
    Tiny("微小"),

    /**
     * 未知
     */
    Unknown("未知覆盖范围");

    private String label;

    @JsonValue
    @Override
    public String toString() {
        return label;
    }

    @JsonCreator
    public static CellType formLabel(String value) {
        return Arrays.stream(CellType.values())
                .filter(e -> e.getLabel().equals(value))
                .findFirst()
                .orElse(CellType.Unknown);
    }
}
